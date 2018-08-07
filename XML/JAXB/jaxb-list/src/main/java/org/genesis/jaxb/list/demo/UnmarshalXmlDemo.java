package org.genesis.jaxb.list.demo;

import org.genesis.jaxb.list.entity.User;
import org.genesis.jaxb.list.util.JaxbUtil;

import java.io.File;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: UnmarshalXmlDemo
 * @Package org.genesis.jaxb.list.demo
 * @Description: unmarshal xml
 * @date 2018/8/7 14:08
 */
public class UnmarshalXmlDemo {
    public static void main(String[] args) {
        File file = new File("src/main/resources/template/output.xml");
        User user = JaxbUtil.convertToJavaBean(User.class, file);
        System.out.println(user);
    }
}
