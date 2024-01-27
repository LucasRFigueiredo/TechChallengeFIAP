package com.techchallenge.lanchonete.application.usecases;

import com.techchallenge.lanchonete.domain.Cliente;
import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.infrastructure.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.application.gateways.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.cliente.CriarClienteUseCase;


public class ClienteServiceImpl {
    private final CriarClienteUseCase criarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;
    private final ClienteMapper clienteMapper;

    public ClienteServiceImpl(CriarClienteUseCase criarClienteUseCase, BuscarClienteUseCase buscarClienteUseCase,
                              ClienteMapper clienteMapper) {
        this.criarClienteUseCase = criarClienteUseCase;
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.clienteMapper = clienteMapper;
    }


    public void criar(Cliente cliente) {
        criarClienteUseCase.criar(cliente);
    }


    public ClienteDTO buscar(String cpf) {
        return clienteMapper.clienteToClienteDTO(buscarClienteUseCase.buscar(cpf));
    }
}
