package org.javaboy.vhr.controller.sys.basic;

import org.javaboy.vhr.bean.JobLevel;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xdf
 * @Description: 基础信息设置——职称管理
 *
 */
@RestController
@RequestMapping("/system/basic/jobLevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;

    /**
     * 查询职称
     *
     * @return 职称信息集合
     */
    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    /**
     * 添加职称
     *
     * @param jobLevel 职称信息
     * @return 响应结果
     */
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 更新职称
     *
     * @param jobLevel 职称信息
     * @return 响应结果
     */
    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevel(jobLevel) == 1) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 删除职称
     *
     * @param id 职称 id
     * @return 相应结果
     */
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevel(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    /**
     * 删除多条职称
     *
     * @param ids 多条职称 Id
     * @return 相应结果
     */
    @DeleteMapping("/")
    public RespBean deleteManyJobLevel(Integer[] ids) {
        if (jobLevelService.deleteManyJobLevel(ids) == ids.length) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
