package com.techchallenge.lanchonete.application.events;

import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.configuration.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    private static final Logger logger = LoggerFactory.getLogger(EventPublisher.class);
    private final RabbitTemplate rabbitTemplate;

    public EventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishClientCreatedEvent(ClienteDTO clienteDTO) {
        logger.info("Publicando evento de cliente criado: {}", clienteDTO);
        rabbitTemplate.convertAndSend(RabbitMQConfig.CLIENT_EXCHANGE, RabbitMQConfig.CLIENT_CREATED_ROUTING_KEY, clienteDTO);
    }

    public void publishClientUpdatedEvent(ClienteDTO clienteDTO) {
        logger.info("Publicando evento de cliente atualizado: {}", clienteDTO);
        rabbitTemplate.convertAndSend(RabbitMQConfig.CLIENT_EXCHANGE, RabbitMQConfig.CLIENT_UPDATED_ROUTING_KEY, clienteDTO);
    }

    public void publishClientDeletedEvent(ClienteDTO clienteDTO) {
        logger.info("Publicando evento de cliente deletado: {}", clienteDTO);
        rabbitTemplate.convertAndSend(RabbitMQConfig.CLIENT_EXCHANGE, RabbitMQConfig.CLIENT_DELETED_ROUTING_KEY, clienteDTO);
    }
}
