package com.techchallenge.lanchonete.configuration;

import com.techchallenge.lanchonete.LanchoneteApplication;
import com.techchallenge.lanchonete.application.gateways.checkout.CheckoutUseCase;
import com.techchallenge.lanchonete.application.gateways.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.cliente.CriarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.pedido.CriarPedidoUseCase;
import com.techchallenge.lanchonete.application.gateways.pedido.ListarPedidoUseCase;
import com.techchallenge.lanchonete.application.gateways.produto.*;
import com.techchallenge.lanchonete.application.usecases.*;
import com.techchallenge.lanchonete.infrastructure.gateways.CheckoutRepositoryGateway;
import com.techchallenge.lanchonete.infrastructure.gateways.ClienteRepositoryGateway;
import com.techchallenge.lanchonete.infrastructure.gateways.PedidoRepositoryGateway;
import com.techchallenge.lanchonete.infrastructure.gateways.ProdutoRepositoryGateway;
import com.techchallenge.lanchonete.infrastructure.mapper.checkout.CheckoutEntityMapper;
import com.techchallenge.lanchonete.infrastructure.mapper.checkout.CheckoutMapper;
import com.techchallenge.lanchonete.infrastructure.mapper.cliente.ClienteEntityMapper;
import com.techchallenge.lanchonete.infrastructure.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.infrastructure.mapper.pedido.PedidoEntityMapper;
import com.techchallenge.lanchonete.infrastructure.mapper.pedido.PedidoMapper;
import com.techchallenge.lanchonete.infrastructure.mapper.produto.ProdutoEntityMapper;
import com.techchallenge.lanchonete.infrastructure.mapper.produto.ProdutoMapper;
import com.techchallenge.lanchonete.infrastructure.persistence.repository.checkout.SpringCheckoutRepository;
import com.techchallenge.lanchonete.infrastructure.persistence.repository.cliente.SpringClienteRepository;
import com.techchallenge.lanchonete.infrastructure.persistence.repository.pedido.SpringPedidoRepository;
import com.techchallenge.lanchonete.infrastructure.persistence.repository.produto.SpringProdutoRepository;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
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
                                             ClienteMapper clienteMapper) {
        return new ClienteServiceImpl(criarClienteUseCase, buscarClienteUseCase, clienteMapper);
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
    CheckoutUseCase checkoutUseCase(SpringCheckoutRepository springCheckoutRepository, CheckoutEntityMapper checkoutEntityMapper, EntityManager entityManager) {
        return new CheckoutRepositoryGateway(springCheckoutRepository, checkoutEntityMapper, entityManager);
    }

    @Bean
    CheckoutServiceImpl checkoutService(CheckoutUseCase checkoutUseCase, CheckoutMapper checkoutMapper) {
        return new CheckoutServiceImpl(checkoutUseCase, checkoutMapper);
    }

    @Bean
    PagamentoServiceImpl pagamentoService(CheckoutUseCase checkoutUseCase) {
        return new PagamentoServiceImpl(checkoutUseCase);
    }

    @Bean
    public CommandLineRunner init(CheckoutServiceImpl checkoutService) {
        return args -> {
            checkoutService.iniciarTarefaAtualizacaoStatus();
        };
    }
}
