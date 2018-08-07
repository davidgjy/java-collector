package org.genesis.jaxb.object.demo;

import org.genesis.jaxb.object.entity.Menu;
import org.genesis.jaxb.object.entity.User;
import org.genesis.jaxb.object.util.JaxbUtil;

import javax.sound.midi.Soundbank;
import java.io.File;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: SaveXmlDemo
 * @Package org.genesis.jaxb.object.demo
 * @Description: save xml demo
 * @date 2018/8/7 10:35
 */
public class SaveXmlDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("KG");
        user.setAge(30);
        user.setRole("Super Admin");
        user.setBibi("test");

        user.setMenu(new Menu("Setting", "1"));

        File file = new File("src/main/resources/template/output.xml");
        if (JaxbUtil.convertToXml(user, User.class, file)) {
            System.out.println("Save to xml successful!");
        } else {
            System.out.println("Save to xml failed!");
        }
    }
}
