package com.example.mymq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MesSend {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send1(){
        String context = "hi, i am message 1";

        amqpTemplate.convertAndSend("topicExchange","topic.message",context);
    }


    public void send2(){
        String context = "hi, i am message 2";

        amqpTemplate.convertAndSend("topicExchange","topic.messages",context);//交换机、路邮键
    }
}
