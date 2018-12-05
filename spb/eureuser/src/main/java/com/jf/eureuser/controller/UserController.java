package com.jf.eureuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/buyticket")
    public String byTick(String name,String size){
        String forObject = restTemplate.getForObject("http://EURETICK/ticket?size="+size, String.class);
        return name+forObject;
    }
}
