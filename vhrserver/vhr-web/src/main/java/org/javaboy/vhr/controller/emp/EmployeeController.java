package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.bean.*;
import org.javaboy.vhr.service.*;
import org.javaboy.vhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Author: xdf
 * @Description: employee控制器
 *     员工资料——基本资料
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PoliticsstatusService politicsstatusService;
    @Autowired
    NationService nationService;
    @Autowired
    PositionService positionService;
    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    DepartmentService departmentService;

    /**
     * 分页查询全部员工基本资料
     *
     * @param page    当前页码
     * @param size    页大小
     * @return
     */
    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer size,
                                          Employee employee,
                                          Date[] beginDateScope) {
        return employeeService.getEmployeeByPage(page, size, employee, beginDateScope);
    }

    /**
     * 添加员工
     *
     * @param employee
     * @return
     */
    @PostMapping("/")
    public RespBean addEmployee(@RequestBody Employee employee) {
        if (employeeService.addEmployee(employee) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 返回员工自增工号 + 1
     *
     * @return
     */
    @GetMapping("/maxWorkID")
    public RespBean maxWorkID() {
        RespBean respBean = RespBean.build().setStatus(200).setObj(String.format("%08d", employeeService.maxWorkID() + 1));
        return respBean;
    }

    /**
     * 删除员工
     *
     * @param id 编号
     * @return
     */
    @DeleteMapping("/{id}")
    public RespBean deleteEmployee(@PathVariable Integer id) {
        if (employeeService.deleteEmployee(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    /**
     * 修改员工
     *
     * @param employee
     * @return
     */
    @PutMapping("/")
    public RespBean updateEmployee(@RequestBody Employee employee) {
        if (employeeService.updateEmployee(employee) == 1) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 分页导出员工数据 Excel 表格
     *
     * @param page    当前页码
     * @param size    页大小
     * @return
     */
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData(@RequestParam(defaultValue = "1") Integer page,
                                             @RequestParam(defaultValue = "10") Integer size,
                                             Employee employee,
                                             Date[] beginDateScope) {
        List<Employee> employeeList = ((List<Employee>) employeeService.getEmployeeByPage(page, size, employee, beginDateScope).getData());
        return POIUtils.employee2Excel(employeeList);
    }

    /**
     * 导入员工数据
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excel2Employee(file, nationService.getAllNations(), politicsstatusService.getAllPoliticsstatus(), departmentService.getAllDepartmentsWithOutChildren(), positionService.getAllPosition(), jobLevelService.getAllJobLevels());
        for (Employee employee : list) {
            System.out.println(employee.toString());
        }
        if (employeeService.addEmp(list) == 1) {
            return RespBean.ok("上传成功！");
        }
        return RespBean.error("上传失败！");
    }

    /**
     * 查询所有政治面貌
     *
     * @return
     */
    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusService.getAllPoliticsstatus();
    }

    /**
     * 查询所有民族
     *
     * @return
     */
    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    /**
     * 查询所有职位
     *
     * @return
     */
    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAllPosition();
    }

    /**
     * 查询所有职称
     *
     * @return
     */
    @GetMapping("/joblevels")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    /**
     * 查询所有部门
     *
     * @return
     */
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }


    /**
     * 查询所有员工姓名
     *
     * @return
     */
    @GetMapping("/names")
    public List<EmployeeNameDto> getAllEmployeeNames() {
        return employeeService.getAllEmployeeNames();
    }


    /**
     * 更新员工评分
     */
    @PutMapping("/updateRateById/{id}/{rate}")
    public RespBean updateRateById(@PathVariable Integer id,@PathVariable Integer rate){
        if (employeeService.updateRateById(id,rate) == 1) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 查询某个员工评分
     */
    @GetMapping("/getRateById/{id}")
    public RespBean getRateById(@PathVariable Integer id){
        Integer rateById = employeeService.getRateById(id);
        if (rateById != -1) {
            return RespBean.ok("查询成功！",rateById);
        }
        return RespBean.error("查询失败！",rateById);
    }
}
