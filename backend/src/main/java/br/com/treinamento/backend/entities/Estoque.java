package br.com.treinamento.backend.entities;

import br.com.treinamento.backend.dtos.EstoqueDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estoque")
public class Estoque implements Serializable {

    private static final long serialVersionUID = -3157029002605503517L;

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "estoque", fetch = EAGER)
    private List<Produto> produtos;

    public EstoqueDto toDto() {
        return EstoqueDto.builder()
                    .id(this.id)
                    .codigo(this.codigo)
                    .nome(this.nome)
                    .descricao(this.descricao)
                    .produtos(this.produtos.stream().map(produto -> produto.toDto()).collect(Collectors.toList()))
                .build();
    }

}
