package org.javaboy.vhr.bean;

/**
 * Hr 角色表
 */
public class HrRole {
    /**
     * 编号
     */
    private Integer id;
    /**
     * hr 编号
     */
    private Integer hrid;
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

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}