package com.example.vendas.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    public static EstadoPagamento toEnum(Integer cod){
        if(cod==null)
            return null;
        for (EstadoPagamento x : EstadoPagamento.values()){
            if(cod.equals(x.getCod()))
                return x;
        }
        throw new IllegalArgumentException("Id inválido " + cod);
    }

    private int cod;
    private String descricao;
}
