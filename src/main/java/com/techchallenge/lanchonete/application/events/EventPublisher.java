package com.techchallenge.lanchonete.application.events;

import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public EventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishClientCreatedEvent(ClienteDTO clientDTO) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.CLIENT_CREATED_QUEUE, clientDTO);
    }

    public void publishClientUpdatedEvent(ClienteDTO clientDTO) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.CLIENT_UPDATED_QUEUE, clientDTO);
    }

    public void publishClientDeletedEvent(ClienteDTO clientDTO) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.CLIENT_DELETED_QUEUE, clientDTO);
    }
}
