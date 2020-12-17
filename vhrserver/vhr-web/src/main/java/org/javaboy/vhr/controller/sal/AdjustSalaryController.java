package org.javaboy.vhr.controller.sal;

import org.javaboy.vhr.bean.AdjustSalary;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.service.AdjustSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: xdf
 * @Description:
 * @Date: Created in 21:37 2020/12/13
 */
@RestController
@RequestMapping("/adjustSalary/basic")
public class AdjustSalaryController {

    @Autowired
    private AdjustSalaryService adjustSalaryService;

    /**
     * 员工调薪
     * @param adjustSalary
     * @return
     */
    @PostMapping("/")
    public RespBean addAdjustSalary(@RequestBody AdjustSalary adjustSalary){
        if (adjustSalaryService.addAdjustSalary(adjustSalary) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 修改员工调薪
     * @param adjustSalary
     * @return
     */
    @PutMapping("/")
    public RespBean updateAdjustSalary(@RequestBody AdjustSalary adjustSalary){
        if (adjustSalaryService.updateAdjustSalary(adjustSalary) == 1) {
            return RespBean.ok("修改成功！");
        }
        return RespBean.error("修改失败！");
    }

    /**
     * 根据员工id查询调整薪资
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public RespBean getAdjustSalary(@PathVariable Integer id){
        AdjustSalary adjustSalary = adjustSalaryService.getAdjustSalary(id);
        if (null != adjustSalary){
            return RespBean.ok("查询成功",adjustSalary);
        }
        return RespBean.error("该员工还没有调整过薪资哦！",null);
    }

}
