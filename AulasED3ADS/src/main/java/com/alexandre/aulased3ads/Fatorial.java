/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads;

/**
 *
 * @author Alexandre
 */
public class Fatorial {
    
    //implementação ITERATIVA
    public static long fatorial(int n){
        long res = 1;
        for(int i = n; i > 1; i--){
            res = res * i;
        }
        return res;
    }
    //implementação RECURSIVA
    public static long fatorialRec(int n){
        if( n <= 1){
            return 1; //condição de saída
        }
        return n * fatorialRec(n - 1);
    }
    
    
    public static void main(String[] args) {
        System.err.println("Fatorial de 5: " + fatorial(5));
        System.err.println("Fatorial (recursivo) de 5: " + fatorialRec(5));
    }
    
    
}
