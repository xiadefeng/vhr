package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.javaboy.vhr.bean.EmpSalaryDto;
import org.javaboy.vhr.bean.Salary;

import java.util.List;

public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> getAllSalarys();

    Integer deleteManySalary(@Param("ids") Integer[] ids);


    @Select("select e.id,e.name,e.gender,e.workID,s.basicSalary,s.bonus,s.lunchSalary" +
            ",s.trafficSalary,s.allSalary,s.pensionBase,s.pensionPer,s.medicalBase," +
            "s.medicalPer,s.accumulationFundBase,s.accumulationFundPer from employee e ," +
            " salary s,  empsalary es where e.id = es.eid  and es.sid = s.id and e.id = #{id}")
    EmpSalaryDto getSalaryByEmpId(Integer id);
}