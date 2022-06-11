package br.com.treinamento.backend.services;

import br.com.treinamento.backend.dtos.ProdutoDto;
import br.com.treinamento.backend.entities.Estoque;
import br.com.treinamento.backend.entities.Produto;

public interface ProdutoService {

    Produto inserir(ProdutoDto produtoDto, Estoque estoque);
    void deletar(ProdutoDto produtoDto);
    ProdutoDto atualizar(ProdutoDto produtoDto);

}
