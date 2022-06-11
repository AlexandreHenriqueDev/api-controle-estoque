package br.com.treinamento.backend.services.impl;

import br.com.treinamento.backend.dto.ProdutoDto;
import br.com.treinamento.backend.models.Produto;
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
    public ProdutoDto inserirProduto(ProdutoDto produtoDto) {

        try {
            Optional<Produto> produtoNoBanco = repository.findProdutoByNome(produtoDto.getNome());
            if(produtoNoBanco.isPresent()) {
                throw new Exception("Já existe um produto cadastrado com este nome");
            }
            Produto produtoSalvar = produtoDto.toEntity();
            repository.save(produtoSalvar);
            return produtoSalvar.toDto();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
