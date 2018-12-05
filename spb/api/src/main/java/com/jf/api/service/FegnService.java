package com.jf.api.service;

import com.jf.api.callback.HystrixClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "EURETICK",fallbackFactory = HystrixClientFallbackFactory.class)
public interface FegnService {
    @GetMapping(value = "/ticket")
    public String getTic(@RequestParam("size") String size);
}
