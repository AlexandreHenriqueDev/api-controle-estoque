package br.com.treinamento.backend.services.impl;

import br.com.treinamento.backend.dtos.EstoqueDto;
import br.com.treinamento.backend.dtos.ProdutoDto;
import br.com.treinamento.backend.entities.Estoque;
import br.com.treinamento.backend.entities.Produto;
import br.com.treinamento.backend.exception.BadRequestException;
import br.com.treinamento.backend.repositories.EstoqueRepository;
import br.com.treinamento.backend.services.EstoqueService;
import br.com.treinamento.backend.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public List<EstoqueDto> listarTodos() {
        return repository.findAll().stream().map(estoque -> estoque.toDto()).collect(Collectors.toList());
    }

    @Override
    public EstoqueDto novoEstoque(EstoqueDto estoque) {

        if(repository.findEstoqueByCodigo(estoque.getCodigo()).isPresent()) {
            throw new BadRequestException("Já existe um estoque com o código " + estoque.getCodigo());
        }

        repository.save(estoque.toEntity());
        return repository.findEstoqueByCodigo(estoque.getCodigo()).get().toDto();
    }

    @Override
    @Transactional
    public EstoqueDto novoProdutoProdutoEstoque(Long idEstoque, ProdutoDto produtoDto) {

        Optional<Estoque> estoque = repository.findById(idEstoque);
        if(!estoque.isPresent()) {
            throw new BadRequestException("Estoque não encontrado");
        }

        Produto produto = produtoService.inserir(produtoDto, estoque.get());
        estoque.get().getProdutos().add(produto);

        return repository.save(estoque.get()).toDto();
    }
}
