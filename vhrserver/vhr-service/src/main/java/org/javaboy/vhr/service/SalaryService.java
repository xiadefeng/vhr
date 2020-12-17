package org.javaboy.vhr.service;

import org.javaboy.vhr.bean.EmpSalaryDto;
import org.javaboy.vhr.bean.Salary;
import org.javaboy.vhr.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: xdf
 * @Description: 工资实现
 */
@Service
public class SalaryService {
    @Autowired
    SalaryMapper salaryMapper;

    public List<Salary> getAllSalarys() {
        return salaryMapper.getAllSalarys();
    }

    public Integer addSalary(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public Integer deleteSalary(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSalary(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }

    public Integer deleteManySalary(Integer[] ids) {
        return salaryMapper.deleteManySalary(ids);
    }

    public EmpSalaryDto getSalaryByEmpId(Integer id) {
        EmpSalaryDto salaryByEmpId = salaryMapper.getSalaryByEmpId(id);
        return salaryByEmpId;
    }
}
