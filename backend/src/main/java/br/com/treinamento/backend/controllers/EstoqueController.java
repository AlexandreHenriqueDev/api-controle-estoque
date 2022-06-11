package br.com.treinamento.backend.controllers;

import br.com.treinamento.backend.dto.ProdutoDto;
import br.com.treinamento.backend.services.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/controleEstoque")
public class EstoqueController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/healthcheck")
    public ResponseEntity<String> healthcheck() {
        return ResponseEntity.ok("Ok");
    }

    @PostMapping(value = "/inserir")
    public void inserirNovoProdutoEstoque(@RequestBody ProdutoDto produto) {

    }

}
