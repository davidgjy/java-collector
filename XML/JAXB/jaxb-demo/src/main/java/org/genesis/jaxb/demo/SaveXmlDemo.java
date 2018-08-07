package org.genesis.jaxb.demo;

import org.genesis.jaxb.entity.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: SaveXmlDemo
 * @Package org.genesis.jaxb.demo
 * @Description: save xml demo
 * @date 2018/8/6 21:18
 */
public class SaveXmlDemo {
    public static void main(String[] args) {
        User user = new User("KG", 2018, "Super Admin", "瞎哔哔");
        File file = new File("src/main/resources/template/output.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            //格式化输出，即按标签自动换行，否则就是一行输出
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //设置编码（默认编码就是utf-8）
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //是否省略xml头信息，默认不省略（false）
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
            marshaller.marshal(user, file);
            System.out.println("Xml write successful");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
