package org.javaboy.vhr.service;

import org.javaboy.vhr.bean.AdjustSalary;
import org.javaboy.vhr.mapper.AdjustSalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xdf
 * @Description: 调薪实现类
 */
@Service
public class AdjustSalaryService {

    @Autowired
    private AdjustSalaryMapper adjustSalaryMapper;


    public Integer addAdjustSalary(AdjustSalary adjustSalary) {
      return adjustSalaryMapper.insert(adjustSalary);
    }

    public AdjustSalary getAdjustSalary(Integer id) {
       return adjustSalaryMapper.getAdjustSalary(id);
    }

    public Integer updateAdjustSalary(AdjustSalary adjustSalary) {
        return adjustSalaryMapper.updateByPrimaryKey(adjustSalary);
    }
}
