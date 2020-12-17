package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.javaboy.vhr.bean.Position;
import org.javaboy.vhr.bean.PositionDto;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getAllPosition();

    Integer deleteManyPosition(@Param("ids") Integer[] ids);

    @Select("select p.id,p.name as posName from position p where p.enabled = 1")
    List<PositionDto> getAllPositionNames();
}