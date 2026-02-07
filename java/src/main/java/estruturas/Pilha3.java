package estruturas;

import lib.Stack;

public class Pilha3 {

    public static void main(String[] args) {
        /*
         * PALÍNDROMO: texto que pode ser lido de trás para frente e
         * continua idêntico
         */

        String frase = "Socorram-me, subi no ônibus em Marrocos";

        Stack<Character> pilha = new Stack<>();

        // Percorre a frase e coloca cada uma das letras dela dentro da pilha
        for (int i = 0; i < frase.length(); i++) {
            pilha.push(frase.charAt(i));
        }

        System.out.println(pilha.print());

        String reverso = "";

        while (!pilha.isEmpty()) {
            reverso += pilha.pop(); // Retira do final da pilha
        }

        System.out.println(reverso);
    }
}
