package estruturas;

import lib.Stack;

public class Pilha2 {

    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        System.out.println(pilha.print());
        System.out.println("Está vazia? " + pilha.isEmpty());

        pilha.push(35);
        pilha.push(77);
        pilha.push(19);
        System.out.println(pilha.print());
        System.out.println("Está vazia? " + pilha.isEmpty());

        Integer removido = pilha.pop();
        System.out.println("Removido: " + removido + ", Pilha: " + pilha.print());

        Integer ultimo = pilha.peek();
        System.out.println("Último (topo): " + ultimo + ", Pilha: " + pilha.print());

        // Tentativa de inserção no início da pilha (método não existe na classe Stack)
        // pilha.unshift(90);
    }
}
