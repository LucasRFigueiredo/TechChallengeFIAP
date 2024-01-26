package com.techchallenge.lanchonete.adapters.configuration;

import com.techchallenge.lanchonete.LanchoneteApplication;
import com.techchallenge.lanchonete.adapters.persistence.repository.cliente.SpringClienteRepository;
import com.techchallenge.lanchonete.adapters.persistence.repository.pedido.PedidoRepository;
import com.techchallenge.lanchonete.adapters.persistence.repository.pedido.SpringPedidoRepository;
import com.techchallenge.lanchonete.adapters.persistence.repository.produto.SpringProdutoRepository;
import com.techchallenge.lanchonete.application.mapper.checkout.CheckoutMapper;
import com.techchallenge.lanchonete.application.mapper.cliente.ClienteEntityMapper;
import com.techchallenge.lanchonete.application.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.application.mapper.pedido.PedidoEntityMapper;
import com.techchallenge.lanchonete.application.mapper.pedido.PedidoMapper;
import com.techchallenge.lanchonete.application.mapper.produto.ProdutoEntityMapper;
import com.techchallenge.lanchonete.application.mapper.produto.ProdutoMapper;
import com.techchallenge.lanchonete.application.port.incoming.checkout.CheckoutUseCase;
import com.techchallenge.lanchonete.application.port.incoming.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.port.incoming.cliente.CriarClienteUseCase;
import com.techchallenge.lanchonete.application.port.incoming.pedido.CriarPedidoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.pedido.ListarPedidoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.*;
import com.techchallenge.lanchonete.application.port.outgoing.CheckoutRepositoryPort;
import com.techchallenge.lanchonete.application.port.outgoing.ClienteRepositoryPort;
import com.techchallenge.lanchonete.application.service.CheckoutServiceImpl;
import com.techchallenge.lanchonete.application.service.ClienteServiceImpl;
import com.techchallenge.lanchonete.application.service.PedidoServiceImpl;
import com.techchallenge.lanchonete.application.service.ProdutoServiceImpl;
import com.techchallenge.lanchonete.infrastructure.gateways.ClienteRepositoryGateway;
import com.techchallenge.lanchonete.infrastructure.gateways.PedidoRepositoryGateway;
import com.techchallenge.lanchonete.infrastructure.gateways.ProdutoRepositoryGateway;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = LanchoneteApplication.class, basePackages = {"com.techchallenge.lanchonete.cliente.domain.mapper", "com.techchallenge.lanchonete.pedido.domain.mapper", "com.techchallenge.lanchonete.produto.domain.mapper"})
public class BeanConfiguration {

    @Bean
    public CriarProdutoUseCase criarProdutoUseCase(SpringProdutoRepository springProdutoRepository, ProdutoEntityMapper produtoEntityMapper) {
        return new ProdutoRepositoryGateway(springProdutoRepository, produtoEntityMapper); // Substitua pela sua implementação real
    }

    @Bean
    public BuscarTipoProdutoUseCase buscarTipoProdutoUseCase(SpringProdutoRepository springProdutoRepository, ProdutoEntityMapper produtoEntityMapper) {
        return new ProdutoRepositoryGateway(springProdutoRepository, produtoEntityMapper);
    }

    @Bean
    public BuscarProdutoUseCase buscarProdutoUseCase(SpringProdutoRepository springProdutoRepository, ProdutoEntityMapper produtoEntityMapper) {
        return new ProdutoRepositoryGateway(springProdutoRepository, produtoEntityMapper);
    }

    @Bean
    public EditarProdutoUseCase editarProdutoUseCase(SpringProdutoRepository springProdutoRepository, ProdutoEntityMapper produtoEntityMapper) {
        return new ProdutoRepositoryGateway(springProdutoRepository, produtoEntityMapper);
    }

    @Bean
    public RemoverProdutoUseCase removerProdutoUseCase(SpringProdutoRepository springProdutoRepository, ProdutoEntityMapper produtoEntityMapper) {
        return new ProdutoRepositoryGateway(springProdutoRepository, produtoEntityMapper);
    }

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
                                             BuscarProdutoUseCase buscarProdutoUseCase, EditarProdutoUseCase editarProdutoUseCase,
                                             RemoverProdutoUseCase removerProdutoUseCase,
                                             ProdutoMapper produtoMapper) {
        return new ProdutoServiceImpl(criarProdutoUseCase, buscarTipoProdutoUseCase, buscarProdutoUseCase, editarProdutoUseCase, removerProdutoUseCase, produtoMapper);
    }

    @Bean
    public PedidoServiceImpl pedidoService(CriarPedidoUseCase criarPedidoUseCase, ListarPedidoUseCase listarPedidoUseCase,
                                           BuscarProdutoUseCase buscarProdutoUseCase, BuscarClienteUseCase buscarClienteUseCase,
                                           PedidoMapper pedidoMapper, CheckoutServiceImpl checkoutService) {
        return new PedidoServiceImpl(criarPedidoUseCase, listarPedidoUseCase, buscarProdutoUseCase, buscarClienteUseCase,
                pedidoMapper, checkoutService);
    }

    @Bean
    public CriarPedidoUseCase criarPedidoUseCase(SpringPedidoRepository springPedidoRepository, PedidoEntityMapper pedidoEntityMapper,
                                                 EntityManager entityManager) {
        return new PedidoRepositoryGateway(springPedidoRepository, pedidoEntityMapper, entityManager);
    }

    @Bean
    CheckoutUseCase checkoutUseCase(CheckoutMapper checkoutMapper, PedidoRepository pedidoRepository, CheckoutRepositoryPort checkoutRepositoryPort) {
        return new CheckoutServiceImpl(checkoutMapper, pedidoRepository, checkoutRepositoryPort);
    }
}
