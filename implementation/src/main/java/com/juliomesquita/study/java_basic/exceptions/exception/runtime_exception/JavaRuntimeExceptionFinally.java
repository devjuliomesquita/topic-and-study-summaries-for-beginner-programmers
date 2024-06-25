package com.juliomesquita.study.java_basic.exceptions.exception.runtime_exception;

public class JavaRuntimeExceptionFinally {
    public static void main(String[] args) {
        System.out.println(getConnection1());
        try{
            System.out.println(getConnection2());
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Programa finalizado.");
    }

    public static String getConnection1() {
        boolean isActiveConnection = false;
        try {
            System.out.println("Conexão aberta.");
            isActiveConnection = true;
            System.out.println(isActiveConnection);
            System.out.println("Query 1.");
            System.out.println("Query 2.");
            System.out.println("Query 3.");
            System.out.println("Query 4.");
            return "Serviço finalizado.";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Conexão fechada.");
            isActiveConnection = false;
            System.out.println(isActiveConnection);
        }
        return null;
    }

    public static String getConnection2() {
        try {
            System.out.println("Conexão aberta.");
            System.out.println("Query 1.");
            System.out.println("Query 2.");
            throw new RuntimeException("Query com problemas");
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("Conexão fechada.");
        }
    }
}
