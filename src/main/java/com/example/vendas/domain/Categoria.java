package com.example.vendas.domain;

import lombok.*;

import java.io.Serializable;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class Categoria implements Serializable {

    private static final long serialVersionId = 1l;

    private Integer id;
    private String nome;
}
