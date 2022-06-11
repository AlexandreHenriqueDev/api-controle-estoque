package br.com.treinamento.backend.controllers;

import br.com.treinamento.backend.dtos.ProdutoDto;
import br.com.treinamento.backend.services.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/healthcheck")
    public ResponseEntity<String> healthcheck() {
        return ResponseEntity.ok("Ok");
    }

    @PutMapping
    public ResponseEntity<ProdutoDto> editar(@RequestBody ProdutoDto produtoDto) {
        return ResponseEntity.ok(service.atualizar(produtoDto));
    }

    @DeleteMapping
    public ResponseEntity<String> deletar(@RequestBody ProdutoDto produtoDto) {
        service.deletar(produtoDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

}
