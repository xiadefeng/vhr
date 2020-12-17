package org.javaboy.vhr.controller.sal;

import org.javaboy.vhr.bean.EmpSalaryDto;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.bean.RespPageBean;
import org.javaboy.vhr.bean.Salary;
import org.javaboy.vhr.service.EmployeeService;
import org.javaboy.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xdf
 * @Description: 薪资管理——员工账套设置
 */
@RestController
@RequestMapping("/salary/sobcfg")
public class SalSobCfgController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page,
                                                    @RequestParam(defaultValue = "10") Integer size) {
        return employeeService.getEmployeeByPageWithSalary(page, size);
    }

    @PutMapping("/")
    public RespBean updateEmpSalary(Integer eid,Integer sid) {
        Integer result = employeeService.updateEmpSalary(eid,sid);
        if (result == 1 || result == 2) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @GetMapping("/salaries")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalarys();
    }

    @GetMapping("/{id}")
    public List<EmpSalaryDto> getSalaryByEmpId(@PathVariable Integer id) {
        List<EmpSalaryDto> list = new ArrayList<>();
        EmpSalaryDto salaryByEmpId = salaryService.getSalaryByEmpId(id);
        list.add(salaryByEmpId);
        return list;
    }
}
