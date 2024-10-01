package com.juliomesquita.study.java_basic.poo.class_structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void deveCriarUmPerson(){
        //Criando um instância do objeto Person
        Person person = new Person();

        //Printando na tela os atributos de person
        //Como não foi atribuido nenhum valor a person foi mostrado os valores default
        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.isAlive);
        System.out.println(person.sex);
        System.out.println("--------------------------"); //Somente para separar os objetos


        //Atribuindo valores aos atributos da classe
        person.name = "Júlio César M. Camilo Martins";
        person.age = 20;
        person.isAlive = true;
        person.sex = 'M';

        //Printando na tela os atributos de person pós atribuição
        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.isAlive);
        System.out.println(person.sex);
    }

    @Test
    void deveCriarPersonsDeReferencia(){
//        Criar a instância do objeto
        Person p1 = new Person();
        Person p2;

        p2 = p1;

        p1.name = "Júlio César M. Camilo Martins";
        p1.age = 20;
        p1.isAlive = true;
        p1.sex = 'M';

        //Printando na tela os atributos de person
        System.out.println(p1.name);
        System.out.println(p1.age);
        System.out.println(p1.isAlive);
        System.out.println(p1.sex);
        System.out.println("--------------------------");
        System.out.println(p2.name);
        System.out.println(p2.age);
        System.out.println(p2.isAlive);
        System.out.println(p2.sex);
        System.out.println("--------------------------");

        p1.referencePersonWithThis();

        //Printando na tela os atributos de person
        System.out.println(p1.name);
        System.out.println(p1.age);
        System.out.println(p1.isAlive);
        System.out.println(p1.sex);
        System.out.println("--------------------------");
        System.out.println(p2.name);
        System.out.println(p2.age);
        System.out.println(p2.isAlive);
        System.out.println(p2.sex);
        System.out.println("--------------------------");
    }

    @Test
    void deveSomarAsIdades(){
        Person person = new Person();
        int[] ages = new int[]{1,2,3,4,5};
        int age1 = person.somarIdades(ages);
        System.out.println(age1);
        int age2 = person.somarIdadesWithVargs(1,2,3,4,5);
        System.out.println(age2);
    }
}