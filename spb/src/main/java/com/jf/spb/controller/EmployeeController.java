package com.jf.spb.controller;

import com.jf.spb.bean.Employee;
import com.jf.spb.service.AsyncService;
import com.jf.spb.service.EMailService;
import com.jf.spb.service.EmployeeService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AsyncService syncService;
    @Autowired
    EMailService eMailService;

    @GetMapping("/emp/{id}")
    public Employee checkemp(@PathVariable int id){
        Employee byID = employeeService.getByID(id);
        return byID;
    }
    @GetMapping("/rabbit/emps/{id}")
    public Employee sendmsg(@PathVariable int id){
        Employee byID = employeeService.getByID(id);
        rabbitTemplate.convertAndSend("jf.exchange","jf.emp",byID);
        return byID;
    }

    @GetMapping("/asyn/")
    public String Asny(){
        return "suc";
    }

    @GetMapping("/fsEmail/")
    public String fsEmali(){
        eMailService.fsEMail();
        return "suc";
    }

}
