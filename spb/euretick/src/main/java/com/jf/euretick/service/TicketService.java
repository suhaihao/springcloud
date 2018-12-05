package com.jf.euretick.service;

import org.springframework.stereotype.Service;

@Service
public class TicketService {
    public String getTicket(String size){
        return "获取电影票8001"+size;
    }
}
