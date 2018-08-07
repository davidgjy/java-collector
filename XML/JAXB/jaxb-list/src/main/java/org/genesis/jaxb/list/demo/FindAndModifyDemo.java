package org.genesis.jaxb.list.demo;

import org.genesis.jaxb.list.entity.Menu;
import org.genesis.jaxb.list.entity.User;
import org.genesis.jaxb.list.util.JaxbUtil;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: FindAndModifyDemo
 * @Package org.genesis.jaxb.list.demo
 * @Description: find element and modify
 * @date 2018/8/7 14:40
 */
public class FindAndModifyDemo {
    public static void main(String[] args) {
        File file = new File("src/main/resources/template/output.xml");
        File file2 = new File("src/main/resources/template/output2.xml");
        User user = JaxbUtil.convertToJavaBean(User.class, file);
        List<Menu> menus = user.getMenus();
        for (int i = 0; i < menus.size(); i++) {
            try {
                Menu menu = menus.get(i);
                if (menu.getId().equals("9527")) {
                    Menu editMenu = menu.clone();
                    System.out.println("Old Menu Name: " + menu.getName());
                    System.out.print("Input New Name: ");
                    Scanner in = new Scanner(System.in);
                    String newName = in.nextLine();
                    editMenu.setName(newName);
                    menus.set(i, editMenu);
                }
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        user.setMenus(menus);
        JaxbUtil.convertToXml(user, file2);
        System.out.println("Modify xml successful!");
    }
}
