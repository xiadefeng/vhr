package org.javaboy.vhr.bean;

import java.util.Date;

/**
 * 员工培训表
 */
public class Employeetrain {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 员工编号
     */
    private Integer eid;
    /**
     * 培训日期
     */
    private Date traindate;
    /**
     * 培训内容
     */
    private String traincontent;
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

    public Date getTraindate() {
        return traindate;
    }

    public void setTraindate(Date traindate) {
        this.traindate = traindate;
    }

    public String getTraincontent() {
        return traincontent;
    }

    public void setTraincontent(String traincontent) {
        this.traincontent = traincontent == null ? null : traincontent.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}