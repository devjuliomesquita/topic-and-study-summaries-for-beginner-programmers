# Exception ou Exceções

Para iniciar os estudos vamos entender o que é a classe Throwable e como funciona suas hierarquias.

**Throwable** é a classe raiz e fundamental para lidar com erros e exceções em tempo de execução. Sua hierarquia é dividida em duas: **Error** e **Exception**.

### Mas qual seria a real diferença entre Error e uma Exception?

* **Error:** São problemas e comportamentos muito sérios que não podem ser recuperados em tempo de execução. Os famosos são **OutOfMemoryError**, **StackOverFlowError**.


* **Exception:** Essa classe demonstra também problemas que acontecem durante a execução de um programa. Porém essas exceções podem ser recuperadas. E uma exception tem novas classes em sua hierarquia.

Como a classe Exception possui subclasses uma derivada direta é a **RuntimeException**. Utilizada em nosso programa para mapear exceçoes que ocorrem devido a um erro de lógica de programação.
**Culpa do desenvolvedor.** Exemplos comuns são **NullPointerException**, **IndexOutOfBoundsException**, **IllegalArgumentsException**.

As exceções são lançadas pela palavra reservada 'throw'

``` java
  throw new IllegalArgumentsException("Argumento inválido.");
```
**Um conceito muito importante quando estamos tratando exception é o checked e unchecked.**
### Quais suas diferenças?

* **Exceptions** em Java tem essas duas categorias **Checked (Verificadas)** e **Unchecked (Não verificadas)**. 
Fundamentalmente a diferença é que o compilador exige um tratamento ou declaração para lidar com essa exception.

**Checked** 
 - Compilador te obriga a tratar ou declarar qual exceptio o método irá lançar.
 - Derivão de Exception diretamente e não de RuntimeException.
 - Seus tratamentos podem ser feitos via try-catch ou throws na assinatura do método.

Veja este exemplo:

``` java
    import java.io.*;
    
    ...
    
    //Exception está sendo tratada no catch
    public static void lerArquivo() {
      try (Reader reader = new BufferedReader(new FileReader("test.txt"))) {
          // colocar novas funções
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
    
    //---------------------------------------
    
    public static void main(String[] args) {
        try {
            lerArquivo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Programa finalizado");
    }
    
    //Exception está sendo declarada e deve ser tratada na classe em que é chamada.
    public static void lerArquivo() throws IOException {
      try (Reader reader = new BufferedReader(new FileReader("test.txt"))) {
          // colocar novas funções
      }
    }
```
**Unchecked**
 - Compilador não te obriga a tratar ou declarar.
 - Derivadas de RuntimeException
 - O tratamento é opcional. 


> [!WARNING]
> 
> Mas lembresse toda exceção deve ser tratada.
> Lembre-se da hierarquia caso a Runtime não seja tratada vai subindo os níveis. 
> Runtime -> Exception -> Throwable -> Programa irá parar...

**Agora nos vem outra pergunta quando utilizar o try-catch e quando utilizar o throws?**

**Try-Catch**
 - Usar quando a exceções podem ser tratadas localmente.
 - Quando você pode fornecer um tratamento mais específico ou alternativo.
 - Quando você precisa executar um recurso mesmo que haja uma exception. Isso pode ser feito com o uso finally.

**Throws**
 - Quando não pode ser tratado localmente ou poderia ser melhor tratado em outro local. Então é necessário lançar para passar essa responsabilidade.
 - Quando a exceção faz parte da interface do método.

## Considerações finais

 - **Responsabilidade de tratamento:** Sempres considere onde a responsabilidade do tratamento deve residir. O método atual pode resolver o problema de forma satisfatória try-catch pode ser o mais apropriado se não deve-se informar a classe superior como tratar.
 - **Manutenção e Clareza:** Escolha a melhor abordagem para que o código fique mais claro de ler. Caso seu método lance várias exceções throws pode ser mais apropriado.
 - **Boas Práticas:** Siga as diretrizes e boas práticas da sua equipe ou projeto para o código fique coeso e fácil de manutenção.

---

Júlio C. Mesquita

###### tags: `Java` `Exceptions` `Documentation`



