package estruturas;

import java.util.Arrays;

/*
    BUBBLE SORT
    Percorre o conjunto de dados, comparando o elemento atual com o seu
    sucessor e promovendo a troca entre eles caso o primeiro seja maior
    que o segundo.
    Faz isso em várias passadas, até, que, na última delas, nenhuma troca
    tenha sido registrada.
*/

public class BubbleSort {

    public static void bubbleSort(int[] vetor) {
        boolean trocou;
        do {
            trocou = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    // Troca os elementos
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    trocou = true;
                }
            }
        } while (trocou);
    }

    public static void main(String[] args) {
        int[] nums = { 77, 44, 22, 33, 99, 55, 88, 0, 66, 11 };

        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
