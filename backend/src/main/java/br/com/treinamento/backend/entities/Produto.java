package br.com.treinamento.backend.entities;

import br.com.treinamento.backend.dtos.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = -7403542958522071509L;

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @Column(name = "valor")
    private Long valor;

    @Column(name = "quantidade")
    private Integer quantidade;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_estoque", nullable = false)
    private Estoque estoque;

    public ProdutoDto toDto() {
        return ProdutoDto.builder()
                    .id(this.id)
                    .nome(this.nome)
                    .codigo(this.codigo)
                    .valor(this.valor)
                    .quantidade(this.quantidade)
                .build();
    }
}
