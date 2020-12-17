package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.javaboy.vhr.bean.Employee;
import org.javaboy.vhr.bean.EmployeeNameDto;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Integer getDepartmentId(@Param("departmentId") Integer departmentId);

    List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Integer maxWorkID();

    Integer addEmp(@Param("list") List<Employee> list);

    Employee getEmployeeById(Integer id);

    List<Employee> getEmployeeByPageWithSalary(@Param("page") Integer page, @Param("size") Integer size);

    Integer updateEmpSalary(@Param("eid") Integer eid, @Param("sid") Integer sid);

    @Select("select e.id,e.name from employee e")
    List<EmployeeNameDto> getAllEmployeeNames();

    @Update("update employee e set e.rate = #{rate},e.integrate = #{integrate} where e.id = #{id}")
    Integer updateRateById(Integer id, Integer rate,Integer integrate);

    @Select("select e.rate from employee e where e.id = #{id}")
    Integer getRateById(Integer id);

    @Update("update employee e set e.departmentId = #{afterdepid},e.posId = #{afterjobid} where e.id = #{eid}")
    Integer updateEmployeeDepAndPos(@Param("afterdepid") Integer afterdepid,@Param("afterjobid") Integer afterjobid,@Param("eid") Integer eid);
}