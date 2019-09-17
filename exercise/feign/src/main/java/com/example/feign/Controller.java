package com.example.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    FeignServer feignServer;


    @GetMapping("/hello1")
    public String hello2(){
        return new HystrixTest(feignServer).execute();
    }

    public String hello1(){
        return restTemplate.getForObject("http://service-hi/hello",String.class);
    }
}
