package br.com.treinamento.backend.services;

import br.com.treinamento.backend.dtos.EstoqueDto;
import br.com.treinamento.backend.dtos.ProdutoDto;

import java.util.List;

public interface EstoqueService {

    List<EstoqueDto> listarTodos();
    EstoqueDto novoEstoque(EstoqueDto estoque);
    EstoqueDto novoProdutoProdutoEstoque(Long idEstoque, ProdutoDto produtoDto);

}
