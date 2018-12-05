package com.jf.spb.config;

import com.jf.spb.tool.MD5Util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilConfig {
    @Bean
    public MD5Util mD5Util(){
        return new MD5Util();
    }
}
