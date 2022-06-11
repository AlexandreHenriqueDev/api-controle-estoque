package br.com.treinamento.backend.repositories;

import br.com.treinamento.backend.entities.Estoque;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EstoqueRepository extends CrudRepository<Estoque, Long> {

    List<Estoque> findAll();
    Optional<Estoque> findEstoqueByCodigo(String codigo);
}
