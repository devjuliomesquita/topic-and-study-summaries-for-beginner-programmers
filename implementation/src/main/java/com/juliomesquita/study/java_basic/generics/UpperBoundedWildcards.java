package com.juliomesquita.study.java_basic.generics;

import java.util.List;

public class UpperBoundedWildcards<T> {
    private T item;
    /*
    * A expressão "? extends T" é utilizada apenas para leitura, então é muito semelhante a uma classe final
    * */
    public static <T> T showElements(List<? extends T> items){
        for(T item: items){
            System.out.println(item.toString());
        }
        return items.get(0);
    }
}
