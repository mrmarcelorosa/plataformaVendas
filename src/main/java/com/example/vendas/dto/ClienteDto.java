package com.example.vendas.dto;

import com.example.vendas.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto implements Serializable {
    private static final long serialVersionId = 1l;

    private Integer id;
    @NotEmpty(message = "Campo obrigatório!")
    @Size(min = 5, max = 120, message = "O tamanho do campo deve ter entre 5 e 120 caracteres!")
    private String nome;
    @NotEmpty(message = "Campo obrigatório!")
    @Email(message = "E-mail inválido!")
    private String email;

    public ClienteDto(Cliente obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
    }

}
