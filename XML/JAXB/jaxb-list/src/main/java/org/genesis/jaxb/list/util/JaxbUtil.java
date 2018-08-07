package org.genesis.jaxb.list.util;

import javax.xml.bind.JAXB;
import java.io.File;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: JaxbUtil
 * @Package org.genesis.jaxb.list.util
 * @Description: jaxb utility
 * @date 2018/8/7 13:56
 */
public class JaxbUtil {

    public static void convertToXml(Object obj, File file) {
        JAXB.marshal(obj, file);
    }

    public static <T> T convertToJavaBean(Class<T> clz, File file) {
        return JAXB.unmarshal(file, clz);
    }
}
