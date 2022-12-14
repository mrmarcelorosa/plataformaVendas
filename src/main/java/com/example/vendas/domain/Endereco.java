package com.example.vendas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Endereco implements Serializable {

    private static final long serialVersionId = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String logradouro;
    @Column
    private String numero;
    @Column
    private String complemento;
    @Column
    private String bairro;
    @Column
    private String cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
}
