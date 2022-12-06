package com.example.vendas.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class FieldMessage implements Serializable {

    private static final long serialVersionId = 1l;

    private String fieldName;
    private String message;
}
