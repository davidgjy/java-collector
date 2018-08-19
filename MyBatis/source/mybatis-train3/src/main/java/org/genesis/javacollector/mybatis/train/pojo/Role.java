package org.genesis.javacollector.mybatis.train.pojo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * @Name: Role
 * @Description: role pojo
 * @author KG(Kelvin Gu)
 * @date 08-19-2018 05:13:02
*/
@Alias("role")
public class Role implements Serializable {

    private static final long serialVersionUID = 2056738736685021589L;

    private Long id;
    private String roleName;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
