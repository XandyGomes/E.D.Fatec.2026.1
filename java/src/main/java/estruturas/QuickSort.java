package estruturas;

import lib.DataUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
    QUICK SORT
    
    Escolhe um dos elementos do vetor para ser o pivô (na nossa implementação,
    o último elemento) e, na primeira passada, divide o vetor, a partir da posição
    final do vetor, em um subvetor à esquerda contendo apenas valores menores que
    o pivô e outro subvetor à direita, que contém apenas valores maiores que o pivô.
    
    Em seguida, recursivamente, repete o processo em cada um dos subvetores até que
    todo o vetor esteja ordenado.
*/

public class QuickSort {

    public static int pass = 0, comps = 0, trocas = 0;

    public static void quickSort(String[] vetor) {
        pass = 0;
        comps = 0;
        trocas = 0;
        quickSort(vetor, 0, vetor.length - 1);
    }

    private static void quickSort(String[] vetor, int ini, int fim) {

        // Só trabalhamos se a região do vetor tiver, pelo menos, 2 elementos
        if (fim <= ini)
            return; // Condição de saída

        pass++;

        int pivot = fim;
        int div = ini - 1; // Divisor de regiões (inicialmente, antes do início do vetor)

        // For indo da posição ini até fim - 1
        for (int i = ini; i < fim; i++) {
            comps++;
            if (vetor[pivot].compareTo(vetor[i]) > 0) {
                div++;
                if (div != i) {
                    String temp = vetor[i];
                    vetor[i] = vetor[div];
                    vetor[div] = temp;
                    trocas++;
                }
            }
        }

        div++;

        // Colocamos o pivô em seu lugar definitivo
        comps++;
        if (vetor[div].compareTo(vetor[pivot]) > 0 && div != pivot) {
            String temp = vetor[div];
            vetor[div] = vetor[pivot];
            vetor[pivot] = temp;
            trocas++;
        }

        // Chama o Quick Sort para o subvetor à esquerda do pivô
        quickSort(vetor, ini, div - 1);

        // Chama o Quick Sort para o subvetor à direita do pivô
        quickSort(vetor, div + 1, fim);
    }

    public static void main(String[] args) {
        String[] nums = { "2", "5", "7", "1", "6", "3", "4" };
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("Estatísticas: pass=" + pass + ", comps=" + comps + ", trocas=" + trocas);

        List<String> nomesList = DataUtils.loadNames("data/nomes-desord.txt");
        String[] nomes = nomesList.toArray(new String[0]);

        pass = 0;
        comps = 0;
        trocas = 0;
        long start = System.currentTimeMillis();
        quickSort(nomes);
        long end = System.currentTimeMillis();

        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double memoryMB = memory / 1024.0 / 1024.0;

        System.out.println("Tempo de ordenação: " + (end - start) + "ms");
        System.out.println("Estatísticas: pass=" + pass + ", comps=" + comps + ", trocas=" + trocas);
        System.out.println("Memória: " + memoryMB + "MB");
    }
}
