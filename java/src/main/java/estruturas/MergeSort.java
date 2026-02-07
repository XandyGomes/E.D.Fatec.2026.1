package estruturas;

import lib.DataUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    MERGE SORT

    No processo de ordenação, esse algoritmo "desmonta" o vetor original
    contendo N elementos até obter N vetores de apenas um elemento cada um.
    Em seguida, usando a técnica de mesclagem (merge), "remonta" o vetor,
    dessa vez com os elementos já em ordem.
*/

public class MergeSort {

    public static int comps = 0, divisoes = 0, juncoes = 0;

    public static List<String> mergeSort(List<String> vetor) {

        // Para ser dividido, um vetor precisa ter pelo menos 2 elementos
        if (vetor.size() < 2)
            return vetor;

        // Acha o meio (aproximado) do vetor
        int meio = vetor.size() / 2;

        // Divide o vetor em dois
        // subList(from, to) -> from inclusive, to exclusive
        List<String> vetEsq = new ArrayList<>(vetor.subList(0, meio));
        List<String> vetDir = new ArrayList<>(vetor.subList(meio, vetor.size()));

        divisoes++;

        // Chamadas recursivas ao mergeSort
        vetEsq = mergeSort(vetEsq);
        vetDir = mergeSort(vetDir);

        // Mesclagem ordenada de vetEsq com vetDir
        int posEsq = 0, posDir = 0;
        List<String> vetRes = new ArrayList<>();

        while (posEsq < vetEsq.size() && posDir < vetDir.size()) {
            comps++;
            if (vetEsq.get(posEsq).compareTo(vetDir.get(posDir)) < 0) {
                vetRes.add(vetEsq.get(posEsq));
                posEsq++;
            } else {
                vetRes.add(vetDir.get(posDir));
                posDir++;
            }
        }

        // Sobra
        List<String> sobra;
        if (posEsq < vetEsq.size()) {
            sobra = vetEsq.subList(posEsq, vetEsq.size());
        } else {
            sobra = vetDir.subList(posDir, vetDir.size());
        }

        juncoes++;

        // O vetor final ordenado será a concatenação de vetRes + sobra
        List<String> resultado = new ArrayList<>(vetRes);
        resultado.addAll(sobra);
        return resultado;
    }

    public static void main(String[] args) {
        List<String> nums = new ArrayList<>(List.of("77", "44", "22", "33", "99", "55", "88", "0", "66", "11"));

        comps = 0;
        divisoes = 0;
        juncoes = 0;
        List<String> numsOrd = mergeSort(nums);

        System.out.println("Ordenado: " + numsOrd);
        System.out.println("Estatísticas: comps=" + comps + ", divisoes=" + divisoes + ", juncoes=" + juncoes);

        // Teste com nomes desordenados
        comps = 0;
        divisoes = 0;
        juncoes = 0;
        List<String> nomes = DataUtils.loadNames("data/nomes-desord.txt");

        long start = System.currentTimeMillis();
        List<String> nomesOrd = mergeSort(nomes);
        long end = System.currentTimeMillis();

        // mostrar a lista ordenada
        for (String nome : nomesOrd) {
            System.out.println(nome);
        }

        System.out.println("Tempo de ordenação: " + (end - start) + "ms");
        System.out.println("Estatísticas: comps=" + comps + ", divisoes=" + divisoes + ", juncoes=" + juncoes);
    }
}
