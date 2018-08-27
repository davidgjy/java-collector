package org.genesis.javacollector.annotation.excel.service;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * @author KG(Kelvin Gu)
 * @InterfaceName: ExcelService
 * @Package org.genesis.javacollector.annotation.excel.service
 * @Description: excel service interface
 * @date 2018/8/27 09:51
 */
public interface ExcelService {
    <T> List<T> resolveSheet(Sheet sheet, Class<T> clazz);
}
