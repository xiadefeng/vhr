package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.bean.Employeeec;
import org.javaboy.vhr.bean.Employeeremove;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.bean.RespPageBean;
import org.javaboy.vhr.service.EmployeemvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author: xdf
 * @Description:
 * @Date: Created in 14:54 2020/12/14
 */
@RestController
@RequestMapping("/employeemv/basic")
public class EmployeeRemoveController {

    @Autowired
    private EmployeemvService employeemvService;

    /**
     * 添加员工调动
     * @param employeeremove
     * @return
     */
    @PostMapping("/")
    public RespBean addEmployeemv(@RequestBody Employeeremove employeeremove) {
        if (employeemvService.addEmployeeremove(employeeremove) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("该员工已经调动过，修改即可，无需增加！");
    }

    /**
     * 修改员工奖惩信息
     * @param employeeremove
     * @return
     */
    @PutMapping("/")
    public RespBean updateEmployeemv(@RequestBody Employeeremove employeeremove) {
        if (employeemvService.updateEmployeemv(employeeremove) == 1) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 分页查询全部员工调动信息
     * @param page    当前页码
     * @param size    页大小
     * @return
     */
    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer size,
                                          Employeeremove employeeremove,
                                          Date[] beginDateScope) {
        return employeemvService.getEmployeemvByPage(page, size, employeeremove, beginDateScope);
    }

    /**
     * 删除员工奖惩项
     * @param id 编号
     * @return
     */
    @DeleteMapping("/{id}")
    public RespBean deleteEmployeemv(@PathVariable Integer id) {
        if (employeemvService.deleteEmployeemv(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }


}
