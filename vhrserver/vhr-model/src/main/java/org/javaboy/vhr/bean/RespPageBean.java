package org.javaboy.vhr.bean;

import java.util.List;

/**
 * @Author: xdf
 * @Description: 自定义分页类
 *
 */
public class RespPageBean {
    /**
     * 数据总数量
     */
    private Long total;
    /**
     * 分页数据 泛型
     */
    private List<?> data;

    public RespPageBean() {
    }

    public RespPageBean(Long total, List<?> data) {
        this.total = total;
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
