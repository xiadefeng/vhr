package org.javaboy.vhr.bean;

import java.util.Date;

/**
 * 员工奖惩表
 */
public class Employeeec {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 员工编号
     */
    private Integer eid;
    /**
     * 奖惩日期
     */
    private Date ecdate;
    /**
     * 奖惩原因
     */
    private String ecreason;
    /**
     * 奖罚分
     */
    private Integer ecpoint;
    /**
     * 奖罚类型 0奖:1罚
     */
    private Integer ectype;
    /**
     * 备注
     */
    private String remark;

    public EmployeeNameDto getEmployeeNameDto() {
        return employeeNameDto;
    }

    public void setEmployeeNameDto(EmployeeNameDto employeeNameDto) {
        this.employeeNameDto = employeeNameDto;
    }

    private EmployeeNameDto employeeNameDto;

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

    public Date getEcdate() {
        return ecdate;
    }

    public void setEcdate(Date ecdate) {
        this.ecdate = ecdate;
    }

    public String getEcreason() {
        return ecreason;
    }

    public void setEcreason(String ecreason) {
        this.ecreason = ecreason == null ? null : ecreason.trim();
    }

    public Integer getEcpoint() {
        return ecpoint;
    }

    public void setEcpoint(Integer ecpoint) {
        this.ecpoint = ecpoint;
    }

    public Integer getEctype() {
        return ectype;
    }

    public void setEctype(Integer ectype) {
        this.ectype = ectype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Employeeec{" +
                "id=" + id +
                ", eid=" + eid +
                ", ecdate=" + ecdate +
                ", ecreason='" + ecreason + '\'' +
                ", ecpoint=" + ecpoint +
                ", ectype=" + ectype +
                ", remark='" + remark + '\'' +
                ", employeeNameDto=" + employeeNameDto +
                '}';
    }
}