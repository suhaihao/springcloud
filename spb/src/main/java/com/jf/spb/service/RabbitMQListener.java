package com.jf.spb.service;

import com.jf.spb.bean.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {
    /**
     * 监听列队执行方法
     * @param employee
     */
    @RabbitListener(queues = "jf.queue")
    public void getmsg(Employee employee) {
        System.out.println(employee);
    }
}
