package estruturas;

import lib.LinkedList;

public class ExemploLinkedList {

    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();

        // Inserção em lista vazia (1º caso)
        lista.insert(0, "Fusca");

        // Inserção na 1ª posição (2º caso)
        lista.insert(0, "Corcel");

        // Inserções na posição final (3º caso)
        lista.insert(2, "Opala");
        lista.insert(3, "Chevette");
        lista.insert(4, "Maverick");

        System.out.println(lista.print());

        // Inserções em posição intermediária (4º caso)
        lista.insert(3, "Brasília");
        System.out.println(lista.print());

        lista.insert(2, "Gol");
        System.out.println(lista.print());

        // Testando os métodos de atalho
        lista.insertHead("Belina"); // Primeira posição
        System.out.println(lista.print());

        lista.insertTail("Del Rey");
        System.out.println(lista.print());

        // Remoção do primeiro nodo
        String removido = lista.remove(0);
        System.out.println("Removido 0: " + removido);
        System.out.println(lista.print());

        // Remoção do último nodo
        removido = lista.remove(lista.getCount() - 1);
        System.out.println("Removido último: " + removido);
        System.out.println(lista.print());

        // Remoção do nodo da posição 4
        removido = lista.remove(4);
        System.out.println("Removido 4: " + removido);
        System.out.println(lista.print());

        // testando os métodos de atalho
        String primeiro = lista.removeHead();
        String ultimo = lista.removeTail();
        System.out.println("Removidos: primeiro=" + primeiro + ", ultimo=" + ultimo);
        System.out.println(lista.print());

        // Testando indexOf()
        int idxFusca = lista.indexOf("Fusca");
        int idxOpala = lista.indexOf("Opala");
        int idxBelina = lista.indexOf("Belina");

        System.out.println("Índices: Fusca=" + idxFusca + ", Opala=" + idxOpala + ", Belina=" + idxBelina);

        // Testando peek()
        String pos0 = lista.peek(0);
        String pos3 = lista.peek(3);
        String pos5 = lista.peek(5);

        System.out.println("Peek: pos0=" + pos0 + ", pos3=" + pos3 + ", pos5=" + pos5);
    }
}
