package org.javaboy.vhr.bean;

import java.io.Serializable;

/**
 * @Author: xdf
 * @Description:
 * @Date: Created in 14:39 2020/12/14
 */
public class PositionDto implements Serializable {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 职位名称
     */
    private String posName;

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "PositionDto{" +
                "id=" + id +
                ", posName='" + posName + '\'' +
                '}';
    }
}
