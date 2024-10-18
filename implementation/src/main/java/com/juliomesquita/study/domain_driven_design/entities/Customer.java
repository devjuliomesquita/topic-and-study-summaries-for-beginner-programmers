package com.juliomesquita.study.domain_driven_design.entities;

import java.util.Objects;
import java.util.UUID;

/*
 * Esse é uma  exemplo de entidade não anémica
 * 1. As ações que essa classe tem significam algo a mais do que somente guardar dados.
 * 2. Tem alguma coisa relacionado a regras de negócio. Exprecividade
 * 3. As entidades devem seguir uma determinada metodologia:
 * 3.1 Temos que garantir consistência
 * */
public class Customer {
    private String id;
    private String name;
    private boolean active;

    /*
     * Este método pode conter algumas regras como name != null ou name.length > 3
     * Esta abordagem pode retornar uam domain exception
     */
    public void changeName(final String name) {
        this.name = name;
    }

    public void active() {
        this.active = true;
    }

    public void deactive() {
        this.active = false;
    }

    /*
     * Exemplo de como garantir consistência
     * Com o construtor privado eu posso  garantir que todos os Customers criados serão populados
     * e terão uma padrão para a criação passando obrigatóriamente um name e um status de ativo ou inativo
     * */
//    private Customer(String id, String name, boolean active) {
//        this.id = id;
//        this.name = name;
//        this.active = active;
//    }
//
//    public Customer newCustomer(final String name, final boolean active) {
//        if (name == null || name.length() <= 3) {
//            throw new IllegalArgumentException("'name' is invalid.");
//        }
//        final String id = UUID.randomUUID().toString();
//        return new Customer(id, name, active);
//    }
    /*
    * 1. Outro exemplo, uma abordagem seria: deixar o construtor público e criar méetodos helpers para o auxilo da criação da classe
    * */

    public Customer(String id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.validate();
    }

    private void validate(){
        if(this.name == null){
            throw new IllegalArgumentException("'name' can not be null.");
        }
        if(this.name.length() > 3 && this.name.length() < 255){
            throw new IllegalArgumentException("'name' must be between 3 and 255 characters.");
        }
    }
}
