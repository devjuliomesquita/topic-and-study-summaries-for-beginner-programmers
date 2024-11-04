package com.juliomesquita.study.java_dsa.binary_search;

import java.util.Arrays;

public final class BinarySearch {
    private BinarySearch() {
    }

    /*
     * 1. Lista deve ser ordenada
     * 2. Este exemplo é enviado uma array e um item do array
     * 3. Informar a posição do item e quantas iterações
     *
     * */
//    public static void binarySearch(final int[] nums, final int num) {
//        /*
//         * 1. menor tamanho que o meu array pode ter = 0
//         * 2. é o tamanho real do array passado = tam -1
//         * 3. o ponto  médio entre alto e baixo = (baixo + alto) / 2
//         * 4. Regra é: Caso o meu array na posição do ponto médio seja igual ao item return
//         * 41. Caso seja maior que o item o valor do alto é igual a meio - 1
//         * 42. Caso seja menor que o item o valor do baixo é igual ao meio + 1
//         * 43. Caso não se encaixe return null pois o item não se encontra no array
//         * */
//        int baixo = 0;
//        int alto = nums.length - 1;
//        int interacoes = 0;
//        while (baixo <= alto) {
//            interacoes++;
//            int meio = (baixo + alto) / 2;
//            int chute = nums[meio];
//            if(chute == num){
//                System.out.println("Posição no array :: %s".formatted(meio));
//                System.out.println("Número de tebtaivas :: %s".formatted(interacoes));
//                return;
//            }
//            if(chute > num){
//                alto = meio -1;
//            }
//            if(chute < num){
//                baixo = meio +1;
//            }
//        }
//        System.out.println("O número :: %s não está nessa lista.".formatted(num));
//    }


//    public static void binarySearch(final int[] itens, final int item){
//        int baixo = 0;
//        int alto = itens.length-1;
//        int interacoes = 0;
//        while(baixo<=alto){
//            interacoes++;
//            int meio = (baixo+ alto) / 2;
//            int chute = itens[meio];
//            if(chute == item){
//                System.out.println("o item encontra-se na posição :: %s".formatted(meio+1));
//                System.out.println("foi realizado essa quantidade de iterações :: %s".formatted(interacoes));
//                return;
//            }
//            if(chute > item){
//                alto = meio -1;
//            }
//            if(chute < item){
//                baixo = meio +1;
//            }
//        }
//        System.out.println("o item :: %s não se encontra na lista".formatted(item));
//    }

//    public static int binarySearch(final int[] itens, final int item) {
//        return Arrays.binarySearch(itens, item);
//    }

    public static int searchInsertPosition(int[] nums, int target) {
        int baixo = 0;
        int alto = nums.length - 1;
        while (baixo <= alto) {
            int meio = (baixo + alto) / 2;
            int chute = nums[meio];
            if (chute == target) {
                return meio;
            }
            if (chute > target) {
                alto = meio - 1;
            }
            if (chute < target) {
                baixo = meio + 1;
            }
        }
        return baixo;
    }

    public static int mySqrt(final int x) {
        if (x == 0) {
            return 0;
        }
        int baixo = 1;
        int alto = x;

        while(baixo <= alto){
            int meio = baixo + (alto - baixo) / 2;
            if(meio == x / meio){
                return meio;
            }
            if(meio < x /meio){
                baixo = meio + 1;
            }
            if(meio > x / meio){
                alto = meio -1;
            }
        }
        return alto;
    }


}
