package com.jf.tatic.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Component
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket(String size) {
        return "您获取的车票数量为"+size;
    }
}
