package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.javaboy.vhr.bean.Department;
import org.javaboy.vhr.bean.DepartmentDto;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    Integer deleteDepartmentById(@Param("id") Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    int updateByParentId(@Param("isParent") Boolean isParent,@Param("pid") Integer pid);

    List<Department> getAllDepartmentsByParentId(Integer pid);

    String getParentdepPath(@Param("pid") Integer pid);

    Integer getIsParentById(@Param("id") Integer id);

    Integer getIsParentByPid(@Param("pid") Integer pid);

    List<Department> getAllDepartmentsWithOutChildren();

    @Select("select d.id,d.name as depName from department d where d.enabled = 1")
    List<DepartmentDto> getAllDepartmentsNames();
}