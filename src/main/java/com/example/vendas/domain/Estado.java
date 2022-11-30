package com.example.vendas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Estado implements Serializable {
    private static final long serialVersionId = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();
    public Estado(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
