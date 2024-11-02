package com.juliomesquita.study.java_basic.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UpperBoundedWildcardsTest {
    @Test
    void deveMostrarTodosOsElementos() {
//        List<String> names = Arrays.asList("Júlio", "Amanda", "Mesquita", "Para sempre");
        List<Integer> names = Arrays.asList(1, 2, 3, 4, 5, 6);
        Number s = UpperBoundedWildcards.showElements(names);
        System.out.println(s);
    }

    @Test
    void deveCopiarElementos() {
        List<Number> nums = Arrays.asList(1, 2.2, 3.5f, 4, 6);
//        List<? super Number> list = copy(nums);
//        showElements(list);
    }

    static <T> void showElements(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }

    static <T> void copy(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

}