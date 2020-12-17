package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Select;
import org.javaboy.vhr.bean.AdjustSalary;

public interface AdjustSalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdjustSalary record);

    int insertSelective(AdjustSalary record);

    AdjustSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdjustSalary record);

    int updateByPrimaryKey(AdjustSalary record);

    @Select("select * from adjustsalary a where a.eid = #{id}")
    AdjustSalary getAdjustSalary(Integer id);
}