package com.techchallenge.lanchonete.config;

import com.techchallenge.lanchonete.LanchoneteApplication;
import com.techchallenge.lanchonete.cliente.domain.mapper.ClienteMapper;
import com.techchallenge.lanchonete.cliente.domain.service.ClienteServiceImpl;
import com.techchallenge.lanchonete.cliente.port.interfaces.ClienteServicePort;
import com.techchallenge.lanchonete.cliente.port.repository.ClienteRepositoryPort;
import com.techchallenge.lanchonete.pedido.domain.mapper.PedidoMapper;
import com.techchallenge.lanchonete.pedido.domain.service.PedidoServiceImpl;
import com.techchallenge.lanchonete.pedido.port.interfaces.PedidoServicePort;
import com.techchallenge.lanchonete.pedido.port.repository.PedidoRepositoryPort;
import com.techchallenge.lanchonete.produto.domain.mapper.ProdutoMapper;
import com.techchallenge.lanchonete.produto.domain.service.ProdutoServiceImpl;
import com.techchallenge.lanchonete.produto.port.interfaces.ProdutoServicePort;
import com.techchallenge.lanchonete.produto.port.repository.ProdutoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = LanchoneteApplication.class, basePackages = {"com.techchallenge.lanchonete.cliente.domain.mapper", "com.techchallenge.lanchonete.pedido.domain.mapper", "com.techchallenge.lanchonete.produto.domain.mapper"})
public class BeanConfiguration {
    @Bean
    ClienteServicePort clienteServicePort(ClienteRepositoryPort clienteRepositoryPort, ClienteMapper clienteMapper) {
        return new ClienteServiceImpl(clienteRepositoryPort, clienteMapper);
    }

    @Bean
    ProdutoServicePort produtoServicePort(ProdutoRepositoryPort produtoRepositoryPort, ProdutoMapper produtoMapper) {
        return new ProdutoServiceImpl(produtoRepositoryPort, produtoMapper);
    }

    @Bean
    PedidoServicePort pedidoServicePort(PedidoMapper pedidoMapper, PedidoRepositoryPort pedidoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort) {
        return new PedidoServiceImpl(pedidoMapper, pedidoRepositoryPort, clienteRepositoryPort, produtoRepositoryPort);
    }
}
