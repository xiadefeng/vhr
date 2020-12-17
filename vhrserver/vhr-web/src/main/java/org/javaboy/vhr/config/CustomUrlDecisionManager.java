package org.javaboy.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @Author: xdf
 * @Description: 判断当前用户是否具备请求所需的角色
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : configAttributes) {
            // 拿到请求所需要的角色
            String needRole = configAttribute.getAttribute();
            if ("ROLE_LOGIN".equals(needRole)) {
                // 如果当前用户是匿名登陆
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登陆，请登录！");
                }
                // 如果已经登陆直接结束
                return;
            }
            // 拿到用户的角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            /* 这里的业务逻辑我们使用的是第二种
            *  列如当前请求要求角色 A B
            *  1.第一种情况是同时具备 A 和 B 才能具备访问权限
            *  2.第二种情况是具备其中一种角色就能访问 */
            for (GrantedAuthority authority : authorities) {
                // 比较用户角色和请求所需角色是否相同
                if (authority.getAuthority().equals(needRole)) {
                    // 代表用户具备了当前请求所要求的角色
                    return;
                }
            }
        }
        // 代表用户不具备当前请求所需的角色
        throw new AccessDeniedException("权限不足，请联系管理员！");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
