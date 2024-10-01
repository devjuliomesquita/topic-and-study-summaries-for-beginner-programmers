package com.juliomesquita.study.java_basic.poo.class_structure;

//Exercício para fixação
public class ExEmployee {
    public String name;
    public int age;
    public double[] salaries;

    public void imprimir() {
        System.out.println(this.name);
        System.out.println(this.age);
        if (salaries != null) {
            for (double salary : this.salaries) {
                System.out.println(salary);
            }
        }
    }

    //  Pergunta comum de quem será a responsabilidade de impressão dessa média?
    //  Neste caso como estamos tratando dos salários desse objeto pode ser feito aqui dentro
    public void imprimiMediaSalarios() {
        double sumSalary = 0D;
        if (salaries == null) {
            System.out.println("Não foi in serido salários ao colaborador.");
            return;
        }
        for (double salary : salaries) {
            sumSalary += salary;
        }
        System.out.printf("Está é a média dos salários:: %s%n", sumSalary / salaries.length);

    }
}
