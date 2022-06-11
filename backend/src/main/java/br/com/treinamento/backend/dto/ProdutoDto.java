package br.com.treinamento.backend.dto;

import br.com.treinamento.backend.models.Produto;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ProdutoDto {

    private Long id;
    private String nome;
    private Long valor;
    private Integer quantidade;

    public Produto toEntity() {
        return Produto.builder()
                    .nome(this.nome)
                    .valor(this.valor)
                    .quantidade(this.quantidade)
                .build();
    }

}
