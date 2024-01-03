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

A biblioteca Java.lang contém caixas de seus tipos primitivos tornando-se uma referência:
| Tipo Primitivo | Referência |
| -------- | -------- |
| byte | Byte |
| short | Short |
| int | Integer |
| long | Long |
| float | Float |
| double | Double |
| boolean | Boolean |
| char | Character |

Conversão de um tipo primitivo para referência é o chamado boxing. O contrário é unboxing.

Agora vamos ver como isso acontece no código:

```java
List<Integer> ints = new ArrayList<Integer>();
ints.add(1);
int n = ints.get(0);
//result: n = 1.
```

> [!NOTE]
>
> Aqui, o número inteiro 1 é adicionado diretamente à lista ints. Ao recuperar o valor, não é necessário chamar nenhum método adicional para convertê-lo de volta para um inteiro, já que foi adicionado como um objeto Integer diretamente na lista.

```java
List<Integer> ints = new ArrayList<Integer>();
ints.add(Integer.valueOf(1));
int n = ints.get(0).intValue();
//result: n = 1.
```

> [!NOTE]
>
> green Neste caso, o número 1 é explicitamente encapsulado como um objeto Integer usando Integer.valueOf() antes de ser adicionado à lista. Ao recuperar o valor da lista, é necessário chamar .intValue() para converter o objeto Integer de volta para um tipo primitivo int.

Generics em Java insere automaticamente o boxing e unboxing quando apropriado. Se uma expressão e do tipo int aparecer onde um valor do tipo Integer é esperado, boxing o converte em **new Integer(e)** (no entanto, ele pode armazenar em cache valores que ocorrem com frequência
ues). Se uma expressão e do tipo Integer aparecer onde um valor do tipo int é esperado, unboxing converte-o para a expressão **e.intValue()**.

A chamada Integer.valueOf(1) tem efeito semelhante à expressão new Integer(1), **mas pode armazenar em cache alguns valores para melhorar o desempenho**.

Vamos ver o código lá do primeiro exemplo para um melhor entendimento.

```java
//Exemplo 1
public static int sum (List<Integer> ints){
  int s = 0;
  for(int n : ints) {
    s +=n;
  }
  return s;
}

//Exemplo 2
public static Integer sumInteger (List<Integer> ints){
  Integer s = 0;
  for(Integer n : ints) {
    s +=n;
  }
  return s;
}
```

> [!WARNING]
>
> Veja que os dois códigos novamente realizam a mesma coisa porém no exemplo 2 o compilador executa um trabalho totalmente desnecessário. Veja, a cada iteração do loop descompacta os valores de s e n realizar a adição e compacta novamente. Neste caso a existe uma perda considerável de performace em até 60%.

Assim nos resta algumas perguntas:

- Por que o argumento tem o tipo List<Integer> e não List<int>?
  - R.: Os tipos de paramentros são limitados ao tipo de referência.
- Por que no exemplo 1 o resultado em um int e não um Integer? Afinal a lista é de Integer...
  - R.: Naverdade os resultados podem vir das duas formas dependendo do que você espera de retorno. porém o tipo primitivo é mais performático. Veja o warning acima.

---
