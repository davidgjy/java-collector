package org.genesis.jaxb.object.util;

import org.genesis.jaxb.object.entity.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: JaxbUtil
 * @Package org.genesis.jaxb.object.util
 * @Description: jaxb util
 * @date 2018/8/7 10:36
 */
public class JaxbUtil {
    public static <T> Boolean convertToXml(Object obj, Class<T> clz, File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clz);
            Marshaller marshaller = jaxbContext.createMarshaller();
            //格式化输出，即按标签自动换行，否则就是一行输出
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //设置编码（默认编码就是utf-8）
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //是否省略xml头信息，默认不省略（false）
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
            marshaller.marshal(obj, file);
            //控制台输出
            marshaller.marshal(obj, System.out);

            return true;
        } catch (JAXBException e) {
            e.printStackTrace();

            return false;
        }
    }

    public static <T> T convertToJavaBean(Class<T> clz, File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            T t = (T) unmarshaller.unmarshal(file);
            return t;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
