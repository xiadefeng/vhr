package org.javaboy.vhr.service;

import org.javaboy.vhr.bean.Nation;
import org.javaboy.vhr.mapper.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xdf
 * @Description: 民族实现
 */
@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
