package org.javaboy.vhr.bean;

import java.util.Date;

/**
 * 操作日志表
 */
public class OpLog {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 添加日期
     */
    private Date adddate;
    /**
     * 操作内容
     */
    private String operate;
    /**
     * 操作员编号
     */
    private Integer hrid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }
}