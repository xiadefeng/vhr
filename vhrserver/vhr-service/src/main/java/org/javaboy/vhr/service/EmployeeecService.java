package org.javaboy.vhr.service;

import org.javaboy.vhr.bean.Employee;
import org.javaboy.vhr.bean.Employeeec;
import org.javaboy.vhr.bean.RespPageBean;
import org.javaboy.vhr.mapper.EmployeeMapper;
import org.javaboy.vhr.mapper.EmployeeecMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: xdf
 * @Description: 员工奖惩实现
 */
@Service
public class EmployeeecService {
    @Autowired
    EmployeeecMapper employeeecMapper;

    public Integer addEmployeeec(Employeeec employeeec) {
         return employeeecMapper.insert(employeeec);
    }

    public RespPageBean getEmployeeecByPage(Integer page, Integer size, Employeeec employeeec, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size; // 分页公式
        }
        // 分页数据
        List<Employee> data = employeeecMapper.getEmployeeecByPage(page, size, employeeec, beginDateScope);
        // 数据总数量
        Long total = employeeecMapper.getTotal(employeeec, beginDateScope);
        return new RespPageBean(total, data);
    }

    public Integer updateEmployeeec(Employeeec employeeec) {
       return employeeecMapper.updateByPrimaryKeySelective(employeeec);
    }

    public Integer deleteEmployeeec(Integer id) {
        return employeeecMapper.deleteByPrimaryKey(id);
    }
}
