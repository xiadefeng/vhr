package org.javaboy.vhr.service;

import org.javaboy.vhr.bean.Hr;
import org.javaboy.vhr.mapper.HrMapper;
import org.javaboy.vhr.mapper.HrRoleMapper;
import org.javaboy.vhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: xdf
 * @Description: hr实现类
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;
    @Autowired
    HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户不存在!");
        }
        // 如果用户登陆成功则拿到用户所具备的角色
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(String hrName) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(), hrName);
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public Integer deleteHr(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public Boolean updateHrRole(Integer hrid, Integer[] rids) {
        // 1.跟据 hrid 删除管理员所具备的所有角色
        hrRoleMapper.deleteByHrid(hrid);
        // 2.跟据 hrid 添加管理员所具备的所有角色
        return hrRoleMapper.addRole(hrid, rids) == rids.length;
    }

    public List<Hr> getAllHrsExceptCurrentHr() {
        return hrMapper.getAllHrsExceptCurrentHr(HrUtils.getCurrentHr().getId());
    }

    public boolean updateHrPassWd(String oldpass, String pass, Integer hrid) {
        Hr hr = hrMapper.selectByPrimaryKey(hrid);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 比较用户密码和旧密码是否一致
        if (encoder.matches(oldpass, hr.getPassword())) {
            // 如果相同进行密码修改操作
            String encodePass = encoder.encode(pass);
            Integer result = hrMapper.updateHrPassWd(hrid, encodePass);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }

    public Integer updateHrUserface(String url, Integer id) {
        return hrMapper.updateHrUserface(url, id);
    }

    public Integer insertHr(Hr hr) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodepass = encoder.encode(hr.getPassword());
        //默认头像为elementui 官网提供
        String userface = "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png";
        hr.setPassword(encodepass);
        hr.setUserface(userface);
        return hrMapper.insert(hr);
    }
}
