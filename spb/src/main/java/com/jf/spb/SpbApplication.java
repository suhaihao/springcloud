package com.jf.spb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableRabbit
@EnableScheduling
@MapperScan("com.jf.spb.dao")
@SpringBootApplication
public class SpbApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpbApplication.class, args);
	}
}
