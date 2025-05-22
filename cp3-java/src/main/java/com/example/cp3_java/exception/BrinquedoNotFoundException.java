package com.example.cp3_java.exception;

public class BrinquedoNotFoundException extends Exception{
    public BrinquedoNotFoundException(Long id) {
        super("Brinquedo não encontrado com ID: " + id);
    }
}
