package org.javaboy.vhr.controller;

import org.javaboy.vhr.bean.Hr;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: xdf
 * @Description: 个人中心
 */
@RestController
public class HrInfoController {
    @Autowired
    HrService hrService;

    @Value("${file.image.path}")
    String imagePath;

    /**
     * 管理员个人中心信息展示
     *
     * @param authentication 当前登陆用户
     * @return
     */
    @GetMapping("/hr/info")
    public Hr getCurrentHr(Authentication authentication) {
        return ((Hr) authentication.getPrincipal());
    }

    /**
     * 更新管理员信息
     *
     * @param hr
     * @param authentication
     * @return
     */
    @PutMapping("/hr/info")
    public RespBean updateHr(@RequestBody Hr hr, Authentication authentication) {
        if (hrService.updateHr(hr) == 1) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr, authentication.getCredentials(), authentication.getAuthorities()));
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    /**
     * 更新个人密码
     *
     * @param info
     * @return
     */
    @PutMapping("/hr/pass")
    public RespBean updateHrPassWd(@RequestBody Map<String, Object> info) {
        String oldpass = (String) info.get("oldpass");
        String pass = (String) info.get("pass");
        Integer hrid = (Integer) info.get("hrid");
        if (hrService.updateHrPassWd(oldpass, pass, hrid)) {
            return RespBean.ok("密码更新成功");
        }
        return RespBean.error("密码更新失败");
    }

    /**
     * 更新个人头像
     *
     * @param file 头像文件
     * @param id   个人ID
     * @return
     */
    @PostMapping("/hr/userface")
    public RespBean updateHrUserface(MultipartFile file, Integer id, Authentication authentication) {
        if (file.isEmpty()){
            return RespBean.error("上传头像不能为空");
        }
        //获得上传文件名
        String fileName  = file.getOriginalFilename();
        String suffixName  = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(imagePath+fileName);
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        }catch (IOException e){
            e.printStackTrace();
        }
        String filename = "/" + fileName;
        System.out.println(fileName);
        if (hrService.updateHrUserface(filename, id) == 1) {
            Hr hr = (Hr) authentication.getPrincipal();
            hr.setUserface(filename);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr, authentication.getCredentials(), authentication.getAuthorities()));
            return RespBean.ok("更新成功", filename);
        }
        return RespBean.error("更新失败");
    }
}
