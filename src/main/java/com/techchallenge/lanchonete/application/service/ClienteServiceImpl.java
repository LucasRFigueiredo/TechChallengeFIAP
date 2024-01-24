package com.techchallenge.lanchonete.application.service;

import com.techchallenge.lanchonete.application.domain.Cliente;
import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.infrastructure.gateways.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.application.port.incoming.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.port.incoming.cliente.CriarClienteUseCase;
import com.techchallenge.lanchonete.application.port.outgoing.ClienteRepositoryPort;
import lombok.AllArgsConstructor;


public class ClienteServiceImpl {
    private final CriarClienteUseCase criarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;
    private final ClienteRepositoryPort clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteServiceImpl(CriarClienteUseCase criarClienteUseCase, BuscarClienteUseCase buscarClienteUseCase,
                              ClienteRepositoryPort clienteRepository, ClienteMapper clienteMapper) {
        this.criarClienteUseCase = criarClienteUseCase;
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public void criar(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.clienteDTOtoCliente(clienteDTO);
        this.clienteRepository.salvar(cliente);
    }
    public ClienteDTO buscar(String cpf) {
        return clienteMapper.clienteToClienteDTO(this.clienteRepository.buscar(cpf));
    }
}
