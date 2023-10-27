package com.techchallenge.lanchonete.produto.adapter;

import com.techchallenge.lanchonete.produto.domain.Dto.ProdutoDTO;
import com.techchallenge.lanchonete.produto.port.interfaces.ProdutoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoServicePort produtoServicePort;

    @PostMapping
    void criarProduto(@RequestBody ProdutoDTO produtoDto) {
        produtoServicePort.criar(produtoDto);
    }

    @PutMapping
    void editarProduto(@RequestBody ProdutoDTO produtoDto) {
        produtoServicePort.editar(produtoDto);
    }

    @DeleteMapping
    void removerProduto(@PathVariable Long id) {
        produtoServicePort.remover(id);
    }
}
