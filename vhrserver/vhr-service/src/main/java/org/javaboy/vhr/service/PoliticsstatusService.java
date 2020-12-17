package org.javaboy.vhr.service;

import org.javaboy.vhr.bean.Politicsstatus;
import org.javaboy.vhr.mapper.PoliticsstatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xdf
 * @Description: 组织实现
 */
@Service
public class PoliticsstatusService {
    @Autowired
    PoliticsstatusMapper politicsstatusMapper;
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusMapper.getAllPoliticsstatus();
    }
}
