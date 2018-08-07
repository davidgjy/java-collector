package org.genesis.jaxb.object.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: Menu
 * @Package org.genesis.jaxb.object.entity
 * @Description: 菜单对象
 * @date 2018/8/7 10:31
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Menu {
    private String name;
    private String id;

    public Menu() {
    }

    public Menu(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
