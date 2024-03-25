package com.juliomesquita.study.design_patterns.factory_method.ex1;

public class ProdutoImpl implements Produto{ //Produto Concreto

    private String name;

    public ProdutoImpl(){
        this.name = "Júlio";
    }

    @Override
    public String getName() {
        return name;
    }
}

interface Produto { //Produto Abstrato
    String getName();
}
