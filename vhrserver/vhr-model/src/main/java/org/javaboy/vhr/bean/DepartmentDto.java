package org.javaboy.vhr.bean;

import java.io.Serializable;

/**
 * @Author: xdf
 * @Description:
 * @Date: Created in 14:25 2020/12/14
 */
public class DepartmentDto implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    /**
     * 部门名称
     */
    private String depName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "DepartmentDto{" +
                "id=" + id +
                ", depName='" + depName + '\'' +
                '}';
    }
}
