package estruturas;

import lib.DoublyLinkedList;

public class ExemploDoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList<String> lista = new DoublyLinkedList<>();

        System.out.println("Lista vazia: " + lista.print());

        // Inserção em lista vazia
        lista.insert(0, "Fiat 147");
        System.out.println("Inserção em lista vazia: " + lista.print());

        // Inserção na primeira posição
        lista.insert(0, "Fusca");
        System.out.println("Inserção na primeira posição: " + lista.print());

        // Inserções na posição final
        lista.insert(lista.getCount(), "Chevette");
        System.out.println("Inserção na última posição: " + lista.print());
        lista.insert(lista.getCount(), "Opala");
        System.out.println("Inserção na última posição: " + lista.print());

        // Inserção em posição intermediária (posição 2)
        lista.insert(2, "Brasília");
        System.out.println("Inserção na posição 2: " + lista.print());

        // insertHead()
        lista.insertHead("Passat");
        System.out.println("insertHead(): " + lista.print());

        // insertTail()
        lista.insertTail("Corcel");
        System.out.println("insertTail(): " + lista.print());

        // Remoção da primeira posição
        String removido = lista.remove(0);
        System.out.println("Removido 0: " + removido + " | " + lista.print());

        // Remoção da última posição
        removido = lista.remove(lista.getCount() - 1);
        System.out.println("Removido último: " + removido + " | " + lista.print());

        // Remoção em posição intermediária
        removido = lista.remove(2);
        System.out.println("Removido 2: " + removido + " | " + lista.print());

        String pos0 = lista.peek(0);
        String pos3 = lista.peek(3);
        String pos4 = lista.peek(4);
        System.out.println("Peek: pos0=" + pos0 + ", pos3=" + pos3 + ", pos4=" + pos4);

        // Inserção de mais alguns valores na lista
        lista.insertTail("Variant");
        lista.insertTail("Polara");
        lista.insertTail("Maverick");
        lista.insertTail("Kombi");
        System.out.println(lista.print());

        int posPolara = lista.indexOf("Polara");
        int posFusca = lista.indexOf("Fusca");
        int posCorcel = lista.indexOf("Corcel");
        int posKombi = lista.indexOf("Kombi");
        System.out.println("Índices: Polara=" + posPolara + ", Fusca=" + posFusca + ", Corcel=" + posCorcel + ", Kombi="
                + posKombi);
    }
}
