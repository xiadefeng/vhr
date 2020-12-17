package org.javaboy.vhr.controller.sys;

import org.javaboy.vhr.bean.Hr;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.bean.Role;
import org.javaboy.vhr.service.HrService;
import org.javaboy.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xdf
 * @Description: 操作员管理
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    /**
     * 查询所有管理员
     * @param hrName 管理员名称
     * @return
     */
    @GetMapping("/")
    public List<Hr> getAllHrs(String hrName) {
        return hrService.getAllHrs(hrName);
    }

    /**
     * 查询所有角色
     * @return
     */
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    /**
     * 修改管理员
     * @param hr
     * @return
     */
    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 修改管理员角色
     * @param hrid 管理员编号
     * @param rids 多个角色编号
     * @return
     */
    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid,Integer[] rids) {
        if (hrService.updateHrRole(hrid,rids)) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 删除管理员
     * @param id 管理员编号
     * @return
     */
    @DeleteMapping("/{id}")
    public RespBean deleteHr(@PathVariable Integer id) {
        if (hrService.deleteHr(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
    @PostMapping("/")
    public RespBean deleteHr(@RequestBody Hr hr) {
        if (hrService.insertHr(hr) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }
}
