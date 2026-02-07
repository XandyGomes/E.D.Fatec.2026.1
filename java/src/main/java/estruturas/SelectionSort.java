package estruturas;

import lib.DataUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
    SELECTION SORT

    Trata-se de uma otimização do bubble sort, diminuindo drasticamente
    o número de trocas necessárias para fazer a ordenação.

    Isola um dos valores do vetor e procura pelo menor valor entre os
    restantes, promovendo a troca caso o primeiro valor seja maior que
    o segundo.
*/

public class SelectionSort {

    public static int pass, comps, trocas;

    public static void selectionSort(String[] vetor) {
        pass = 0;
        comps = 0;
        trocas = 0;

        for (int posSel = 0; posSel < vetor.length - 1; posSel++) {
            pass++;
            int posMenor = posSel + 1;

            for (int i = posMenor + 1; i < vetor.length; i++) {
                if (vetor[posMenor].compareTo(vetor[i]) > 0)
                    posMenor = i;
                comps++;
            }

            comps++;
            if (vetor[posSel].compareTo(vetor[posMenor]) > 0) {
                String temp = vetor[posSel];
                vetor[posSel] = vetor[posMenor];
                vetor[posMenor] = temp;
                trocas++;
            }
        }
    }

    public static void main(String[] args) {
        String[] nums = { "77", "44", "22", "33", "99", "55", "88", "0", "66", "11" };
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("Passadas: " + pass + ", Comparações: " + comps + ", Trocas: " + trocas);

        List<String> nomesList = DataUtils.loadNames("data/nomes-desord.txt");
        String[] nomes = nomesList.toArray(new String[0]);

        long start = System.currentTimeMillis();
        selectionSort(nomes);
        long end = System.currentTimeMillis();

        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double memoryMB = memory / 1024.0 / 1024.0;

        System.out.println("Tempo de ordenação: " + (end - start) + "ms");
        System.out.println("Passadas: " + pass + ", Comparações: " + comps + ", Trocas: " + trocas);
        System.out.println("Memória usada: " + memoryMB + "MB");
    }
}
