package com.juliomesquita.study.java_basic.exceptions.exception.runtime_exception;

public class JavaRuntimeException {
    public static void main(String[] args) {
//        Exemplo de tratamento de uma RunTimeException
        try{
//            System.out.println(div(1, 0));
            System.out.println(div2(1, 0));
        } catch (RuntimeException e){
            System.out.println("Houve uma falha." + e);
        }
        System.out.println("Fim do sistema");
    }

    //    Treatment with Try - Catch
    public static int div(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            throw e;
        }
    }

    //    Treatment with throw
    public static int div2(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Valor enviado inválido. b deve ser diferente de 0.");
        }
        return a / b;
    }

}
