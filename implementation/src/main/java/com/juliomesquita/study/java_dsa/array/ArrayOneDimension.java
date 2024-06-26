package com.juliomesquita.study.java_dsa.array;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayOneDimension {

//        Meios de criação | Os 3 tipos são válidos
//        int[] tipo1 = new int[3];
//        int tipo2[] = new int[3];
//        int[] tipo3 = {1,2,3};

    private String[] list;
    private int limit;
    private int listSize;

    public ArrayOneDimension(int listSize) {
        this.limit = 0;
        this.list = new String[listSize];
        this.listSize = listSize;
    }


    public boolean addItemWithFor(String s) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = s;
                return true;
            }
        }
        return false;
    }

    public boolean addItemWithStream(String s) {
        OptionalInt index = IntStream.range(0, this.list.length)
                .filter(i -> list[i] == null)
                .findFirst();
        if (index.isPresent()) {
            list[index.getAsInt()] = s;
            return true;
        }
        return false;
    }

    public boolean addItemWithLimit(String s) {
        if (limit < list.length) {
            list[limit] = s;
            limit++;
            return true;
        }
        return false;
    }

    public String toArrayString() {
        StringBuilder response = new StringBuilder();
        response.append("[");
        for (int i = 0; i < limit-1; i++) {
            response.append(this.list[i]);
            response.append(", ");
        }
        response.append(this.list[limit-1]);
        response.append("]");
        return response.toString();
    }

    @Override
    public String toString() {
        return "ArrayOneDimension{" +
                "list=" + Arrays.toString(list) +
                ", limit=" + limit +
                '}';
    }
}
