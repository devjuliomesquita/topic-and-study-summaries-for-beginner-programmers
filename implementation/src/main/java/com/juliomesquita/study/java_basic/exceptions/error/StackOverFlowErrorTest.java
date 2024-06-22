package com.juliomesquita.study.java_basic.exceptions.error;

public class StackOverFlowErrorTest {
    public static void main(String[] args) {
        recursivo();
    }

    public static void recursivo(){
        recursivo();
    }
}
