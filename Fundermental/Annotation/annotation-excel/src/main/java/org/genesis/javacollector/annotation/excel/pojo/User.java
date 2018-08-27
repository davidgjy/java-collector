package org.genesis.javacollector.annotation.excel.pojo;

import org.genesis.javacollector.annotation.excel.annotation.ExcelCol;
import org.genesis.javacollector.annotation.excel.annotation.ExcelEntity;

import java.util.Date;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: User
 * @Package org.genesis.javacollector.annotation.excel.pojo
 * @Description: user pojo
 * @date 2018/8/27 09:43
 */
@ExcelEntity
public class User {
    @ExcelCol(colName = "Name")
    private String name;
    @ExcelCol(colName = "Age")
    private Integer age;
    @ExcelCol(colName = "Date of Birth")
    private Date dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
