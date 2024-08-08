package com.techchallenge.lanchonete.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String CLIENT_EXCHANGE = "clientExchange";
    public static final String CLIENT_CREATED_QUEUE = "clientCreatedQueue";
    public static final String CLIENT_UPDATED_QUEUE = "clientUpdatedQueue";
    public static final String CLIENT_DELETED_QUEUE = "clientDeletedQueue";
    public static final String CLIENT_CREATED_ROUTING_KEY = "client.created";
    public static final String CLIENT_UPDATED_ROUTING_KEY = "client.updated";
    public static final String CLIENT_DELETED_ROUTING_KEY = "client.deleted";

    @Bean
    DirectExchange clientExchange() {
        return new DirectExchange(CLIENT_EXCHANGE);
    }

    @Bean
    Queue clientCreatedQueue() {
        return new Queue(CLIENT_CREATED_QUEUE, true);
    }

    @Bean
    Queue clientUpdatedQueue() {
        return new Queue(CLIENT_UPDATED_QUEUE, true);
    }

    @Bean
    Queue clientDeletedQueue() {
        return new Queue(CLIENT_DELETED_QUEUE, true);
    }

    @Bean
    Binding clientCreatedBinding(DirectExchange clientExchange, Queue clientCreatedQueue) {
        return BindingBuilder.bind(clientCreatedQueue).to(clientExchange).with(CLIENT_CREATED_ROUTING_KEY);
    }

    @Bean
    Binding clientUpdatedBinding(DirectExchange clientExchange, Queue clientUpdatedQueue) {
        return BindingBuilder.bind(clientUpdatedQueue).to(clientExchange).with(CLIENT_UPDATED_ROUTING_KEY);
    }

    @Bean
    Binding clientDeletedBinding(DirectExchange clientExchange, Queue clientDeletedQueue) {
        return BindingBuilder.bind(clientDeletedQueue).to(clientExchange).with(CLIENT_DELETED_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jsonMessageConverter());
        return factory;
    }
}
