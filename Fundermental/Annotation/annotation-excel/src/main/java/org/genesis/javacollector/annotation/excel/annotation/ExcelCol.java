package org.genesis.javacollector.annotation.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author KG(Kelvin Gu)
 * @InterfaceName: ExcelCol
 * @Package org.genesis.javacollector.annotation.excel.annotation
 * @Description: excel col annotation
 * @date 2018/8/27 09:45
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelCol {
    String colName() default "";
}
