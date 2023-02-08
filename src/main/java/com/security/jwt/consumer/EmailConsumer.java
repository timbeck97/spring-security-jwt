/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.jwt.consumer;

import com.security.jwt.configuration.RabbitConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author tim
 */
@Service
public class EmailConsumer {

    @RabbitListener(queues = RabbitConfiguration.queueName)
    public void consumer(String message){
        System.out.println("-----> READING MESSAGE <-----");
        System.out.println(message);

    }
}
