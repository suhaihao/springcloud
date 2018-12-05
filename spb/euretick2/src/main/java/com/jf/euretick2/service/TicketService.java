package com.jf.euretick2.service;

import org.springframework.stereotype.Service;

@Service
public class TicketService {
    public String getTicket(String size){
        return "获取电影票8002"+size;
    }
}
