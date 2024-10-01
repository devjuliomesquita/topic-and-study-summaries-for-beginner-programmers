package com.juliomesquita.study.java_basic.poo.class_structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExEmployeeTest {
    @Test
    void deveImprimirOsDados() {
        ExEmployee e = new ExEmployee();
        ExEmployee e2 = new ExEmployee();

        e.name = "Antônio Apoloneuso";
        e.age = 63;
        e.salaries = new double[]{600D, 700D, 800D, 1000D};
        e.imprimir();
        e.imprimiMediaSalarios();

        System.out.println("----------------------------");
        e2.name = "Chico Rei Delas";
        e2.age = 97;
        e2.salaries = new double[]{1000D};
        e2.imprimir();
        e2.imprimiMediaSalarios();
    }

}