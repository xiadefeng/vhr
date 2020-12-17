package org.javaboy.vhr.bean;

import java.util.Date;

/**
 * 员工调岗表
 */
public class Employeeremove {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 员工编号
     */
    private Integer eid;
    /**
     * 调动后部门
     */
    private Integer afterdepid;
    /**
     * 调动后职位
     */
    private Integer afterjobid;
    /**
     * 调动日期
     */
    private Date removedate;
    /**
     * 调动原因
     */
    private String reason;
    /**
     * 备注
     */
    private String remark;

    private EmployeeNameDto employeeNameDto;

    private DepartmentDto departmentDto;

    private PositionDto positionDto;

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

    public Integer getAfterdepid() {
        return afterdepid;
    }

    public void setAfterdepid(Integer afterdepid) {
        this.afterdepid = afterdepid;
    }

    public Integer getAfterjobid() {
        return afterjobid;
    }

    public void setAfterjobid(Integer afterjobid) {
        this.afterjobid = afterjobid;
    }

    public Date getRemovedate() {
        return removedate;
    }

    public void setRemovedate(Date removedate) {
        this.removedate = removedate;
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

    public EmployeeNameDto getEmployeeNameDto() {
        return employeeNameDto;
    }

    public void setEmployeeNameDto(EmployeeNameDto employeeNameDto) {
        this.employeeNameDto = employeeNameDto;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

    public PositionDto getPositionDto() {
        return positionDto;
    }

    public void setPositionDto(PositionDto positionDto) {
        this.positionDto = positionDto;
    }
}