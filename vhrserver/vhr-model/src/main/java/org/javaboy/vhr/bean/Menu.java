package org.javaboy.vhr.bean;

import java.util.List;

/**
 * 菜单表
 */
public class Menu {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 请求路径规则
     */
    private String url;
    /**
     * 路由 Path
     */
    private String path;
    /**
     * 组件名称
     */
    private String component;
    /**
     * 组件名
     */
    private String name;
    /**
     * 菜单图标
     */
    private String iconCls;
    /**
     * 父菜单编号
     */
    private Integer parentId;
    /**
     * 是否可用
     */
    private Boolean enabled;
    /**
     * 菜单业务属性
     */
    private Meta meta;
    /**
     * 父菜单中的子菜单
     */
    private List<Menu> children;
    /**
     * 菜单有权限访问的角色
     */
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}