package com.juliomesquita.study.java_basic.exceptions.exception.runtime_exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaRuntimeExceptionFinallyTest {

    @Test
    public void testRuntimeExceptionFinally(){
        String connection1 = JavaRuntimeExceptionFinally.getConnection1();
        assertEquals("Serviço finalizado.", connection1);
    }

    @Test
    public void testRuntimeExceptionFinallyWithError(){
        String messageError = assertThrows(RuntimeException.class,
                () -> JavaRuntimeExceptionFinally.getConnection2()).getMessage();
        assertEquals("Query com problemas", messageError);
    }

}