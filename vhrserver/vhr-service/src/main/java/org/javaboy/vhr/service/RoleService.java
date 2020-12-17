package org.javaboy.vhr.service;

import org.javaboy.vhr.bean.Role;
import org.javaboy.vhr.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xdf
 * @Description: 角色实现
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer addRole(Role role) {
        // 如果角色英文名称不是以 ROLE_ 开头的则给它加上 ROLE_
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return roleMapper.insertSelective(role);
    }

    public Integer deleteRole(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}
