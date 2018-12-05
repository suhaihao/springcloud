package com.jf.user.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jf.tatic.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Reference
    TicketService ticketService;

    public void getticket(){
        System.out.println(ticketService.getTicket("20"));
    }
}
