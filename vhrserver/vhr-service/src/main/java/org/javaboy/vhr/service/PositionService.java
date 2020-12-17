package org.javaboy.vhr.service;

import org.javaboy.vhr.bean.Position;
import org.javaboy.vhr.bean.PositionDto;
import org.javaboy.vhr.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: xdf
 * @Description: 职位实现
 */
@Service
public class PositionService {
    @Autowired
    PositionMapper positionMapper;

    public List<Position> getAllPosition() {
        return positionMapper.getAllPosition();
    }

    public Integer addPosition(Position position) {
        // 职位是否可用
        position.setEnabled(true);
        // 创建日期
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePosition(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteManyPosition(Integer[] ids) {
        return positionMapper.deleteManyPosition(ids);
    }

    public List<PositionDto> getAllPositionNames() {
       return positionMapper.getAllPositionNames();
    }
}
