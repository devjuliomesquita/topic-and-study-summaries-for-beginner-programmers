package com.juliomesquita.study.design_patterns.factory_method.ex1;

import static java.lang.System.out;

public class TestFactoryEx1 {
    public static void main(String[] args) {
        Categoria c = new Categoria();
        Produto produto = c.produtoFactory();
        String name = produto.getName();
        out.println(name);
    }
}
