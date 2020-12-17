package org.javaboy.vhr.utils;

import org.javaboy.vhr.bean.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: 红颜祸水nvn <bai211425401@126.com>
 * @Description: CSDN <https://blog.csdn.net/qq_43647359>
 */
public class HrUtils {

    /**
     * 获取当前登陆用户信息
     * @return 用户信息
     */
    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
