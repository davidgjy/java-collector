package org.genesis.javacollector.mybatis.train.pojo;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午10:44 2018/8/14
 * @modified by:
 */

public class Role {

    private Long id;
    private String roleName;
    private String note;

    /**
     * setter and getter
     **/
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

}

