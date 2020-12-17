package org.javaboy.vhr.controller;

import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.config.VerificationCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: xdf
 * @Description: 登陆管理
 */
@RestController
public class LoginController {
    /**
     * 处理登陆
     *
     * @return
     */
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登陆，请登录！");
    }

    /**
     * 处理验证码
     *
     * @param session
     * @param resp
     * @throws IOException
     */
    @GetMapping("/verifyCode")
    public void verifyCode(HttpSession session, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        session.setAttribute("verify_code", text);
        VerificationCode.output(image, resp.getOutputStream());
    }
}
