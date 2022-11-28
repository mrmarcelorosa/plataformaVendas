package com.example.vendas.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Getter
public enum TipoCliente {
    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    public static TipoCliente toEnum(Integer cod){
        if(cod==null)
            return null;
        for (TipoCliente x : TipoCliente.values()){
            if(cod.equals(x.getCod()))
                return x;
        }
        throw new IllegalArgumentException("Id inválido " + cod);
    }

    private int cod;
    private String descricao;
}
