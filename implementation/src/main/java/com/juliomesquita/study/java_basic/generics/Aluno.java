package com.juliomesquita.study.java_basic.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Aluno {
    private String name;
    private Integer age;

    public List<? extends Number> testMethod() {
        List<? extends Number> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
//        List<? extends Number> list1 = new ArrayList<>();
//        list1.add(1);
        return list1;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Aluno aluno = (Aluno) object;
        return Objects.equals(name, aluno.name) && Objects.equals(age, aluno.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
