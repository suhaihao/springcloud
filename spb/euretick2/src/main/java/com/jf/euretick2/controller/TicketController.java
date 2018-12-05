package com.jf.euretick2.controller;

import com.jf.euretick2.service.TicketService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.HttpMethodConstraint;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket")
    @HystrixCommand(fallbackMethod = "erromsg")
    public String getTic(String size){
//        throw  new RuntimeException("超市");
        return ticketService.getTicket(size);
    }
    public String erromsg(String size){
        return "出现错误";
    }
}
