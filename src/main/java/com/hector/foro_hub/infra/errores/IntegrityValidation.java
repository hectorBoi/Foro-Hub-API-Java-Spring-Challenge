package com.hector.foro_hub.infra.errores;

public class IntegrityValidation extends RuntimeException{
    public IntegrityValidation(String s) {
        super(s);
    }
}
