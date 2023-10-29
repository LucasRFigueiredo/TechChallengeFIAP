package com.techchallenge.lanchonete.adapters.web;

import com.techchallenge.lanchonete.application.dto.ProdutoDTO;
import com.techchallenge.lanchonete.application.port.incoming.produto.BuscarTipoProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.CriarProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.EditarProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.RemoverProdutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final CriarProdutoUseCase criarProdutoUseCase;
    private final BuscarTipoProdutoUseCase buscarTipoProdutoUseCase;
    private final EditarProdutoUseCase editarProdutoUseCase;
    private final RemoverProdutoUseCase removerProdutoUseCase;

    @PostMapping
    void criarProduto(@RequestBody ProdutoDTO produtoDto) {

        criarProdutoUseCase.criar(produtoDto);
    }

    @GetMapping(value = "/{tipo}")
    List<ProdutoDTO> buscarProdutoPorTipo(@PathVariable String tipo) {
        return buscarTipoProdutoUseCase.buscarTipo(tipo);
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
