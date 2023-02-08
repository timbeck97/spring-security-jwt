/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.jwt.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author tim
 */
@Component
public class RabbitConfiguration {
    public static final String EXCHANGE_NAME = "topic-name";

    public static final String queueName = "EMAIL_QUEUE";

    public static final String ROUTING_KEY = "";


    @Bean
    public Exchange declareExchange() {
        return ExchangeBuilder.directExchange(EXCHANGE_NAME)
                .durable(true)
                .build();
    }
    @Bean
    public Queue declareQueue() {
        return QueueBuilder.durable(queueName)
                .build();
    }

    @Bean
    public Binding declareBinding(Exchange exchange, Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(ROUTING_KEY)
                .noargs();
    }
}