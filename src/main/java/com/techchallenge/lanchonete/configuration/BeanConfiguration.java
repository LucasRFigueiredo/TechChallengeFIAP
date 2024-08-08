package com.techchallenge.lanchonete.configuration;

import com.techchallenge.lanchonete.LanchoneteApplication;
import com.techchallenge.lanchonete.application.events.EventPublisher;
import com.techchallenge.lanchonete.application.gateways.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.cliente.CriarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.cliente.AtualizarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.cliente.DeletarClienteUseCase;
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
                                             AtualizarClienteUseCase atualizarClienteUseCase,
                                             DeletarClienteUseCase deletarClienteUseCase,
                                             ClienteMapper clienteMapper,
                                             EventPublisher eventPublisher) {
        return new ClienteServiceImpl(criarClienteUseCase, buscarClienteUseCase, atualizarClienteUseCase, deletarClienteUseCase, clienteMapper, eventPublisher);
    }

    @Bean
    public ClienteRepositoryGateway clienteRepositoryGateway(SpringClienteRepository springClienteRepository,
                                                             ClienteEntityMapper clienteEntityMapper) {
        return new ClienteRepositoryGateway(springClienteRepository, clienteEntityMapper);
    }

    @Bean
    public CriarClienteUseCase criarClienteUseCase(ClienteRepositoryGateway clienteRepositoryGateway) {
        return clienteRepositoryGateway;
    }

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(ClienteRepositoryGateway clienteRepositoryGateway) {
        return clienteRepositoryGateway;
    }

    @Bean
    public AtualizarClienteUseCase atualizarClienteUseCase(ClienteRepositoryGateway clienteRepositoryGateway) {
        return clienteRepositoryGateway;
    }

    @Bean
    public DeletarClienteUseCase deletarClienteUseCase(ClienteRepositoryGateway clienteRepositoryGateway) {
        return clienteRepositoryGateway;
    }
}
