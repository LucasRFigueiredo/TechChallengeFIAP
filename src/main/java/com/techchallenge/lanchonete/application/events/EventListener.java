package com.techchallenge.lanchonete.application.events;

import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.configuration.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EventListener {

    private static final Logger logger = LoggerFactory.getLogger(EventListener.class);

    @RabbitListener(queues = RabbitMQConfig.CLIENT_CREATED_QUEUE)
    public void handleClientCreatedEvent(ClienteDTO clienteDTO) {
        logger.info("Cliente criado: {}", clienteDTO);
        // Processar evento de cliente criado
    }

    @RabbitListener(queues = RabbitMQConfig.CLIENT_UPDATED_QUEUE)
    public void handleClientUpdatedEvent(ClienteDTO clienteDTO) {
        logger.info("Cliente atualizado: {}", clienteDTO);
        // Processar evento de cliente atualizado
    }

    @RabbitListener(queues = RabbitMQConfig.CLIENT_DELETED_QUEUE)
    public void handleClientDeletedEvent(ClienteDTO clienteDTO) {
        logger.info("Cliente deletado: {}", clienteDTO);
        // Processar evento de cliente deletado
    }
}
