package com.juliomesquita.study.java_basic.exceptions.exception.runtime_exception;

import java.io.*;

public class JavaRuntimeExpectionTryWithResources {
    public static void main(String[] args) {
        lerArquivo();
        lerArquivo2();

        try {
            lerArquivo3();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Programa finalizado");
    }

    //    Primeiro exemplo - Código lixo... faz qualquer dev desistir de Java
    public static void lerArquivo() {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("test.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //    Esta abordagem só pode ser utilizada para classe que tenham implementado "Closeable"
    public static void lerArquivo2() {
        try (Reader reader = new BufferedReader(new FileReader("test.txt"))) {
            // colocar novas funções
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  Nesta abordagem você joga a reaponsabilidade do tratamento para a classe superior
    public static void lerArquivo3() throws IOException {
        try (Reader reader = new BufferedReader(new FileReader("test.txt"))) {
            // colocar novas funções
        }
    }
}
