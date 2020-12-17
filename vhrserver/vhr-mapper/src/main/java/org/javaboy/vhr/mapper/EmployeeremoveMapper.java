package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.javaboy.vhr.bean.Employeeremove;

import java.util.Date;
import java.util.List;

public interface EmployeeremoveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeremove record);

    int insertSelective(Employeeremove record);

    Employeeremove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeremove record);

    int updateByPrimaryKey(Employeeremove record);

    List<Employeeremove> getEmployeemvByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("empMv") Employeeremove employeeremove, Date[] beginDateScope);

    Long getTotal(@Param("empMv")Employeeremove employeeremove, Date[] beginDateScope);

    @Select("select * from employeeremove em where em.eid = #{eid}")
    Employeeremove selectEmploueeremoveByEid(@Param("eid") Integer eid);
}