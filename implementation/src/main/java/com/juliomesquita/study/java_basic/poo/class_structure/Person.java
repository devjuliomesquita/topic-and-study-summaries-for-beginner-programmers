package com.juliomesquita.study.java_basic.poo.class_structure;

/*
* Essa é a estrutura padrão para a criação de uma classe em Java.
*  - public => é um modificador de acesso que veremos mais a frente;
*  - class => é o tipo de objeto que você está criando;
*  - Person => é o nome do objeto;
*
* Uma classe pode ser dividida em duas coisas como características e ações
*  - Atributos são considerados as características de uma classe;
*  - Métodos são considerados as ações que essa classe pode realizar;
*
* Uma classe pode ser iniciada atraves da palavra reservada 'new'
*  - Ex.: Person person = new Person(); Carro carro = new Carro();
*  - A sintaxe do java é nesse formato onde é necessário informar:
*  - > Tipo de objeto
*  - > Nome da variável
*  - > new
*  - > Tipo de objeto com o parenteses '()' que simboliza uma função
*  - > ; para finalizar o comando
* */
public class Person {

    /*
    * Atributos assim como na classe seguem essa estrutura.
    *  - O tipo de acesso,
    *  - O tipo de dado,
    *  - O nome do atributo,
    *  - ; para finalizar o comando
    * */
    public String name;
    public int age;
    public char sex;
    public boolean isAlive;

    /*
    * Métodos também seguem uma determinada estrutura.
    *  - O tipo de acesso
    *  - O tipo de retorno
    *  - O nome do método
    *  - () para indicar que é uma função
    *  - {} para indicar onde ficará o corpo do método
    * */

    /*
    * Quanto aos seus retornos eles podem retornar ou não alguma coisa.
    * Porém lembre-se que os métodos realizam uma ação.
    *
    * Podem receber parâmetros e eles são indicados dentro do parenteses '()' com o seu tipo e nome separados por vírgula.
    *
    * Podem receber como parâmetros objetos do tipo referência.
    * Obs.: Quando se é passado um tipo primitivo para o método, não é passado a variável em se mas apenas uma imagem da mesma.
    *       Porém quando é enviado um objeto de referência é enviado o objeto de fato.
    *
    * Vargs... é uma feature criada pós array para manipulação dos mesmos
    * */
    public void printar(){
        System.out.println("Este método somente executa uma ação.");
    }

    public String retorna(){
        return "Este método retorna uma String.";
    }

    public String contemParametros(String palavra, int numero){
        System.out.println(numero);
        return palavra;
    }

    public void referencePerson(Person person){
        person.name = "Campeão";
    }

    public void referencePersonWithThis(){
        this.name = "Campeão";
    }

    public int somarIdades(int[] ages){
        int ageSum = 0;
        for(int age : ages){
            ageSum += age;
        }
        return ageSum;
    }

    //Ele converte ages para um array automático
    public int somarIdadesWithVargs(int... ages){
        int ageSum = 0;
        for(int age : ages){
            ageSum += age;
        }
        return ageSum;
    }
}


