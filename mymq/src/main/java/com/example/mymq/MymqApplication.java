package com.example.mymq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MymqApplication {

    @Autowired
    MesSend mesSend;

    public static void main(String[] args) {
        SpringApplication.run(MymqApplication.class, args);
    }

    @GetMapping("/send")
    public void send1(){
        mesSend.send1();
        mesSend.send2();
    }

}
