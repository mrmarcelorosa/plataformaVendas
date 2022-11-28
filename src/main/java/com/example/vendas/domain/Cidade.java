package com.example.vendas.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Cidade implements Serializable {
    private static final long serialVersionId = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
}
