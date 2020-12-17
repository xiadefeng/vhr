package org.javaboy.vhr.bean;

import java.util.Date;

/**
 * 员工调薪表
 */
public class AdjustSalary {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 员工编号
     */
    private Integer eid;
    /**
     * 调薪日期
     */
    private Date asdate;
    /**
     * 调前薪资
     */
    private Integer beforesalary;
    /**
     * 调后薪资
     */
    private Integer aftersalary;
    /**
     * 调薪原因
     */
    private String reason;
    /**
     * 备注
     */
    private String remark;

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

    public Date getAsdate() {
        return asdate;
    }

    public void setAsdate(Date asdate) {
        this.asdate = asdate;
    }

    public Integer getBeforesalary() {
        return beforesalary;
    }

    public void setBeforesalary(Integer beforesalary) {
        this.beforesalary = beforesalary;
    }

    public Integer getAftersalary() {
        return aftersalary;
    }

    public void setAftersalary(Integer aftersalary) {
        this.aftersalary = aftersalary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}