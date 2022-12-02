package com.example.vendas.dto;

import com.example.vendas.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CategoriaDto implements Serializable {

    private static final long serialVersionId = 1l;

    private Integer id;
    @NotEmpty(message = "Campo obrigatório!")
    @Size(min = 5, max = 50, message = "O tamanho do campo deve ter entre 5 e 50 caracteres!")
    private String nome;

    public CategoriaDto(Categoria c){
        this.id = c.getId();
        this.nome = c.getNome();
    }
}
