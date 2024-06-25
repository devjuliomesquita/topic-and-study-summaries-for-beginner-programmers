package com.juliomesquita.study.java_basic.exceptions.exception.runtime_exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaRuntimeExceptionTest {

    @Test
    public void testRuntimeException(){

    }

    @Test
    public void testRuntimeExceptionNullPointer(){
        Object o = null;
        Assertions.assertThrows(NullPointerException.class, () -> System.out.println(o.toString()));
    }

    @Test
    public void testRuntimeExceptionIndexOutOfBound(){
        String[] s = {"a","b","c"};
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> System.out.println(s[3].toString()));
    }

    @Test
    public void testRuntimeExceptionTreatmentWithTryCatch(){
        String messageError = assertThrows(ArithmeticException.class,
                () -> JavaRuntimeException.div(1, 0)).getMessage();
        assertEquals("/ by zero",messageError);
    }

    @Test
    public void testRuntimeExceptionTreatmentWithThrow(){
        String messageError = assertThrows(IllegalArgumentException.class,
                () -> JavaRuntimeException.div2(1, 0)).getMessage();
        assertEquals("Valor enviado inválido. b deve ser diferente de 0.",messageError);
    }
}