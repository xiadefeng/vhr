package org.javaboy.vhr.controller.sys.basic;

import org.javaboy.vhr.bean.Department;
import org.javaboy.vhr.bean.DepartmentDto;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xdf
 * @Description: 基础信息设置——部门管理
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    /**
     * 查询所有部门
     *
     * @return
     */
    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    /**
     * 添加部门
     *
     * @param department 部门信息
     * @return 响应结果
     */
    @PostMapping("/")
    public RespBean addDepartment(@RequestBody Department department) {
        if (departmentService.addDepartment(department) == 1) {
            department.setParent(false); // 新增的部门不是父部门
            return RespBean.ok("添加成功！", department);
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 删除部门
     *
     * @param id 部门编号
     * @return 响应结果
     */
    @DeleteMapping("/{id}")
    public RespBean deleteDepartment(@PathVariable Integer id) {
        Integer result = departmentService.deleteDepartment(id);
        if (result == 1) {
            return RespBean.ok("删除成功！");
        } else if (result == -2) {
            return RespBean.error("该部门下有子部门，删除失败！");
        } else if (result == -1) {
            return RespBean.error("该部门下有员工，删除失败！");
        }
        return RespBean.error("删除失败！");
    }

    /**
     * 查询所有部门名称
     * @return
     */
    @GetMapping("/names")
    public List<DepartmentDto> getAllDepartmentsNames() {
        return departmentService.getAllDepartmentsNames();
    }
}
