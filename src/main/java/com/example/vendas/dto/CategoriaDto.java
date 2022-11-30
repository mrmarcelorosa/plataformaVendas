package com.example.vendas.dto;

import com.example.vendas.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CategoriaDto implements Serializable {

    private static final long serialVersionId = 1l;

    private Integer id;
    private String nome;

    public CategoriaDto(Categoria c){
        this.id = c.getId();
        this.nome = c.getNome();
    }
}
