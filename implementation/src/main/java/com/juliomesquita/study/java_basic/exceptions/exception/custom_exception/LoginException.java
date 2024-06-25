package com.juliomesquita.study.java_basic.exceptions.exception.custom_exception;

public class LoginException extends Exception{
    public LoginException() {
        super("Usuário ou senha inválidos.");
    }

    public LoginException(String message) {
        super(message);
    }
}
