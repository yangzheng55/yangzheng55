package com.example.mymq;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicRabbitConfig {
    public static final String message = "topic.message";

    public static final String messages = "topic.messages";

    /**
     * 定义消息队列1
     * @return
     */
    @Bean(name = "queueMessage")
    public Queue messageQueue(){
        return new Queue(TopicRabbitConfig.message);
    }

    /**
     * 定义消息队列2
     * @return
     */
    @Bean(name = "queueMessages")
    public Queue messagesQueue(){
        return new Queue(TopicRabbitConfig.messages);
    }

    /**
     * 定义交换机
     */
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }

    /**
     * 绑定消息队列到交换机,路由key:topic.message
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }


    /**
     * 绑定消息队列到交换机,路由key:topic.#
     * @return
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

}
