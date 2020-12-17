package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.bean.Employeeec;
import org.javaboy.vhr.bean.Employeetrain;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.service.EmployeetrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xdf
 * @Description: 员工培训
 * @Date: Created in 15:02 2020/12/10
 */
@RestController
@RequestMapping("/employeetrain/basic")
public class EmployeetrainController {

    @Autowired
    private EmployeetrainService employeetrainService;

    @PostMapping("/")
    public RespBean addEmployeetrain(@RequestBody Employeetrain employeetrain) {
        if (employeetrainService.addEmployeetrain(employeetrain) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }
}
