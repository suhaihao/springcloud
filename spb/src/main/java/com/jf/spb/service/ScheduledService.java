package com.jf.spb.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    /**
     * 定时任务
     */
    @Scheduled(cron = "0 * * * * 6")
    public void say(){
        System.out.println("hello");
    }
}
