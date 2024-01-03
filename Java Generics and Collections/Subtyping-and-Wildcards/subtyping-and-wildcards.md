# Subtyping-and-Wildcards

**O que é uma subtipagem?**

É uma ferramenta da liguagem Java onde é visto que todo tipo de referência é um subtipo de um Object e um Object é um supertipo de uma referência. Podemos falar de formar leiga que um subtipo faz parte de alguma coisa maior. Veja o exemplo abaixo:

| Subtipo    | ==>          | Tipo       |
| ---------- | ------------ | ---------- |
| ArrayList  | é subtipo de | List       |
| List       | é subtipo de | Collection |
| Collection | é subtipo de | Iterable   |

Temos um outro conceito chamado de **Substituição principal**:
_uma variável de um determinado tipo pode receber um valor de qualquer subtipo
desse tipo, e um método com um parâmetro de um determinado tipo pode ser invocado com um
argumento de qualquer subtipo desse tipo._

Vejao explo abaixo:

```java
List<Number> nums = new ArrayList<Number>();
nums.add(1);
nums.add(2.654);
assert nums.toString().equals("[1, 2.654]");
```

No código acima temos a subtipagem trabalhando de duas maneiras, veja como ela é chamada na primeira vez. O método é permitido pois nums de tipo List de Number é um subtipo de Collection de um Number e o número 1 é do tipo Integer que tem o subtipo Number. Na segunda chamada acontece o mesmo.

## Wildcards with extends

Wildcards ou caracter coringa no Java nós temos como o sinal de '?'. Basicamente o '?' significa qualquer coisa, porém ao ser empregado pode ser direcionado para um significado coeso para o código. Por exemplo: **' ? extends E '**. Significa que '?' pode ser qualquer coisa, desde que seja um subtipo de E. Vamos ao código:

```java
List<Number> nums = new ArrayList<Number>();
List<Integer> ints = Arrays.asList(1, 3);
List<Double> dbls = Arrays.asList(1.1, 1.2);
nums.addAll(ints);
nums.addAll(dbls);
assert nums.toString().equals("[1, 3, 1.1, 1.2]");
```

O código acima está correto porque `List<Number>`, `List<Double>`, `List<Integer>` são subtipo da `Collection<? exdends Number>` como todas elas fazem parte da mesma referência não há problemas. Agora veja o cógigo abaixo:

```java
List<Integer> ints = new ArrayList<Integer>();
nums.add(1);
nums.add(2);
List<? extends Number> nums = ints;
nums.add(1.1); // erro de compilação
```

Precisamos entender melhor qual a diferença entre os códigos. Por que houve um erro de compilação?

O erro aqui faz referência a uma tentativa de adicionar um valor a lista de nums. Quando você declara uma lista usando _`List<? extends E>`_, está indicando que a lista é de qualquer tipo desconhecido que extende de _'E'_. Então não é possível adicionar uma valor a essa lista pois não se sabe o seu subtipo exato.

## Wildcards with Super

Nesta sessão vamos tratar o problema mencionado anteriormente. Vimos que _`List<? extends E>`_ significa que _'?'_ pode significar qualquer um subtipo de _'E'_ mas se o parametro do método mudar para _`List<? super E>`_ o contexto muda, agora significa que _'?'_ pode ser de qualquer superclasse de _'E'_. No anterior que poderiamos apenas acessar os elementos do subtipo de _'E'_ agora podemos adicionar elementos do subtipo de _'E'_.

Veja o código abaixo:

```java
// Lista com curinga "extends"
public static void addElements(List<? extends Number> list) {
  // Não é possível adicionar elementos apenas ler
  for (Number num : list) {
      System.out.println(num);
  }
}

// Lista com curinga "super"
public static void addToList(List<? super Integer> list) {
  // É possível adicionar elementos
  list.add(5);
  list.add(10);
  // Não é possível ler elementos diretamente dessa lista
  // No entanto, podemos ler os elementos através de um Object
  for (Object obj : list) {
      System.out.println(obj);
  }
}

public static void main(String[] args) {
  List<Integer> integerList = new ArrayList<>();
  integerList.add(1);
  integerList.add(2);

  List<Double> doubleList = new ArrayList<>();
  doubleList.add(1.5);
  doubleList.add(2.5);

  //List<? extends T>
  addElements(integerList);
  addElements(doubleList);

  //List<? super T>
  List<Number> numberList = new ArrayList<>();
  addToList(integerList);
  addToList(numberList);
}
```
