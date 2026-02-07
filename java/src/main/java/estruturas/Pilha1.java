package estruturas;

import java.util.ArrayList;

public class Pilha1 {

    public static void main(String[] args) {
        String frase = "Socorram-me, subi no ônibus em Marrocos";

        ArrayList<Character> vetor = new ArrayList<>(); // Lista usada como pilha

        // Percore a frase e coloca cada uma das letras dela dentro da lista
        for (int i = 0; i < frase.length(); i++) {
            vetor.add(frase.charAt(i)); // Insere no final
        }

        /************************************************************** */

        // DESCARACTERIZANDO A PILHA (inserindo ou removendo de posições proibidas)

        // Insere na primeira posição
        vetor.add(0, 'X');

        // Insere na 12ª posição
        vetor.add(11, 'W');

        // Remove a 24ª posição
        vetor.remove(23);

        /***************************************************************** */

        System.out.println(vetor);

        String reverso = "";

        while (!vetor.isEmpty()) {
            reverso += vetor.remove(vetor.size() - 1); // Retira do final
        }

        System.out.println(reverso);

        /*
         * PILHA
         * É uma estrutura de dados em que, usando uma lista linear (vetor/ArrayList)
         * como
         * base, permite inserções apenas no final e remoções também a partir do final.
         * LIFO = Last In, First Out (último a entrar, primeiro a sair).
         */
    }
}
