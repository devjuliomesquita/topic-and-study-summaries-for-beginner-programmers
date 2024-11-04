### _"Entidades são únicas e tem a capacidade de serem alteradas durante um longo período de tempo."_

_Uma entidade é algo que possui uma continuidade em seu ciclo de vida e pode  ser distinguida independente dos atributos que são importantes para a aplicação do usuário.
Pode ser uma pessoa, cidade, carro, um ticket de loteria ou uma trasação bancária. by Eric Evans._


Então temos como principal característica o sentido de identidade.

### Nosso objetivo
Mostrar como o DDD encherga uma entidade  e em que momento ela deve ser utilizada.

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