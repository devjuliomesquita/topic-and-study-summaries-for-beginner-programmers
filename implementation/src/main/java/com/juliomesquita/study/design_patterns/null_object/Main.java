package com.juliomesquita.study.design_patterns.null_object;

import com.juliomesquita.study.design_patterns.null_object.Address.Address;
import com.juliomesquita.study.design_patterns.null_object.Person.Person;
import com.juliomesquita.study.design_patterns.null_object.Person.PersonFactory;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args){
        Person person1 = PersonFactory.createPerson(
                "Irineu",
                "85987654321",
                "Irineu@gmail.com",
                new Address(
                        "Rua dos bobos",
                        "0",
                        "62000000"
                )
        );
        out.println(person1);
//        R. Person{name='Irineu', phoneNumber='85987654321', email='Irineu@gmail.com', address=Address{street='Rua dos bobos', number='0', cep='62000000'}}

        Person person2 = PersonFactory.createPerson(
                "Irineu",
                "85987654321",
                "Irineu@gmail.com",
                null
        );
        out.println(person2);
//        R. Person{name='Irineu', phoneNumber='85987654321', email='Irineu@gmail.com', address=Endereço não encontrado ou cadastrado.}

        out.println(person2.getAddress().getStreet()); // Rua não encontrada.
        out.println(person2.getAddress().getNumber()); // Número não encontrado
        out.println(person2.getAddress().getCep()); // CEP não encontrado

    }
}
