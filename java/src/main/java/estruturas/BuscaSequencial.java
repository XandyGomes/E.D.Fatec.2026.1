package estruturas;

import lib.DataUtils;
import java.util.List;

/*
    ALGORITMO DE BUSCA SEQUENCIAL

    Percorre o vetor, verificando se cada um dos elementos corresponde
    ao valor de busca. Ao encontrar uma correspondência, retorna a posição
    onde o valor de busca está no vetor.

    Caso o valor de busca não exista no vetor, retorna o valor convencional
    -1.
*/
public class BuscaSequencial {

    public static int buscaSequencial(List<String> vetor, String valorBusca) {
        // Percurso do vetor com for tradicional
        for (int i = 0; i < vetor.size(); i++) {
            if (vetor.get(i).equals(valorBusca))
                return i; // Encontrou valorBusca
        }
        return -1; // valorBusca não existe em vetor
    }

    public static void main(String[] args) {
        List<String> frutas = List.of("laranja", "maçã", "uva", "pera", "jabuticaba", "limão", "mamão");

        System.out.println("Posição de uva: " + buscaSequencial(frutas, "uva"));
        System.out.println("Posição de laranja: " + buscaSequencial(frutas, "laranja"));
        System.out.println("Posição de mamão: " + buscaSequencial(frutas, "mamão"));
        System.out.println("Posição de abacate: " + buscaSequencial(frutas, "abacate"));

        // Número de comparações em um vetor de n elementos:
        // Quando valorBusca é encontrado: pos + 1
        // Quando valorBusca não é encontrado: n

        List<String> nomes = DataUtils.loadNames("data/nomes.txt");

        long start = System.currentTimeMillis();
        System.out.println("Posição de ALEXANDRE: " + buscaSequencial(nomes, "ALEXANDRE"));
        System.out.println("Tempo: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println("Posição de JURANDIR: " + buscaSequencial(nomes, "JURANDIR"));
        System.out.println("Tempo: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println("Posição de VERONICA: " + buscaSequencial(nomes, "VERONICA"));
        System.out.println("Tempo: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println("Posição de BERNARDO: " + buscaSequencial(nomes, "BERNARDO"));
        System.out.println("Tempo: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println("Posição de ORKUTILSON: " + buscaSequencial(nomes, "ORKUTILSON"));
        System.out.println("Tempo: " + (System.currentTimeMillis() - start) + "ms");
    }
}
