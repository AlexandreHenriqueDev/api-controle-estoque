package br.com.treinamento.backend.controllers;

import br.com.treinamento.backend.dtos.EstoqueDto;
import br.com.treinamento.backend.dtos.ProdutoDto;
import br.com.treinamento.backend.services.EstoqueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @GetMapping(value = "/healthcheck")
    public ResponseEntity<String> healthcheck() {
        return ResponseEntity.ok("Ok");
    }

    @GetMapping
    public ResponseEntity<List<EstoqueDto>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<EstoqueDto> novo(@RequestBody EstoqueDto estoqueDto) {
        return ResponseEntity.ok(service.novoEstoque(estoqueDto));
    }

    @PostMapping(value = "/{idEstoque}/inserirProduto")
    public ResponseEntity<EstoqueDto> adicionarProdutoEstoque(@PathVariable("idEstoque") Long idEstoque,
                                                              @RequestBody ProdutoDto produtoDto) {
        return ResponseEntity.ok(service.novoProdutoProdutoEstoque(idEstoque, produtoDto));
    }

}
