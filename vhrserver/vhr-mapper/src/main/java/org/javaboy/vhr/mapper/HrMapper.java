package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.bean.Hr;
import org.javaboy.vhr.bean.Role;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(Integer hrid);

    List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("hrName") String hrName);

    List<Hr> getAllHrsExceptCurrentHr(Integer id);

    Integer updateHrPassWd(@Param("hrid") Integer hrid, @Param("encodePass") String encodePass);

    Integer updateHrUserface(@Param("url") String url, @Param("id") Integer id);
}