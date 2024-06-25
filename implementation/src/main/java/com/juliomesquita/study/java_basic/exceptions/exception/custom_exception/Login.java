package com.juliomesquita.study.java_basic.exceptions.exception.custom_exception;

public class Login {
    public static void main(String[] args) {

        try{
            loginError();
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            loginError1();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Programa finalizado.");
    }
    public static void loginError() throws Exception{
        System.out.println("Exceptio sem frase custom");
        throw new LoginException();
    }

    public static void loginError1() throws Exception{
        System.out.println("Exception com frase custom");
        throw new LoginException("Senha errada otário.");
    }
}
