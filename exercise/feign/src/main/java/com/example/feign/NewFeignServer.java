package com.example.feign;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewFeignServer {

    @Autowired
    RestTemplate restTemplate;

    public String hello1(){
        return restTemplate.getForObject("http://service-hi/hello",String.class);
    }

//    @Autowired
//    FeignServer feignServer;
//
//    @HystrixCommand
//    public String hello() {
//        String msg = feignServer.hello();
//        return msg;
//    }
//
//    public String fallback() {
//        return "银行服务升级中，暂不可用!";
//    }
}
