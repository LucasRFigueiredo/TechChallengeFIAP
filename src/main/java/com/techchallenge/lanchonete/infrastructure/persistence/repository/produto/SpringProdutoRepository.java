package com.techchallenge.lanchonete.infrastructure.persistence.repository.produto;

import com.techchallenge.lanchonete.infrastructure.persistence.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    List<ProdutoEntity> findByTipo(String tipo);
}
