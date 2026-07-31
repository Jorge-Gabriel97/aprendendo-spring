package com.jorge.aprendendo_spring.infrastructure.exceptions;

public class ConflictExecptions extends RuntimeException {

    public ConflictExecptions(String mensagem){
        super(mensagem);
    }
    public ConflictExecptions(String mensagem, Throwable throwable){
        super(mensagem);
    }
}
