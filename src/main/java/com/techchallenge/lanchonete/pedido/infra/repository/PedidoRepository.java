package com.techchallenge.lanchonete.pedido.infra.repository;

import com.techchallenge.lanchonete.pedido.domain.entity.Pedido;
import com.techchallenge.lanchonete.pedido.infra.entity.PedidoEntity;
import com.techchallenge.lanchonete.pedido.port.repository.PedidoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PedidoRepository implements PedidoRepositoryPort {

    private final SpringPedidoRepository springPedidoRepository;

    @Override
    public void salvar(Pedido pedido) {
        PedidoEntity pedidoEntity;
        if (Objects.isNull(pedido.getId())) {
            pedidoEntity = new PedidoEntity(pedido);
        } else {
            pedidoEntity = this.springPedidoRepository.findById(pedido.getId()).get();
            pedidoEntity.atualizar(pedido);
        }
        this.springPedidoRepository.save(pedidoEntity);
    }

    @Override
    public List<Pedido> listarPedido() {
        List<PedidoEntity> pedidoEntities = this.springPedidoRepository.findAll();
        return pedidoEntities.stream().map(PedidoEntity::toPedido).collect(Collectors.toList());
    }
}
