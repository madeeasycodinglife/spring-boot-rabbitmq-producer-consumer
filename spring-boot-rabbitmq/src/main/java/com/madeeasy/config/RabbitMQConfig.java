package com.madeeasy.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "hello";
    public static final String TOPIC_EXCHANGE_NAME = "topic_exchange";
    public static final String TOPIC_ROUTING_KEY = "topic_routing_key";

    /**
     * spring bean for rabbitmq queue
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    /**
     * spring bean for rabbitmq exchange
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    /**
     * binding between queue and exchange using routing key
     */


    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(TOPIC_ROUTING_KEY);
    }

    /**
     * Spring boot autoconfiguration provides following beans
     * ConnectionFactory
     * RabbitTemplate
     * RabbitAdmin
     */

}
