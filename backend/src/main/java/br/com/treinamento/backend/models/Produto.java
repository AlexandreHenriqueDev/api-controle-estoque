package br.com.treinamento.backend.models;

import br.com.treinamento.backend.dto.ProdutoDto;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@Builder
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 3185874813011229371L;

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(name = "nome", unique = true, nullable = false)
    private String nome;

    @Column(name = "valor")
    private Long valor;

    @Column(name = "quantidade")
    private Integer quantidade;

    public ProdutoDto toDto() {
        return ProdutoDto.builder()
                    .id(this.id)
                    .nome(this.nome)
                    .valor(this.valor)
                    .quantidade(this.quantidade)
                .build();
    }
}
