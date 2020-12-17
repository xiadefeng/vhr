package org.javaboy.vhr.bean;

/**
 * @Author: xdf
 */
public class Meta {
    /**
     * 菜单切换时是否保活
     */
    private Boolean keepAlive;
    /**
     * 是否登陆后才能访问
     */
    private Boolean requireAuth;

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
