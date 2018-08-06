package org.genesis.jaxb.demo;

import org.genesis.jaxb.entity.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: UnmarshalXmlDemo
 * @Package org.genesis.jaxb.demo
 * @Description: unmarshal xml demo
 * @date 2018/8/6 21:22
 */
public class UnmarshalXmlDemo {
    public static void main(String[] args) {
        File file = new File("src/main/resources/template/user.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            User user = (User) unmarshaller.unmarshal(file);
            System.out.println(user.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
