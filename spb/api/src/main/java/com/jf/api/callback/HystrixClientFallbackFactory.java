package com.jf.api.callback;

import com.jf.api.service.FegnService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<FegnService> {
    @Override
    public FegnService create(Throwable throwable) {
        return new FegnService() {
            @Override
            public String getTic(String size) {
                return "发生错误";
            }
        };
    }
}
