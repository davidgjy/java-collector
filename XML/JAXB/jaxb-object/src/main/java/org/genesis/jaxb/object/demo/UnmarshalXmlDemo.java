package org.genesis.jaxb.object.demo;

import org.genesis.jaxb.object.entity.User;
import org.genesis.jaxb.object.util.JaxbUtil;

import java.io.File;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: UnmarshalXmlDemo
 * @Package org.genesis.jaxb.object.demo
 * @Description: unmarshal demo
 * @date 2018/8/7 10:47
 */
public class UnmarshalXmlDemo {
    public static void main(String[] args) {
        File file = new File("src/main/resources/template/output.xml");
        User user = JaxbUtil.convertToJavaBean(User.class, file);
        System.out.println(user);
    }
}
