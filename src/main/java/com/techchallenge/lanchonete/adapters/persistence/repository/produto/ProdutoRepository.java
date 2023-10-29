package com.techchallenge.lanchonete.adapters.persistence.repository.produto;

import com.techchallenge.lanchonete.adapters.persistence.entity.ProdutoEntity;
import com.techchallenge.lanchonete.application.domain.Produto;
import com.techchallenge.lanchonete.application.mapper.produto.ProdutoEntityMapper;
import com.techchallenge.lanchonete.application.port.outgoing.ProdutoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProdutoRepository implements ProdutoRepositoryPort {
    private final SpringProdutoRepository springProdutoRepository;
    private final ProdutoEntityMapper produtoEntityMapper;

    @Override
    public void salvar(Produto produto) {
        ProdutoEntity produtoEntity = produtoEntityMapper.produtoToProdutoEntity(produto);
        this.springProdutoRepository.save(produtoEntity);
    }

    @Override
    public void editar(Produto produto) {
        ProdutoEntity produtoById = springProdutoRepository.findById(produto.getId()).get();
        if (!Objects.isNull(produtoById)) {
            produtoById = produtoEntityMapper.produtoToProdutoEntity(produto);
            this.springProdutoRepository.save(produtoById);
        } else {
            throw new RuntimeException("Produto inexistente, realize o cadastro com o criar");
        }
    }

    @Override
    public void buscar(Long id) {
        if (Objects.isNull(springProdutoRepository.findById(id))) {
            throw new RuntimeException("Produto inexistente, realize o cadastro com o criar");
        }
    }

    @Override
    public void remover(Long id) {
        springProdutoRepository.deleteById(id);
    }
}
