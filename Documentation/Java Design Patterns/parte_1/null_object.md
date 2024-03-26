### _"Entidades de software devem ser abertas para a extensão, mas fechadas a modificação."_

A herança é uma das principais funcionalidades da orientação a objetos. É a partir dela que é possível grande parte do potencial de reuso.
Porém, muitas pessoas realizam isso de forma errada.

Temos um potêncial de reúso do código da superclasse, porém, 
veja este fluxo, 
não com a **subClasse** chamando todos os métodos da **superClasse,** mas sim a **superClasse** chamando alguns métodos da **subClasse**. 
Quando um método da superClasse chama um método da subClasse permite a reutilização com passos alterados.
Essa flexibilidade aumenta o potêncial de reutilização.

### Nosso objetivo
Mostrar como a Herança pode ser utilizada no design orientado a objetos para permitir adaptação de comportamentos e por consequência um maior reúso.

### Pattern - Null Object
_"O que é invisível para nós também é crucial para o nosso bem-estar."_

Apesar desse padrão não estar incluso no livro do GOF, ele ilustra como usar a herança com o objeto de enganar a classe que o utiliza, pois
introduzimos um novo comportamento que irá eliminar a necessidade do uso de condicionais. 
Para o código "cliente" o comportamento se torna invisível.

```java
public interface Endereco { // Abstração
    String getEndereco();
}
```

```java
public class EnderecoImpl implements Endereco { // Concreto
    private String rua;
    private String numero;
    
    public EnderecoImpl(String rua, String numero) {
        this.rua = rua;
        this.numero = numero;
    }
    
    @Override
    public String getEndereco(){
        System.out.printf("Endereço do cliente: Rua: %s, número: %s.%n", rua, numero);
    }
}
```
Aqui temos a nossa implementação da nossa abstração Endereço.

```java
public class NullEndereco implements Endereco { // Null Method
    @Override
    public String getEndereco(){
        System.out.printf("Cliente não contém endereço.%n");
    }
}
```
Essa é nossa implementação do Null Object e perceba como utilizamos uma herança diferenciada.

```java
public class EnderecoFactory { // Factory method que iremos aprender mais a frente
    public static Endereco createEndereco(String rua, String numero) {
        if (rua != null || numero != null) {
            return new EnderecoImpl(rua, numero);
        } else {
            return new NullEndereco();
        }
    }
}
```
Alguns partterns precisam de outros para que a sua implementação fique mais simples, por isso utilizamos o Factory Method.
Perceba que é por meio dele que decidimos qual recurso e qual objeto utilizar isso certamente conforme a nossa regra de negócio.

```java
public class Main{
    public static void main(String[] args){
        Endereco e = EnderecoFactory.createEndereco("São Vicente de Paula", "118");
        System.out.println(e.getEndereco()); // Endereço do cliente: Rua: São Vicente de Paula, número: 118.
        
        Endereco e2 = EnderecoFactory.createEndereco(null, null);
        System.out.println(e2.getEndereco()); // Cliente não contém endereço.
    }
}
```

### Vantagens e Desvantagens
 - Vantagens:
   - **Previne exceções nulas:** O famoso _NullPointerException_, pois sempre retorna um objeto que pode ser usado de forma segura, 
   mesmo quando a lógica do programa tenta acessar um objeto que normalmente seria nula.
   - **Simplifica a lógica no CLiente:** Clientes que utilizam objetos Null-Object não precisam realizar verificações de nulidade, 
   simplificando mais o código. Isso nos dá maior legibilidade.
   - **Facilita Testes e Depuração:** Como o Null-Objeto tem um comportamento definido, torna-o muito previsível, assim, 
   é mais simples de depurar e testar.
   - **Manutenabilidade:** Como este pattern reduz-se a complexibilidade e o acomplamento do código.
   
### Parece ótimo, mas não é uma bala de prata, esse pattern tem desvantagens também.

 - Desvantagens:
   - **Complexidade adicional na Implementação:** Isso acontece quando temos muitos objetos nulos a serem considerados.
   - **Aumento do consumo de memória:** Possibilidade de haver muito Null-Objects criados e mantidos em meméria durante a execução do programa.
   - **Abuso do padrão:** Como qualquer outro pattern há um risco de abuso no uso. Portanto, veja por todos os angulos a real necessiadade do uso. 