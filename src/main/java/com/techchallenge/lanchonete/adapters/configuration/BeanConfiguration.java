package com.techchallenge.lanchonete.adapters.configuration;

import com.techchallenge.lanchonete.LanchoneteApplication;
import com.techchallenge.lanchonete.application.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.application.mapper.pedido.PedidoMapper;
import com.techchallenge.lanchonete.application.mapper.produto.ProdutoMapper;
import com.techchallenge.lanchonete.application.port.incoming.checkout.CheckoutUseCase;
import com.techchallenge.lanchonete.application.port.incoming.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.port.incoming.cliente.CriarClienteUseCase;
import com.techchallenge.lanchonete.application.port.incoming.pedido.CriarPedidoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.pedido.ListarPedidoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.CriarProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.EditarProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.RemoverProdutoUseCase;
import com.techchallenge.lanchonete.application.port.outgoing.ClienteRepositoryPort;
import com.techchallenge.lanchonete.application.port.outgoing.PedidoRepositoryPort;
import com.techchallenge.lanchonete.application.port.outgoing.ProdutoRepositoryPort;
import com.techchallenge.lanchonete.application.service.CheckoutServiceImpl;
import com.techchallenge.lanchonete.application.service.ClienteServiceImpl;
import com.techchallenge.lanchonete.application.service.PedidoServiceImpl;
import com.techchallenge.lanchonete.application.service.ProdutoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = LanchoneteApplication.class, basePackages = {"com.techchallenge.lanchonete.cliente.domain.mapper", "com.techchallenge.lanchonete.pedido.domain.mapper", "com.techchallenge.lanchonete.produto.domain.mapper"})
public class BeanConfiguration {
    @Bean
    CriarClienteUseCase criarClienteUseCase(ClienteRepositoryPort clienteRepositoryPort, ClienteMapper clienteMapper) {
        return new ClienteServiceImpl(clienteRepositoryPort, clienteMapper);
    }

    @Bean
    BuscarClienteUseCase buscarClienteUseCase(ClienteRepositoryPort clienteRepositoryPort, ClienteMapper clienteMapper) {
        return new ClienteServiceImpl(clienteRepositoryPort, clienteMapper);
    }

    @Bean
    CriarProdutoUseCase criarProdutoUseCase(ProdutoRepositoryPort produtoRepositoryPort, ProdutoMapper produtoMapper) {
        return new ProdutoServiceImpl(produtoRepositoryPort, produtoMapper);
    }

    @Bean
    EditarProdutoUseCase editarProdutoUseCase(ProdutoRepositoryPort produtoRepositoryPort, ProdutoMapper produtoMapper) {
        return new ProdutoServiceImpl(produtoRepositoryPort, produtoMapper);
    }

    @Bean
    RemoverProdutoUseCase removerProdutoUseCase(ProdutoRepositoryPort produtoRepositoryPort, ProdutoMapper produtoMapper) {
        return new ProdutoServiceImpl(produtoRepositoryPort, produtoMapper);
    }

    @Bean
    CriarPedidoUseCase criarPedidoUseCase(PedidoMapper pedidoMapper, PedidoRepositoryPort pedidoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort, CheckoutServiceImpl checkoutService) {
        return new PedidoServiceImpl(pedidoMapper, pedidoRepositoryPort, clienteRepositoryPort, produtoRepositoryPort, checkoutService);
    }

    @Bean
    ListarPedidoUseCase listarPedidoUseCase(PedidoMapper pedidoMapper, PedidoRepositoryPort pedidoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort, CheckoutServiceImpl checkoutService) {
        return new PedidoServiceImpl(pedidoMapper, pedidoRepositoryPort, clienteRepositoryPort, produtoRepositoryPort, checkoutService);
    }

    @Bean
    CheckoutUseCase checkoutUseCase(PedidoMapper pedidoMapper, PedidoRepositoryPort pedidoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort, CheckoutServiceImpl checkoutService) {
        return new PedidoServiceImpl(pedidoMapper, pedidoRepositoryPort, clienteRepositoryPort, produtoRepositoryPort, checkoutService);
    }
}
