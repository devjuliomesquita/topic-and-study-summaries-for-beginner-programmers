# Generics

Para iniciar os estudos veja este cód logo abaixo:

```java
List ints = Arrays.asList( new Integer[] {
  new Integer(1), new Integer(2), new Integer(3)
});
int s = o;
for(Iterator it = ints.iterator(); it.hasNext(); ){
  int n = ((Integer)it.next()).intValue();
  s += n;
}
assert s == 6;
```

Agora veja este código:

```java
List<Integer> ints = Arrays.asList(1,2,3);
int s = 0;
for(int n : ints) {
  s += n;
}
assert s == 6;
```

O que nós podemos perceber de diferença entre os dois códigos?

Inicialmente a leitura o segundo bloco de código é bem mais simples e rápido de ler. Logo em seguida percebemos que a velocidade de código também melhora bastante.
**Caso não tenha percebido os dois códigos fazem a mesma coisa...**

Esse é o poder do Generics, perceba que agora é o codificador e não o compilador que é responsável por lembrar o tipo de elementos da lista. Assim existe a a garantia de não falhar na compilação.

_Garantia de ferro fundido_: as conversões implícitas adicionadas pela compilação de genéricos nunca falhar.

## Boxing and Unboxing

Este conceito é muito importante para o estudo de generics. Imagine assim, como a própria palavra já fala, pegue um caixa e coloque vários objetos do mesmo tipo dentro de uma caixa e feche. Caso depois você venha a abrir está mesma caixa terá os mesmos objetos que foram colocados anteriormente. Isto é basicamente o conceito de boxing e Unboxing respectivamente.

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

Generics em Java insere automaticamente o boxing e unboxing quando apropriado. \_Se uma expressão e do tipo int aparecer onde um valor do tipo Integer é esperado, boxing o converte em **new Integer(e)** (no entanto, ele pode armazenar em cache valores que ocorrem com frequência
ues). Se uma expressão e do tipo Integer aparecer onde um valor do tipo int é esperado, unboxing converte-o para a expressão **e.intValue()**.

A chamada Integer.valueOf(1) tem efeito semelhante à expressão new Integer(1), **mas pode armazenar em cache alguns valores para melhorar o desempenho**.
