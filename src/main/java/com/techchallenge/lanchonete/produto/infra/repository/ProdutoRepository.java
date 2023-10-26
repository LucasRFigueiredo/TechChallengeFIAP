package com.techchallenge.lanchonete.produto.infra.repository;

import com.techchallenge.lanchonete.produto.domain.entity.Produto;
import com.techchallenge.lanchonete.produto.infra.entity.ProdutoEntity;
import com.techchallenge.lanchonete.produto.port.repository.ProdutoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProdutoRepository implements ProdutoRepositoryPort {
    private final SpringProdutoRepository springProdutoRepository;

    @Override
    public void salvar(Produto produto) {
        ProdutoEntity produtoById = springProdutoRepository.findById(produto.getId()).get();
        if (Objects.isNull(produtoById)) {
            ProdutoEntity produtoEntity = new ProdutoEntity(produto);
            this.springProdutoRepository.save(produtoEntity);
        } else {
            throw new RuntimeException("Produto existente, uso o editar");
        }
    }

    @Override
    public void editar(Produto produto) {
        ProdutoEntity produtoById = springProdutoRepository.findById(produto.getId()).get();
        if (!Objects.isNull(produtoById)) {
            produtoById.atualizar(produto);
            this.springProdutoRepository.save(produtoById);
        } else {
            throw new RuntimeException("Produto inexistente, realize o cadastro com o criar");
        }
    }

    @Override
    public void buscar(Long id) {
        if (Objects.isNull(springProdutoRepository.findById(id).get())) {
            throw new RuntimeException("Produto inexistente, realize o cadastro com o criar");
        }
    }

    @Override
    public void remover(Long id) {
        springProdutoRepository.deleteById(id);
    }
}
