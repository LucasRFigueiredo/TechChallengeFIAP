package com.techchallenge.lanchonete.application.service;

import com.techchallenge.lanchonete.application.domain.Cliente;
import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.application.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.application.port.incoming.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.port.incoming.cliente.CriarClienteUseCase;
import com.techchallenge.lanchonete.application.port.outgoing.ClienteRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClienteServiceImpl implements CriarClienteUseCase, BuscarClienteUseCase {
    private final ClienteRepositoryPort clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public void criar(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.clienteDTOtoCliente(clienteDTO);
        this.clienteRepository.salvar(cliente);
    }

    @Override
    public ClienteDTO buscar(String cpf) {
        return clienteMapper.clienteToClienteDTO(this.clienteRepository.buscar(cpf));
    }
}
