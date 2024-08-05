package com.techchallenge.lanchonete.configuration;

import com.techchallenge.lanchonete.LanchoneteApplication;
import com.techchallenge.lanchonete.application.events.EventPublisher;
import com.techchallenge.lanchonete.application.gateways.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.cliente.CriarClienteUseCase;
import com.techchallenge.lanchonete.application.usecases.ClienteServiceImpl;
import com.techchallenge.lanchonete.infrastructure.gateways.ClienteRepositoryGateway;
import com.techchallenge.lanchonete.infrastructure.mapper.cliente.ClienteEntityMapper;
import com.techchallenge.lanchonete.infrastructure.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.infrastructure.persistence.repository.cliente.SpringClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = LanchoneteApplication.class, basePackages = {"com.techchallenge.lanchonete.cliente.domain.mapper", "com.techchallenge.lanchonete.pedido.domain.mapper", "com.techchallenge.lanchonete.produto.domain.mapper"})
public class BeanConfiguration {

    @Bean
    public ClienteServiceImpl clienteService(CriarClienteUseCase criarClienteUseCase,
                                             BuscarClienteUseCase buscarClienteUseCase,
                                             ClienteMapper clienteMapper,
                                             EventPublisher eventPublisher) {
        return new ClienteServiceImpl(criarClienteUseCase, buscarClienteUseCase, clienteMapper, eventPublisher);
    }

    @Bean
    CriarClienteUseCase criarClienteUseCase(SpringClienteRepository springClienteRepository,
                                            ClienteEntityMapper clienteEntityMapper) {
        return new ClienteRepositoryGateway(springClienteRepository, clienteEntityMapper);
    }

    @Bean
    BuscarClienteUseCase buscarClienteUseCase(SpringClienteRepository springClienteRepository,
                                              ClienteEntityMapper clienteEntityMapper) {
        return new ClienteRepositoryGateway(springClienteRepository, clienteEntityMapper);
    }
}
