package com.juliomesquita.study.java_basic.generics;

/*
* 1 Conseguir buscar a instância correta do repositório
* 2 Conseguir converter numa saída mesmo sem conhecer
* */
public abstract class CRUDGeneric {
    public <T> void create(T item){
        System.out.println("CRUD Generic:: método create");
    }

    public <T> void update(T item){
        System.out.println("CRUD Generic:: método update");
    }

    public <T> void delete(T item){
        System.out.println("CRUD Generic:: método delete");
    }
}
