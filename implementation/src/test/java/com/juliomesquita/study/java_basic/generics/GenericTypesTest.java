package com.juliomesquita.study.java_basic.generics;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GenericTypesTest {
    @Test
    void deveCriarSetarBuscar(){
        GenericTypes<Map<String, String>> g = new GenericTypes<>();
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("Chave 1", "Jülio mesquita");
//        g.setItem(objectObjectHashMap);
//        System.out.println(g.getItem().get("Chave 1"));

    }

}