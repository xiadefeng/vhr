package org.javaboy.vhr.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * 民族表
 */
public class Nation implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nation nation = (Nation) o;
        return name.equals(nation.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Nation(String name) {
        this.name = name;
    }

    public Nation() {
    }

    /**
     * 民族名称
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}