package br.com.treinamento.backend.dtos;

import br.com.treinamento.backend.entities.Produto;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@ToString
public class ProdutoDto implements Serializable {

    private static final long serialVersionUID = 8735714033629188379L;

    private Long id;
    private String nome;
    private String codigo;
    private Long valor;
    private Integer quantidade;

    public Produto toEntity() {
        return Produto.builder()
                    .nome(this.nome)
                    .codigo(this.codigo)
                    .valor(this.valor)
                    .quantidade(this.quantidade)
                .build();
    }

}
