package org.javaboy.vhr.controller.sys.basic;

import org.javaboy.vhr.bean.Menu;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.bean.Role;
import org.javaboy.vhr.service.MenuService;
import org.javaboy.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xdf
 * @Description: 基础信息设置——权限组
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    /**
     * 查询所有角色
     *
     * @return
     */
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    /**
     * 查询所有菜单
     *
     * @return
     */
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    /**
     * 跟据角色 id 查询菜单 id
     *
     * @param rid
     * @return
     */
    @GetMapping("/mids/{rid}")
    public List<Integer> getMenuIdsByRid(@PathVariable Integer rid) {
        return menuService.getMenuIdsByRid(rid);
    }

    /**
     * 更新角色权限
     *
     * @param rid  角色编号
     * @param mids 菜单编号
     * @return 响应结果
     */
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 添加角色
     *
     * @param role 角色信息
     * @return 响应结果
     */
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 删除角色
     *
     * @param rid 角色编号
     * @return 响应结果
     */
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid) {
        if (roleService.deleteRole(rid) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
