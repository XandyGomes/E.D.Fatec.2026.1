package estruturas;

import lib.Deque;

public class ExemploDeque {

    public static void main(String[] args) {
        // Lista de compras em que primeiro devem aparecer
        // os itens alimentícios e depois os itens de higiene
        // e limpeza

        Deque<String> listaCompras = new Deque<>();
        System.out.println(listaCompras.print());

        // Alimentício -> início
        listaCompras.insertFront("Arroz");
        listaCompras.insertFront("Feijão");
        listaCompras.insertFront("Macarrão");
        System.out.println(listaCompras.print());

        // Higiene/Limpeza -> final
        listaCompras.insertBack("Sabão em pó");
        listaCompras.insertBack("Desodorante");
        listaCompras.insertBack("Água sanitária");
        System.out.println(listaCompras.print());

        // Alimentício -> início
        listaCompras.insertFront("Café");
        listaCompras.insertFront("Açúcar");
        System.out.println(listaCompras.print());

        // Higiene/Limpeza -> final
        listaCompras.insertBack("Amaciante");
        listaCompras.insertBack("Shampoo");
        System.out.println(listaCompras.print());

        // Desisti de comprar shampoo
        String removido = listaCompras.removeBack();
        System.out.println("Removido (Back): " + removido);
        System.out.println(listaCompras.print());

        // Passei pelo corredor, peguei açúcar e removi da lista
        removido = listaCompras.removeFront();
        System.out.println("Removido (Front): " + removido);
        System.out.println(listaCompras.print());

        // Consultar qual o próximo item da lista
        String proximo = listaCompras.peekFront();
        System.out.println("Próximo (Front): " + proximo);
        System.out.println(listaCompras.print());

        // Consultar o último item da lista
        String ultimo = listaCompras.peekBack();
        System.out.println("Último (Back): " + ultimo);
        System.out.println(listaCompras.print());
    }
}
