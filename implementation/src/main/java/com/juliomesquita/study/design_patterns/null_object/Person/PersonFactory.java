package com.juliomesquita.study.design_patterns.null_object.Person;

import com.juliomesquita.study.design_patterns.null_object.Address.Address;
import com.juliomesquita.study.design_patterns.null_object.Address.NullAddress;

public class PersonFactory {
    private PersonFactory() {}
    public static Person createPerson(
            String name,
            String phoneNumber,
            String email,
            Address address
    ) {
        Person p = new Person(name, phoneNumber, email);
        p.setAddress( // Regrade negócio que define quando utilizar o Null-Object
                address != null
                ? address
                : new NullAddress()
        );
        return p;
    }
}
