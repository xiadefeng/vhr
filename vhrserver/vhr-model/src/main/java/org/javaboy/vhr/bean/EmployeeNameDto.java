package org.javaboy.vhr.bean;

import java.io.Serializable;

/**
 * @Author: xdf
 * @Description:
 * @Date: Created in 18:07 2020/12/9
 */
public class EmployeeNameDto implements Serializable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmployeeNameDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
