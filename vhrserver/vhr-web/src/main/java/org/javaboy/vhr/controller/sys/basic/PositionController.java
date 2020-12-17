package org.javaboy.vhr.controller.sys.basic;

import org.javaboy.vhr.bean.Position;
import org.javaboy.vhr.bean.PositionDto;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xdf
 * @Description: 基础信息设置——职位管理
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    PositionService positionService;

    /**
     * 查询所有职位信息
     * @return 所有职位信息集合
     */
    @GetMapping("/")
    public List<Position> getAllPosition() {
        return positionService.getAllPosition();
    }

    /**
     * 添加职位信息
     *
     * @param position 职位类型
     * @return 响应结果
     */
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 修改职位信息
     *
     * @param position 职位类型
     * @return 响应结果
     */
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updatePosition(position) == 1) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 删除职位信息
     *
     * @param id 职位编号
     * @return 响应结果
     */
    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        if (positionService.deletePosition(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    /**
     * 删除多条职位信息
     *
     * @param ids 多条 Id
     * @return 响应结果
     */
    @DeleteMapping("/")
    public RespBean deleteManyPosition(Integer[] ids) {
        if (positionService.deleteManyPosition(ids) == ids.length) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    /**
     * 查询所有职位信息
     * @return 所有职位信息集合
     */
    @GetMapping("/names")
    public List<PositionDto> getAllPositionNames() {
        return positionService.getAllPositionNames();
    }
}
