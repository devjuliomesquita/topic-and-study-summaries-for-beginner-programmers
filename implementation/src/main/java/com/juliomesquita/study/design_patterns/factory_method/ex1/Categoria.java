package com.juliomesquita.study.design_patterns.factory_method.ex1;

public class Categoria {
    public Produto produtoFactory(){ // Esse é o nosso factory method
        return new ProdutoImpl();
    }
}
