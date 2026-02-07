package lib;

import java.util.ArrayList;

/*
    ESTRUTURA DE DADOS FILA

    - Fila é uma lista linear de acesso restrito, que permite apenas as operações
      de enfileiramento (enqueue) e desenfileiramento (dequeue), a primeira ocorrendo
      no final da estrutura e a segunda no início da estrutura.
    - Como consequência, a fila funciona pelo princípio FIFO (First In, First Out -
      primeiro a entrar, primeiro a sair).
    - A principal aplicação das filas são situações que envolvem o processamento de 
      tarefas por ordem de chegada.
*/
public class Queue<T> {

    private ArrayList<T> data; // Lista privada

    public Queue() {
        this.data = new ArrayList<T>(); // Lista vazia
    }

    // Método para inserção na fila
    public void enqueue(T val) {
        this.data.add(val);
    }

    // Método para remoção da fila
    public T dequeue() {
        if (isEmpty()) return null;
        return this.data.remove(0);    
    }

    // Método para consultar o início da fila sem remover o elemento
    public T peek() {
        if (isEmpty()) return null;
        return this.data.get(0);
    }

    // Método para informar se a fila está ou não vazia
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    // Método que imprime a fila (para efeitos de depuração)
    public String print() {
        StringBuilder output = new StringBuilder("[ ");
        for (int i = 0; i < this.data.size(); i++) {
            if (output.length() > 2) output.append(", ");
            output.append("(").append(i).append("): ").append(this.data.get(i));
        }
        output.append(" ]");
        return output.toString();
    }
}
