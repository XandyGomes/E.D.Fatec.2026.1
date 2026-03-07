/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads;

/**
 *
 * @author Alexandre
 */
public class BuscaSequencial {
    
    public static int buscaSequencialS(String[] vetor, String valorBusca){
       for (int i = 0; i < vetor.length; i++){
           if(vetor[i].equals(valorBusca)){
               return i;
           }
       }
       return -1;
    }
    public static int buscaSequencialI(Integer[] vetor, Integer valorBusca){
       for (int i = 0; i < vetor.length; i++){
           if(vetor[i].equals(valorBusca)){
               return i;
           }
       }
       return -1;
    }
    
    public static void main(String[] args) {
        //vetor de frutas
        String[] frutas = {"laranja", "maça", "pera", "uva", "jabuticaba", "limão", "mamão"};
        Integer[] numeros = {5, 7, 9, 8, 1, 3, 44, 66, 12};
        
        System.out.println("Posição de uva: " + buscaSequencialS(frutas, "uva"));
        System.out.println("Posição de maça: " + buscaSequencialS(frutas, "maça"));
        System.out.println("Posição de melão: " + buscaSequencialS(frutas, "melão"));
        
        System.out.println("Posição do numero 1: " + buscaSequencialI(numeros, 1));
    }
}
