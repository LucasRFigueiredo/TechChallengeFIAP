package com.techchallenge.lanchonete.infrastructure.persistence.repository.produto;

import com.techchallenge.lanchonete.infrastructure.persistence.entities.ProdutoEntity;
import com.techchallenge.lanchonete.application.domain.Produto;
import com.techchallenge.lanchonete.infrastructure.gateways.mapper.produto.ProdutoEntityMapper;
import com.techchallenge.lanchonete.application.port.outgoing.ProdutoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
    public void buscar(Long id) {
        if (Objects.isNull(springProdutoRepository.findById(id))) {
            throw new RuntimeException("Produto inexistente, realize o cadastro com o criar");
        }
    }

    @Override
    public List<Produto> buscarTipo(String tipo) {
        List<ProdutoEntity> produtoEntities = this.springProdutoRepository.findByTipo(tipo);
        List<Produto> produtos = new ArrayList<>();
        for (ProdutoEntity produtoEntity : produtoEntities) {
            Produto produto = new Produto();
            produto.setTipo(produtoEntity.getTipo());
            produto.setId(produtoEntity.getId());
            produto.setDescricao(produtoEntity.getDescricao());
            produto.setNome(produtoEntity.getNome());
            produto.setPreco(produtoEntity.getPreco());
            produtos.add(produto);
        }
        return produtos;
    }

    @Override
    public void editar(Produto produto, Long id) {
        ProdutoEntity produtoById = springProdutoRepository.findById(id).get();
        if (!Objects.isNull(produtoById)) {
            produtoById = produtoEntityMapper.updateProdutoEntity(produto, produtoById);
            this.springProdutoRepository.save(produtoById);
        } else {
            throw new RuntimeException("Produto inexistente, realize o cadastro com o criar");
        }
    }

    @Override
    public void remover(Long id) {
        springProdutoRepository.deleteById(id);
    }
}
