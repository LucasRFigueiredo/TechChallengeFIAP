package com.techchallenge.lanchonete.produto.adapter;

import com.techchallenge.lanchonete.produto.domain.Dto.ProdutoDto;
import com.techchallenge.lanchonete.produto.port.interfaces.ProdutoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoServicePort produtoServicePort;

    @PostMapping
    void criarProduto(@RequestBody ProdutoDto produtoDto) {
        produtoServicePort.criar(produtoDto);
    }

    @PutMapping
    void editarProduto(@RequestBody ProdutoDto produtoDto) {
        produtoServicePort.editar(produtoDto);
    }

    @DeleteMapping
    void removerProduto(@PathVariable Long id) {
        produtoServicePort.remover(id);
    }
}
