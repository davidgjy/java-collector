package org.genesis.jaxb.list.entity;

import org.genesis.jaxb.list.adapter.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: User
 * @Package org.genesis.jaxb.list.entity
 * @Description: user entity
 * @date 2018/8/7 13:53
 */
@XmlType(propOrder = {"userName", "role", "enrollDate", "menus"})
@XmlRootElement(name = "user")
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class User implements Serializable {

    private String userName;
    private int age;
    private String role;
    private String bibi;
    private Date enrollDate;
    private List<Menu> menus;

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

    @XmlElement
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
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @XmlElementWrapper(name = "menu")
    @XmlElement
    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", menus=" + menus +
                '}';
    }
}
