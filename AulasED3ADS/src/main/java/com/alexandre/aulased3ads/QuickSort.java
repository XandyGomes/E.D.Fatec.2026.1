/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alexandre
 */
public class QuickSort {

    //método público que facilita a chamada: o usuário só passa o vetor
    public static void quickSort(Comparable[] vetor) {
        //inicia a recursão passando o primiero(0) e o último índice
        quickSort(vetor, 0, vetor.length - 1);
    }

    // método privado recursivo que define os limites de atu
    private static void quickSort(Comparable[] vetor, int inicio, int fim) {
        //Caso base: se o início for menor que o fim, ainda há elementos para ordenar
        if (inicio < fim) {
            //reorganiza o vetor e encontra a posição correta do pivô
            int pivo = particionar(vetor, inicio, fim);

            // ordena a sub-lista à esquerda do pivô (elementos menores)
            quickSort(vetor, inicio, pivo - 1);
            // ordena a sub-lista à direita do pivô (elementos maiores)
            quickSort(vetor, pivo + 1, fim);

        }
    }

    //método privado que organiza os elemntos em torno do pivo
    private static int particionar(Comparable[] vetor, int inicio, int fim) {
        // escolha o último elemnto como pivô (padrão)
        Comparable pivo = vetor[fim];
        // "i" rastreia a posição do último elemento menor que o pivô encontrado
        int i = inicio - 1;

        //"j" percorre o vetor do início até o penúltimo elemento
        for (int j = inicio; j < fim; j++) {
            //compara o elemnto atuali com o pivô
            //comparaTo < 0 significa que vetor[j] é menor que pivô
            if (vetor[j].compareTo(pivo) < 0) {
                i++; //avança o índice do "limite dos menores"
                trocar(vetor, i, j); //joga o elemento menor para esquerda
            }
        }

        trocar(vetor, i + 1, fim);

        return i + 1;

    }

    private static void trocar(Comparable[] vetor, int i, int j) {
        Comparable temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    public static void main(String[] args) throws IOException {
//        Integer[] nums = {77, 44, 22, 33, 99, 55, 88, 0, 66, 11};
//
//        String[] nomesDesordenados = {"Maria", "João", "Ana", "Carlos", "Beatriz"};
//
//        quickSort(nums);
//        System.out.println("Números ordenados: " + Arrays.toString(nums));
//
//        quickSort(nomesDesordenados);
//        System.out.println("Nomes ordenados: " + Arrays.toString(nomesDesordenados));

        Path caminho = Path.of("data/nomes-desord.txt");
        List<String> lista = Files.readAllLines(caminho);
        String[] nomes = lista.toArray(new String[0]);

        long inicio = System.currentTimeMillis();
        quickSort(nomes); // Executa o algoritmo
        long fim = System.currentTimeMillis();

        System.out.println("Tempo de ordenação QuickSort: " + (fim - inicio) + "ms");

        // Imprime o resultado final
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}
