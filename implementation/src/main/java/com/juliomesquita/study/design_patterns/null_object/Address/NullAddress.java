package com.juliomesquita.study.design_patterns.null_object.Address;

public class NullAddress extends Address {
    @Override
    public String getStreet() {
        return "Rua não encontrada.";
    }
    @Override
    public String getNumber() {
        return "Número não encontrado";
    }
    @Override
    public String getCep() {
        return "CEP não encontrado";
    }
    @Override
    public String toString() {
        return "Endereço não encontrado ou cadastrado.";
    }
}
