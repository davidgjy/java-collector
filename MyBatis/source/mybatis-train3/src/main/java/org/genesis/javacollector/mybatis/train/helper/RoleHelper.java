package org.genesis.javacollector.mybatis.train.helper;

import org.genesis.javacollector.mybatis.train.pojo.Role;

import java.util.List;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: RoleHelper
 * @Package org.genesis.javacollector.mybatis.train.helper
 * @Description: role helper for display
 * @date 2018/8/19 17:40
 */
public class RoleHelper {
    public static void displayRoles(List<Role> roles) {
        System.out.println("******************* Role *******************");
        System.out.println("  Size: " + roles.size());
        System.out.println("-----------------------------------------");
        for (Role role : roles) {
            System.out.println(role);
            System.out.println("-----------------------------------------");
        }
        System.out.println("********************************************");
    }
}
