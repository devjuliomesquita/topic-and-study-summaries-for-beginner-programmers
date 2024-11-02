package com.juliomesquita.study.java_basic.generics;

public class BoundedTypeParameters {
    public <T extends Comparable<T>> int countGreaterItems(T[] items, T item) {
        int count = 0;

        for (T i : items) {
            if (i.compareTo(item) > 0) {
                count++;
            }
        }
        return count;
    }
}
