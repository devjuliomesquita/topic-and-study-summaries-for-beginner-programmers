package com.juliomesquita.study.design_patterns.null_object.Address;

public class Address {
    private String street;
    private String number;
    private String cep;

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCep() {
        return cep;
    }

    public Address() {
    }

    public Address(String street, String number, String cep) {
        this.street = street;
        this.number = number;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
