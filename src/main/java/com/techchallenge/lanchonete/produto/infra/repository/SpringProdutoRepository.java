package com.techchallenge.lanchonete.produto.infra.repository;

import com.techchallenge.lanchonete.produto.infra.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
