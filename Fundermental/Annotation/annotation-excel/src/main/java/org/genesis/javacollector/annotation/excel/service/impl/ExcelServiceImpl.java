package org.genesis.javacollector.annotation.excel.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.genesis.javacollector.annotation.excel.annotation.ExcelCol;
import org.genesis.javacollector.annotation.excel.annotation.ExcelEntity;
import org.genesis.javacollector.annotation.excel.exception.ExcelTestException;
import org.genesis.javacollector.annotation.excel.service.ExcelService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: ExcelServiceImpl
 * @Package org.genesis.javacollector.annotation.excel.service.impl
 * @Description: excel service impl
 * @date 2018/8/27 09:53
 */
@Service
public class ExcelServiceImpl implements ExcelService {
    @Value("${test.excel.col.title.row.num}")
    private int colTitleRowNum;
    @Value("${test.excel.content.row.num}")
    private int contentRowNum;
    private final String SETTER_PREFIX = "set";

    @Override
    public <T> List<T> resolveSheet(Sheet sheet, Class<T> clazz) {
        List<T> entities = new ArrayList<>();
        Map<Integer, Field> fieldMap = mapColNumWithField(sheet, clazz);
        for (int i = contentRowNum; i <= sheet.getLastRowNum(); i++) {
            entities.add(resolveRow(sheet.getRow(i), clazz, fieldMap));
        }
        return entities;
    }

    private <T> T resolveRow(Row row, Class<T> clazz, Map<Integer, Field> fieldMap) {
        try {
            T entity = clazz.newInstance();
            for (Cell cell : row) {
                Field field = fieldMap.get(cell.getColumnIndex());
                setField(field, cell, entity);
            }
            return entity;
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            throw new ExcelTestException("setter method error");
        }
    }

    private <T> void setField(Field field, Cell cell, T entity) throws NoSuchMethodException {
        Method setter = createSetter(field, entity);
        Class[] paramTypes = setter.getParameterTypes();
        assignField(cell, paramTypes[0], setter, entity);
    }

    private <T> Method createSetter(Field field, T entity) {
        try {
            String setterName = createSetterName(field.getName());
            return entity.getClass().getDeclaredMethod(setterName, field.getType());
        } catch (NoSuchMethodException e) {
            throw new ExcelTestException("No Setter");
        }
    }

    private <T> void assignField(Cell cell, Class paramClass, Method setter, T entity) {
        try {
            if (paramClass.equals(Date.class)) {
                setter.invoke(entity, cell.getDateCellValue());
            } else if (paramClass.equals(String.class)) {
                setter.invoke(entity, cell.getStringCellValue());
            } else if (paramClass.equals(Integer.class)) {
                setter.invoke(entity, (int) cell.getNumericCellValue());
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ExcelTestException("Assign cell value error");
        }
    }

    private <T> Map<Integer, Field> mapColNumWithField(Sheet sheet, Class<T> clazz) {
        Row titleRow = sheet.getRow(colTitleRowNum);
        Map<String, Field> fieldMap = extractFieldMap(clazz);
        Map<Integer, Field> fieldColNumMap = new HashMap<>();
        for (Cell cell : titleRow) {
            cell.setCellType(CellType.STRING);
            Field field = fieldMap.get(cell.getStringCellValue());
            if (null != field) {
                fieldColNumMap.put(cell.getColumnIndex(), field);
            }
        }
        return fieldColNumMap;
    }

    private <T> Map<String, Field> extractFieldMap(Class<T> clazz) {
        checkResolvable(clazz);
        Map<String, Field> fieldMap = new HashMap<>();
        ArrayList<Field> fields = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        fields.stream().filter(field -> field.getAnnotation(ExcelCol.class).colName().length() > 0)
                .forEach(fieldForCol -> {
                    String colName = fieldForCol.getAnnotation(ExcelCol.class).colName();
                    fieldMap.put(colName, fieldForCol);
                });
        return fieldMap;
    }

    private <T> void checkResolvable(Class<T> clazz) {
        ExcelEntity annotation = clazz.getAnnotation(ExcelEntity.class);
        if (null == annotation) {
            throw new ExcelTestException("Entity is not made for excel conversion");
        }
    }

    private String createSetterName(String fieldName) {
        if (StringUtils.isEmpty(fieldName)) {
            throw new ExcelTestException("No Setter");
        }
        String firstLetter = fieldName.substring(0, 1).toUpperCase();
        return SETTER_PREFIX + firstLetter + fieldName.substring(1);
    }
}
