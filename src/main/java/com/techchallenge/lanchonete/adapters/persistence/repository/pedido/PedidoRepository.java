package com.techchallenge.lanchonete.adapters.persistence.repository.pedido;

import com.techchallenge.lanchonete.adapters.persistence.entity.PedidoEntity;
import com.techchallenge.lanchonete.application.domain.Pedido;
import com.techchallenge.lanchonete.application.mapper.pedido.PedidoEntityMapper;
import com.techchallenge.lanchonete.application.port.outgoing.PedidoRepositoryPort;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class PedidoRepository implements PedidoRepositoryPort {

    private final SpringPedidoRepository springPedidoRepository;
    private final PedidoEntityMapper pedidoEntityMapper;
    private final EntityManager entityManager;

    @Override
    public void salvar(Pedido pedido) {
        PedidoEntity pedidoEntity;
        if (Objects.isNull(pedido.getId())) {
            pedidoEntity = pedidoEntityMapper.pedidoToPedidoEntity(pedido);
        } else {
            pedidoEntity = this.springPedidoRepository.findById(pedido.getId()).get();
            pedidoEntity = pedidoEntityMapper.pedidoToPedidoEntity(pedido);
        }
        pedidoEntity = entityManager.merge(pedidoEntity);
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

    @Override
    public Pedido buscar(Long id) {
        Optional<PedidoEntity> pedidoEntity = this.springPedidoRepository.findById(id);
        if (pedidoEntity.isPresent()) {
            Pedido pedido = pedidoEntityMapper.pedidoEntityToPedido(pedidoEntity.get());
            return pedido;
        }
        throw new RuntimeException("Pedido não encontrado");
    }
}
