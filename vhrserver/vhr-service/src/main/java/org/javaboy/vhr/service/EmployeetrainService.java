package org.javaboy.vhr.service;

import org.javaboy.vhr.bean.Employeetrain;
import org.javaboy.vhr.mapper.EmployeetrainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xdf
 * @Description: 员工培训实现类
 */
@Service
public class EmployeetrainService {

    @Autowired
    private EmployeetrainMapper employeetrainMapper;

    public Integer addEmployeetrain(Employeetrain employeetrain) {
        return employeetrainMapper.insert(employeetrain);
    }
}
