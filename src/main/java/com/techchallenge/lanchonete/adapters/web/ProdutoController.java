package com.techchallenge.lanchonete.adapters.web;

import com.techchallenge.lanchonete.application.dto.ProdutoDTO;
import com.techchallenge.lanchonete.application.port.incoming.produto.CriarProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.EditarProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.RemoverProdutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final CriarProdutoUseCase criarProdutoUseCase;
    private final EditarProdutoUseCase editarProdutoUseCase;
    private final RemoverProdutoUseCase removerProdutoUseCase;

    @PostMapping
    void criarProduto(@RequestBody ProdutoDTO produtoDto) {
        criarProdutoUseCase.criar(produtoDto);
    }

    @PutMapping
    void editarProduto(@RequestBody ProdutoDTO produtoDto) {
        editarProdutoUseCase.editar(produtoDto);
    }

    @DeleteMapping(value = "/{id}")
    void removerProduto(@PathVariable Long id) {
        removerProdutoUseCase.remover(id);
    }
}
