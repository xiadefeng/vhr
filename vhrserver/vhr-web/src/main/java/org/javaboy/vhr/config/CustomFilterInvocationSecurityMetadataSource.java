package org.javaboy.vhr.config;

import org.javaboy.vhr.bean.Menu;
import org.javaboy.vhr.bean.Role;
import org.javaboy.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @Author: xdf
 * @Description: 此类作用主要用户传来的请求地址，分析出请求需要的角色
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 拿到当前请求的地址
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        // 查询数据库中所有的菜单
        List<Menu> menus = menuService.getAllMenusWithRole();
        for (Menu menu : menus) {
            // 拿到当前请求和数据库中的请求进行匹配
            if (antPathMatcher.match(menu.getUrl(),requestUrl)) {
                // 如果一致将菜单访问所需的角色返回
                List<Role> roles = menu.getRoles();
                String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i] = roles.get(i).getName();
                }
                // 返回请求所具备的角色，进入 CustomUrlDecisionManager 中再次判断
                return SecurityConfig.createList(str);
            }
        }
        // 返回一个标记，进入 CustomUrlDecisionManager 中再次判断
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
