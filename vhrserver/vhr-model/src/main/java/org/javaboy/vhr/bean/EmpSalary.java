package org.javaboy.vhr.bean;

/**
 * 员工调薪关联表
 */
public class EmpSalary {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 员工编号
     */
    private Integer eid;
    /**
     * 薪资编号
     */
    private Integer sid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}