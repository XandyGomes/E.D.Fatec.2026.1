package lib;

import java.util.ArrayList;

/*
    ESTRUTURA DE DADOS PILHA

    - Pilha é uma lista linear de acesso restrito, que permite apenas as operações
      de inserção (push) e retirada (pop), ambas ocorrendo no final da estrutura.
    - Como consequência, a pilha funciona pelo princípio LIFO (Last In, First Out -
      último a entrar, primeiro a sair).
    - A principal aplicação das pilhas são tarefas que envolvem a inversão de uma
      sequência de dados.
*/
public class Stack<T> {

    private ArrayList<T> data; // Lista interna privada

    public Stack() {
        this.data = new ArrayList<T>(); // Lista vazia
    }

    // Método para inserção na pilha
    public void push(T val) {
        this.data.add(val);
    }

    // Método para remoção da pilha
    public T pop() {
        if (isEmpty()) return null;
        return this.data.remove(this.data.size() - 1);
    }

    // Método para consultar o topo (última posição) da pilha
    // sem remover o elemento
    public T peek() {
        if (isEmpty()) return null;
        return this.data.get(this.data.size() - 1);
    }

    // Método para informar se a pilha está ou não vazia
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    // Método que imprime a pilha (para efeitos de depuração)
    public String print() {
        return this.data.toString();
    }
}
