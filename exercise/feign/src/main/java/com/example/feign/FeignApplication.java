package com.example.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@RestController
@EnableHystrix
public class FeignApplication {

    @Autowired
    FeignServer feignServer;
//    @Autowired
//    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return feignServer.hello();
    }

//    @GetMapping("/hello1")
//    public String hello1(){
//        return restTemplate.getForObject("http://server-hi/hello",String.class);
//    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }
}
