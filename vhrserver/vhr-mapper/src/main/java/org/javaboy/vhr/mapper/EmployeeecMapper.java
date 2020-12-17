package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.bean.Employee;
import org.javaboy.vhr.bean.Employeeec;

import java.util.Date;
import java.util.List;

public interface EmployeeecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    Employeeec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeec record);

    int updateByPrimaryKey(Employeeec record);

    List<Employee> getEmployeeecByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("empec") Employeeec employeeec, Date[] beginDateScope);

    Long getTotal(@Param("empec")Employeeec employeeec, Date[] beginDateScope);
}