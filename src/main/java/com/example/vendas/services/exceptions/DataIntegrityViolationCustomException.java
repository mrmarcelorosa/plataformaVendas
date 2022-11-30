package com.example.vendas.services.exceptions;

public class DataIntegrityViolationCustomException extends RuntimeException{

    private static final long serialVersionId = 1l;

    public DataIntegrityViolationCustomException(String msg){
        super(msg);
    }

    public DataIntegrityViolationCustomException(String msg, Throwable cause){
        super(msg,cause);
    }
}
