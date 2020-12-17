package org.javaboy.vhr.service;

import org.javaboy.vhr.bean.Employee;
import org.javaboy.vhr.bean.RespPageBean;
import org.javaboy.vhr.mapper.EmployeeMapper;
import org.javaboy.vhr.bean.EmployeeNameDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: xdf
 * @Description: 员工实现类
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    MailProperties mailProperties;

    @Autowired
    TemplateEngine templateEngine;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    SimpleDateFormat yearformat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthformat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size; // 分页公式
        }
        // 分页数据
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, employee, beginDateScope);
        // 数据总数量
        Long total = employeeMapper.getTotal(employee, beginDateScope);
        return new RespPageBean(total, data);
    }

    public Integer addEmployee(Employee employee) {
        // 添加员工时并计算合同期限
        Date endContract = employee.getEndContract();
        Date beginContract = employee.getBeginContract();
        double month = (Double.parseDouble(yearformat.format(endContract)) - Double.parseDouble(yearformat.format(beginContract))) * 12 + (Double.parseDouble(monthformat.format(endContract)) - Double.parseDouble(monthformat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));

        //今年的年份
        Integer nowYear = Integer.valueOf(yearformat.format(new Date()));
        //入职的年份
        Integer beginYear = Integer.valueOf(yearformat.format(employee.getBeginDate()));
        employee.setWorkAge(nowYear-beginYear);
        Integer jiFen = getJiFen(employee.getTiptopDegree());
        employee.setIntegrate(employee.getWorkAge()+jiFen);
        int result = employeeMapper.insertSelective(employee);
        if (result == 1) {
            // 收到消息，发送邮件
            Employee oldEmp = employeeMapper.getEmployeeById(employee.getId());
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg);
            try {
                helper.setTo(oldEmp.getEmail());
                helper.setFrom(mailProperties.getUsername());
                helper.setSubject("入职欢迎");
                helper.setSentDate(new Date());
                Context context = new Context();
                context.setVariable("name", oldEmp.getName());
                context.setVariable("posName", oldEmp.getPosition().getName());
                context.setVariable("jobLevelName", oldEmp.getJobLevel().getName());
                context.setVariable("departmentName", oldEmp.getDepartment().getName());
                String mail = templateEngine.process("mail", context);
                helper.setText(mail, true);
                javaMailSender.send(msg);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Integer getJiFen(String tiptopDegree){
        //设置积分
        Integer jifen = 0;
        if ("初中".equals(tiptopDegree)){
            jifen = 1;
        }else if ("高中".equals(tiptopDegree)){
            jifen = 2;
        }else if ("专科".equals(tiptopDegree)){
            jifen = 3;
        }else if ("本科".equals(tiptopDegree)){
            jifen = 4;
        }else if ("研究生".equals(tiptopDegree)){
            jifen = 5;
        }else if ("硕士".equals(tiptopDegree)){
            jifen = 6;
        }else if ("博士".equals(tiptopDegree)){
            jifen = 7;
        }
        return jifen;
    }
    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }

    public Integer deleteEmployee(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmployee(Employee employee) {
        // 修改员工时并计算合同期限
        Date endContract = employee.getEndContract();
        Date beginContract = employee.getBeginContract();
        double month = (Double.parseDouble(yearformat.format(endContract)) - Double.parseDouble(yearformat.format(beginContract))) * 12 + (Double.parseDouble(monthformat.format(endContract)) - Double.parseDouble(monthformat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        //今年的年份
        Integer nowYear = Integer.valueOf(yearformat.format(new Date()));
        //入职的年份
        Integer beginYear = Integer.valueOf(yearformat.format(employee.getBeginDate()));
        employee.setWorkAge(nowYear-beginYear);
        Employee employeeOld = employeeMapper.selectByPrimaryKey(employee.getId());
        Integer jiFen = getJiFen(employeeOld.getTiptopDegree());

        employee.setIntegrate((nowYear-beginYear)+jiFen+employeeOld.getRate());

        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer addEmp(List<Employee> list) {
        return employeeMapper.addEmp(list);
    }

    public RespPageBean getEmployeeByPageWithSalary(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> employeeList = employeeMapper.getEmployeeByPageWithSalary(page, size);
        Long total = employeeMapper.getTotal(null, null);
        return new RespPageBean(total, employeeList);
    }

    public Integer updateEmpSalary(Integer eid, Integer sid) {
        return employeeMapper.updateEmpSalary(eid, sid);
    }

    public Employee getEmployeeById(Integer empId) {
        return employeeMapper.getEmployeeById(empId);
    }

    public List<EmployeeNameDto> getAllEmployeeNames() {
        return employeeMapper.getAllEmployeeNames();
    }

    public Integer updateRateById(Integer id, Integer rate) {
        Employee employeeOld = employeeMapper.selectByPrimaryKey(id);
        Integer integrate = (employeeOld.getIntegrate()-employeeOld.getRate()+rate);
        return employeeMapper.updateRateById(id,rate,integrate);
    }

    public Integer getRateById(Integer id) {
        return employeeMapper.getRateById(id);
    }
}
