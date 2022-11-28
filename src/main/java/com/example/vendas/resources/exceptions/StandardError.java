package com.example.vendas.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class StandardError implements Serializable {

    private static final long serialVersionId = 1l;

    private Integer status;
    private String msg;
    private Long timeStamp;
}
