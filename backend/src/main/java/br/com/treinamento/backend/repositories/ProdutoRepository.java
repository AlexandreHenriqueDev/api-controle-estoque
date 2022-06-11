package br.com.treinamento.backend.repositories;

import br.com.treinamento.backend.entities.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    Optional<Produto> findProdutoByCodigo(String codigo);

}
