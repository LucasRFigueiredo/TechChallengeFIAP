package com.techchallenge.lanchonete.adapters.configuration;

import com.techchallenge.lanchonete.LanchoneteApplication;
import com.techchallenge.lanchonete.adapters.persistence.repository.cliente.SpringClienteRepository;
import com.techchallenge.lanchonete.adapters.persistence.repository.pedido.PedidoRepository;
import com.techchallenge.lanchonete.adapters.persistence.repository.produto.SpringProdutoRepository;
import com.techchallenge.lanchonete.application.mapper.checkout.CheckoutMapper;
import com.techchallenge.lanchonete.application.mapper.cliente.ClienteEntityMapper;
import com.techchallenge.lanchonete.application.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.application.mapper.pedido.PedidoMapper;
import com.techchallenge.lanchonete.application.mapper.produto.ProdutoEntityMapper;
import com.techchallenge.lanchonete.application.mapper.produto.ProdutoMapper;
import com.techchallenge.lanchonete.application.port.incoming.checkout.CheckoutUseCase;
import com.techchallenge.lanchonete.application.port.incoming.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.port.incoming.cliente.CriarClienteUseCase;
import com.techchallenge.lanchonete.application.port.incoming.pedido.CriarPedidoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.pedido.ListarPedidoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.BuscarTipoProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.CriarProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.EditarProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.RemoverProdutoUseCase;
import com.techchallenge.lanchonete.application.port.outgoing.CheckoutRepositoryPort;
import com.techchallenge.lanchonete.application.port.outgoing.ClienteRepositoryPort;
import com.techchallenge.lanchonete.application.port.outgoing.PedidoRepositoryPort;
import com.techchallenge.lanchonete.application.port.outgoing.ProdutoRepositoryPort;
import com.techchallenge.lanchonete.application.service.CheckoutServiceImpl;
import com.techchallenge.lanchonete.application.service.ClienteServiceImpl;
import com.techchallenge.lanchonete.application.service.PedidoServiceImpl;
import com.techchallenge.lanchonete.application.service.ProdutoServiceImpl;
import com.techchallenge.lanchonete.infrastructure.gateways.ClienteRepositoryGateway;
import com.techchallenge.lanchonete.infrastructure.gateways.ProdutoRepositoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = LanchoneteApplication.class, basePackages = {"com.techchallenge.lanchonete.cliente.domain.mapper", "com.techchallenge.lanchonete.pedido.domain.mapper", "com.techchallenge.lanchonete.produto.domain.mapper"})
public class BeanConfiguration {
   /* @Bean
    CriarClienteUseCase criarClienteUseCase(CriarClienteUseCase criarClienteUseCase, BuscarClienteUseCase buscarClienteUseCase, ClienteRepositoryPort clienteRepositoryPort, ClienteMapper clienteMapper) {
        return new ClienteServiceImpl(criarClienteUseCase, buscarClienteUseCase, clienteRepositoryPort, clienteMapper);
    }

   @Bean
    BuscarClienteUseCase buscarClienteUseCase(ClienteRepositoryPort clienteRepositoryPort, ClienteMapper clienteMapper) {
        return new ClienteServiceImpl(clienteRepositoryPort, clienteMapper);
    }*/

    @Bean
    public ClienteServiceImpl clienteService(CriarClienteUseCase criarClienteUseCase,
                                             BuscarClienteUseCase buscarClienteUseCase,
                                             ClienteRepositoryPort clienteRepository,
                                             ClienteMapper clienteMapper) {
        return new ClienteServiceImpl(criarClienteUseCase, buscarClienteUseCase, clienteRepository, clienteMapper);
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

    @Bean
    public ProdutoServiceImpl produtoService(CriarProdutoUseCase criarProdutoUseCase, BuscarTipoProdutoUseCase buscarTipoProdutoUseCase,
                                             EditarProdutoUseCase editarProdutoUseCase, RemoverProdutoUseCase removerProdutoUseCase,
                                             ProdutoMapper produtoMapper) {
        return new ProdutoServiceImpl(criarProdutoUseCase, buscarTipoProdutoUseCase, editarProdutoUseCase, removerProdutoUseCase, produtoMapper);
    }

    @Bean
    public CriarProdutoUseCase criarProdutoUseCase(SpringProdutoRepository springProdutoRepository, ProdutoEntityMapper produtoEntityMapper) {
        return new ProdutoRepositoryGateway(springProdutoRepository, produtoEntityMapper);
    }



   /* @Bean
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
    }*/

    @Bean
    CriarPedidoUseCase criarPedidoUseCase(PedidoMapper pedidoMapper, PedidoRepositoryPort pedidoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort, CheckoutServiceImpl checkoutService) {
        return new PedidoServiceImpl(pedidoMapper, pedidoRepositoryPort, clienteRepositoryPort, produtoRepositoryPort, checkoutService);
    }

    @Bean
    ListarPedidoUseCase listarPedidoUseCase(PedidoMapper pedidoMapper, PedidoRepositoryPort pedidoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort, CheckoutServiceImpl checkoutService) {
        return new PedidoServiceImpl(pedidoMapper, pedidoRepositoryPort, clienteRepositoryPort, produtoRepositoryPort, checkoutService);
    }

    @Bean
    CheckoutUseCase checkoutUseCase(CheckoutMapper checkoutMapper, PedidoRepository pedidoRepository, CheckoutRepositoryPort checkoutRepositoryPort) {
        return new CheckoutServiceImpl(checkoutMapper, pedidoRepository, checkoutRepositoryPort);
    }
}
