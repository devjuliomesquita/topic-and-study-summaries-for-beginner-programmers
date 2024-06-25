package com.juliomesquita.study.java_basic.exceptions.exception.runtime_exception;

public class JavaRuntimeExceptionMultiCatch {
    public static void main(String[] args) {

        throwRunTimeException1();
        throwRunTimeException2();
        System.out.println("Programa finalizado.");
    }

//    Utilizado para quando eu quero realizar um tratamento para cada tipo de exception
    public static void throwRunTimeException1() {
        try {
            throw new IllegalArgumentException("Argumento Ilegal.");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

//    Utilizado para quando posso aglomerar as expections. Nos dois casos a exception mais genérica deve vir no final.
    public static void throwRunTimeException2() {
        try {
            throw new ArithmeticException("Erro aritimético.");
        } catch (IllegalArgumentException | ArithmeticException e) {
            e.printStackTrace();
        }catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
