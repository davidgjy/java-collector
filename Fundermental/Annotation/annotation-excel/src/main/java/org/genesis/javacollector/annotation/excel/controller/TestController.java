package org.genesis.javacollector.annotation.excel.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.genesis.javacollector.annotation.excel.exception.ExcelTestException;
import org.genesis.javacollector.annotation.excel.pojo.User;
import org.genesis.javacollector.annotation.excel.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: TestController
 * @Package org.genesis.javacollector.annotation.excel.controller
 * @Description: test controller for annotation
 * @date 2018/8/27 09:47
 */
@RestController
@Api("swagger test")
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ExcelService excelService;

//    @RequestMapping(method = RequestMethod.GET)
//    @ApiOperation(value = "test method")
//    public TestResponse getTest() {
//        return new TestResponse();
//    }

    @RequestMapping(value="/excel/user", method = RequestMethod.POST)
    @ApiOperation(value = "test method")
    public List<User> getUserFromExcel(@RequestBody MultipartFile file) {
        try(InputStream is = file.getInputStream()) {
            Workbook wb = new XSSFWorkbook(is);
            Sheet sheet = wb.getSheetAt(0);
            return excelService.resolveSheet(sheet, User.class);
        } catch (IOException e) {
            throw new ExcelTestException("Read Excel Error");
        }
    }
}

