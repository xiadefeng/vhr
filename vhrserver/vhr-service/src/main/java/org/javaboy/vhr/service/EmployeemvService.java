package org.javaboy.vhr.service;

import org.javaboy.vhr.bean.Employeeremove;
import org.javaboy.vhr.bean.RespPageBean;
import org.javaboy.vhr.mapper.EmployeeMapper;
import org.javaboy.vhr.mapper.EmployeeremoveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: xdf
 * @Description: 员工调动实现
 */
@Service
@Transactional
public class EmployeemvService {

    @Autowired
    private EmployeeremoveMapper employeeremoveMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public Integer addEmployeeremove(Employeeremove employeeremove) {
        //修改员工表的部门职位信息
        Integer i = 0;
        Employeeremove employeeremove1 = employeeremoveMapper.selectEmploueeremoveByEid(employeeremove.getEid());
        if (employeeremove1 != null){
            i = 2;
            return  2; //代表以经增加过这个员工的调动信息  去修改即可 不用再添加
        }else {
            i = employeeremoveMapper.insert(employeeremove);
            if (i == 1){
                i =  employeeMapper.updateEmployeeDepAndPos(employeeremove.getAfterdepid(),employeeremove.getAfterjobid(),employeeremove.getEid());
            }
            return i;
        }
    }

    public RespPageBean getEmployeemvByPage(Integer page, Integer size, Employeeremove employeeremove, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size; // 分页公式
        }
        // 分页数据
        List<Employeeremove> data = employeeremoveMapper.getEmployeemvByPage(page, size, employeeremove, beginDateScope);
        // 数据总数量
        Long total = employeeremoveMapper.getTotal(employeeremove, beginDateScope);
        return new RespPageBean(total, data);
    }

    public Integer updateEmployeemv(Employeeremove employeeremove) {
        Integer i = 0;
        i = employeeremoveMapper.updateByPrimaryKey(employeeremove);
        if (i == 1){
            i =  employeeMapper.updateEmployeeDepAndPos(employeeremove.getAfterdepid(),employeeremove.getAfterjobid(),employeeremove.getEid());
        }
        return i;
    }

    public Integer deleteEmployeemv(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }
}
