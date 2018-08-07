package org.genesis.jaxb.list.demo;

import org.genesis.jaxb.list.entity.Menu;
import org.genesis.jaxb.list.entity.User;
import org.genesis.jaxb.list.util.JaxbUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: SaveXmlDemo
 * @Package org.genesis.jaxb.list.demo
 * @Description: save xml demo
 * @date 2018/8/7 13:58
 */
public class SaveXmlDemo {
    public static void main(String[] args) {
        User user = new User("KG", 2018, "Super Admin","master");
        List<Menu> list1 = new ArrayList<>();
        Menu menu1 = new Menu("系统管理","9527");
        Menu child1 = new Menu("权限管理","9999");
        Menu child2 = new Menu("用户管理","2322");
        list1.add(child1);
        list1.add(child2);
        menu1.setChild(list1);
        List<Menu> list2 = new ArrayList<>();
        Menu menu2 = new Menu("参数配置","2222");
        Menu child3 = new Menu("权限管理","3333");
        Menu child4 = new Menu("用户管理","4444");
        list2.add(child3);
        list2.add(child4);
        menu2.setChild(list2);
        List<Menu> menus = new ArrayList<>();
        menus.add(menu1);
        menus.add(menu2);
        user.setMenus(menus);

        File file = new File("src/main/resources/template/output.xml");
        JaxbUtil.convertToXml(user,file);
    }
}
