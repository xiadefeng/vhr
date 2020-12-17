package org.javaboy.vhr.bean;

/**
 * 菜单角色关联表
 */
public class MenuRole {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 菜单编号
     */
    private Integer mid;
    /**
     * 角色编号
     */
    private Integer rid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}