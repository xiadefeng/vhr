package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.bean.Employee;
import org.javaboy.vhr.bean.Employeeec;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.bean.RespPageBean;
import org.javaboy.vhr.service.EmployeeService;
import org.javaboy.vhr.service.EmployeeecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author: xdf
 * @Description: 员工奖惩
 * @Date: Created in 19:12 2020/12/9
 */
@RestController
@RequestMapping("/employeeec/basic")
public class EmployeeecController {

    @Autowired
    EmployeeecService employeeecService;

    /**
     * 添加员工奖惩
     * @param employeeec
     * @return
     */
    @PostMapping("/")
    public RespBean addEmployeeec(@RequestBody Employeeec employeeec) {
        if (employeeecService.addEmployeeec(employeeec) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 分页查询全部员工基本资料
     *
     * @param page    当前页码
     * @param size    页大小
     * @return
     */
    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer size,
                                          Employeeec employeeec,
                                          Date[] beginDateScope) {
        System.out.println(employeeec.getEmployeeNameDto());
        return employeeecService.getEmployeeecByPage(page, size, employeeec, beginDateScope);
    }

    /**
     * 修改员工奖惩信息
     * @param employeeec
     * @return
     */
    @PutMapping("/")
    public RespBean updateEmployee(@RequestBody Employeeec employeeec) {
        if (employeeecService.updateEmployeeec(employeeec) == 1) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 删除员工奖惩项
     * @param id 编号
     * @return
     */
    @DeleteMapping("/{id}")
    public RespBean deleteEmployeeec(@PathVariable Integer id) {
        if (employeeecService.deleteEmployeeec(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
