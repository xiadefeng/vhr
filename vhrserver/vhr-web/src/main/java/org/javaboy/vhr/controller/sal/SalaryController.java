package org.javaboy.vhr.controller.sal;

import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.bean.Salary;
import org.javaboy.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xdf
 * @Description: 薪资管理——工资账套管理
 */
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    /**
     * 查询工资账套
     *
     * @return
     */
    @GetMapping("/")
    public List<Salary> getAllSalarys() {
        return salaryService.getAllSalarys();
    }

    /**
     * 添加工资账套
     *
     * @param salary
     * @return
     */
    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary) {
        if (salaryService.addSalary(salary) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 删除工资账套
     *
     * @param id 编号
     * @return
     */
    @DeleteMapping("/{id}")
    public RespBean deleteSalary(@PathVariable Integer id) {
        if (salaryService.deleteSalary(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    /**
     * 删除多条工资账套
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public RespBean deleteManySalary(Integer[] ids) {
        if (salaryService.deleteManySalary(ids) == ids.length) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    /**
     * 更新工资账套
     *
     * @param salary
     * @return
     */
    @PutMapping("/")
    public RespBean updateSalary(@RequestBody Salary salary) {
        if (salaryService.updateSalary(salary) == 1) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}
