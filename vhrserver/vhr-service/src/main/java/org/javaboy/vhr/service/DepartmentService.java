package org.javaboy.vhr.service;

import org.javaboy.vhr.bean.Department;
import org.javaboy.vhr.bean.DepartmentDto;
import org.javaboy.vhr.bean.Employee;
import org.javaboy.vhr.mapper.DepartmentMapper;
import org.javaboy.vhr.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: xdf
 * @Description: 部门实现类
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    @Transactional
    public Integer addDepartment(Department department) {
        // 第一步添加部门信息
        department.setEnabled(true); // 当前部门可用
        Integer result = departmentMapper.insertSelective(department);

        // 第二步修改新添加的部门属性 depPath
        String depPath = departmentMapper.getParentdepPath(department.getParentId());
        department.setDepPath(depPath + "." + department.getId()); // 组合 depPath
        departmentMapper.updateByPrimaryKeySelective(department);

        // 跟据当前部门找到父部门修改其 IsParent 为 true
        department.setParent(true);
        departmentMapper.updateByParentId(department.getParent(), department.getParentId());
        return result;
    }

    @Transactional
    public Integer deleteDepartment(Integer id) {
        // 1.查询当前部门下是否存在子部门
        Integer result = departmentMapper.getIsParentById(id);
        if (result == 0) {
            return -2;
        }

        // 2.查询当前部门下是否存在员工
        Integer result2 = employeeMapper.getDepartmentId(id);
        if (result2 > 0) {
            return -1;
        }

        // 3.进行删除操作
        Department department = departmentMapper.selectByPrimaryKey(id);
        result = departmentMapper.deleteDepartmentById(id);

        // 4.判断当前部门下还存在子部门
        Integer count = departmentMapper.getIsParentByPid(department.getParentId());
        if (count == 0) {
            department.setParent(false);
            departmentMapper.updateByParentId(department.getParent(), department.getParentId());
        }
        return result;
    }

    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentMapper.getAllDepartmentsWithOutChildren();
    }

    public List<DepartmentDto> getAllDepartmentsNames() {
       return departmentMapper.getAllDepartmentsNames();
    }
}
