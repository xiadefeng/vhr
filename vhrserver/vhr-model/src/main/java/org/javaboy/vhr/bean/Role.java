package org.javaboy.vhr.bean;

/**
 * 角色表
 */
public class Role {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色中文名称
     */
    private String nameZh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}