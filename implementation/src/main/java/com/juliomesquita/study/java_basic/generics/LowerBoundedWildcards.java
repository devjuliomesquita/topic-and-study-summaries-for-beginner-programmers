package com.juliomesquita.study.java_basic.generics;

import java.util.List;

public class LowerBoundedWildcards {
    /*
    * Quando queremos inserir algum item em uma lista genérica devemos utilizar "? super T"
    * Nessa opçao podemos realizar tantos inserts quanto leitura
    * */
    public static <T> void addItem(List<? super T> items, T item){

        items.add(item);

    }
}
