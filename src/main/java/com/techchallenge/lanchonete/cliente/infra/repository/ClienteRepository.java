package com.techchallenge.lanchonete.cliente.infra.repository;

import com.techchallenge.lanchonete.cliente.domain.entity.Cliente;
import com.techchallenge.lanchonete.cliente.infra.entity.ClienteEntity;
import com.techchallenge.lanchonete.cliente.port.repository.ClienteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteRepository implements ClienteRepositoryPort {

    private final SpringClienteRepository springClienteRepository;
    @Override
    public void salvar(Cliente cliente) {
        ClienteEntity clienteEntity;
        if(Objects.isNull(cliente.getCpf())){
            clienteEntity = new ClienteEntity(cliente);
        } else{
            clienteEntity = this.springClienteRepository.findByCPF(cliente.getCpf()).get();
            clienteEntity.atualizar(cliente);
        }
        this.springClienteRepository.save(clienteEntity);
    }

    @Override
    public Cliente buscar(String cpf) {
        Optional<ClienteEntity> clienteEntity = this.springClienteRepository.findByCPF(cpf);
        if(clienteEntity.isPresent()){
            return clienteEntity.get().toCliente();
        }
        throw new RuntimeException("Cliente não existe");
    }
}
