package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-hi")
public interface FeignServer {

    @GetMapping("/hello")
    public String hello();
}
