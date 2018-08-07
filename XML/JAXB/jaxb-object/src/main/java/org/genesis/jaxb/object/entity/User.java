package org.genesis.jaxb.object.entity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: User
 * @Package org.genesis.jaxb.object.entity
 * @Description: user object
 * @date 2018/8/7 10:30
 */
@XmlType(propOrder = {"userName", "role", "menu"})
@XmlRootElement(name = "user")
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class User implements Serializable {

    private String userName;
    private int age;
    private String role;
    private String bibi;
    private Menu menu;

    public User() {
    }

    public User(String userName, int age, String role, String bibi) {
        this.userName = userName;
        this.role = role;
        this.age = age;
        this.bibi = bibi;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlAttribute
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement(nillable = true)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public String getBibi() {
        return bibi;
    }

    public void setBibi(String bibi) {
        this.bibi = bibi;
    }

    @XmlElement
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", menu=" + menu +
                '}';
    }
}




