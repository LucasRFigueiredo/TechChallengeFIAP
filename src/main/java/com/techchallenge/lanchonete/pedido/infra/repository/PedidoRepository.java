package com.techchallenge.lanchonete.pedido.infra.repository;

import com.techchallenge.lanchonete.pedido.domain.entity.Pedido;
import com.techchallenge.lanchonete.pedido.domain.mapper.PedidoEntityMapper;
import com.techchallenge.lanchonete.pedido.infra.entity.PedidoEntity;
import com.techchallenge.lanchonete.pedido.port.repository.PedidoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PedidoRepository implements PedidoRepositoryPort {

    private final SpringPedidoRepository springPedidoRepository;
    private final PedidoEntityMapper pedidoEntityMapper;

    @Override
    public void salvar(Pedido pedido) {
        PedidoEntity pedidoEntity;
        if (Objects.isNull(pedido.getId())) {
            pedidoEntity = pedidoEntityMapper.pedidoToPedidoEntity(pedido);
        } else {
            pedidoEntity = this.springPedidoRepository.findById(pedido.getId()).get();
            pedidoEntity = pedidoEntityMapper.pedidoToPedidoEntity(pedido);
        }
        this.springPedidoRepository.save(pedidoEntity);
    }

    @Override
    public List<Pedido> listarPedido() {
        List<PedidoEntity> pedidoEntities = this.springPedidoRepository.findAll();
        if (!pedidoEntities.isEmpty()) {
            List<Pedido> pedidos = new ArrayList<>();
            for (PedidoEntity pedidoEntity : pedidoEntities) {
                Pedido pedido = pedidoEntityMapper.pedidoEntityToPedido(pedidoEntity);
                pedidos.add(pedido);
            }
            return pedidos;
        }
        return Collections.emptyList();
    }
}
