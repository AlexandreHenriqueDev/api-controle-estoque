package br.com.treinamento.backend.services.impl;

import br.com.treinamento.backend.dtos.ProdutoDto;
import br.com.treinamento.backend.entities.Estoque;
import br.com.treinamento.backend.entities.Produto;
import br.com.treinamento.backend.exception.BadRequestException;
import br.com.treinamento.backend.repositories.ProdutoRepository;
import br.com.treinamento.backend.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public Produto inserir(ProdutoDto produtoDto, Estoque estoque) {
        Optional<Produto> produtoNoBanco = repository.findProdutoByCodigo(produtoDto.getCodigo());
        if(produtoNoBanco.isPresent()) {
            throw new BadRequestException("Já existe um produto com o código " + produtoDto.getCodigo());
        }
        Produto produtoSalvar = produtoDto.toEntity();
        produtoSalvar.setEstoque(estoque);
        return repository.save(produtoSalvar);
    }

    @Override
    public ProdutoDto atualizar(ProdutoDto produtoDto) {

        Optional<Produto> produto = repository.findById(produtoDto.getId());
        if(!produto.isPresent()) {
            throw new BadRequestException("Produto não encontrado");
        }

        if(produtoDto.getQuantidade() < 0) {
            throw new BadRequestException("Quantidade inválida");
        }

        Produto produtoAtualizado = produtoDto.toEntity();
        produtoAtualizado.setId(produto.get().getId());
        produtoAtualizado.setEstoque(produto.get().getEstoque());

        return repository.save(produtoAtualizado).toDto();
    }

    @Override
    public void deletar(ProdutoDto produtoDto) {

        Optional<Produto> produto = repository.findById(produtoDto.getId());
        if(!produto.isPresent()) {
            throw new BadRequestException("Produto não encontrado");
        }

        repository.delete(produto.get());
    }

}
