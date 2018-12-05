package com.jf.euretick.controller;

import com.jf.euretick.service.TicketService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @GetMapping("/ticket")
    @HystrixCommand(fallbackMethod = "erromsg")
    public String getTic(String size){
        return ticketService.getTicket(size);
    }
    public String erromsg(String size){
        return "发生错误";
    }
}
