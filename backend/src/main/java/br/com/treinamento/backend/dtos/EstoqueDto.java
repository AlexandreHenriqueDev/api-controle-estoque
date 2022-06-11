package br.com.treinamento.backend.dtos;

import br.com.treinamento.backend.entities.Estoque;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class EstoqueDto implements Serializable {

    private final static long serialVersionUID = -748819023628080425L;

    @Null
    private Long id;
    @NonNull
    private String codigo;
    @NonNull
    private String nome;
    @Null
    private String descricao;

    @Null
    private List<ProdutoDto> produtos;

    public Estoque toEntity() {
        return Estoque.builder()
                    .codigo(this.codigo)
                    .nome(this.nome)
                    .descricao(this.descricao)
                    .produtos(new ArrayList<>())
                .build();
    }

}
