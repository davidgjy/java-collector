package org.genesis.jaxb.list.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: Menu
 * @Package org.genesis.jaxb.list.entity
 * @Description: menu entity
 * @date 2018/8/7 13:54
 */
@XmlRootElement
public class Menu implements Cloneable {
    private String name;
    private String id;
    private List<Menu> child;

    public Menu() {
    }

    public Menu(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public Menu clone() throws CloneNotSupportedException {
        return (Menu)super.clone();
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
