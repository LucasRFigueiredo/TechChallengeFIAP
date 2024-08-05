package com.techchallenge.lanchonete.application.events;

import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EventListener {

    private static final Logger logger = LoggerFactory.getLogger(EventListener.class);

    @RabbitListener(queues = RabbitMQConfig.CLIENT_CREATED_QUEUE)
    public void handleClientCreatedEvent(ClienteDTO clientDTO) {
        logger.info("Cliente criado: {}", clientDTO);
    }

    @RabbitListener(queues = RabbitMQConfig.CLIENT_UPDATED_QUEUE)
    public void handleClientUpdatedEvent(ClienteDTO clientDTO) {
        logger.info("Cliente atualizado: {}", clientDTO);
    }

    @RabbitListener(queues = RabbitMQConfig.CLIENT_DELETED_QUEUE)
    public void handleClientDeletedEvent(ClienteDTO clientDTO) {
        logger.info("Cliente deletado: {}", clientDTO);
    }
}
