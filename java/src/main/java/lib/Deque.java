package lib;

import java.util.ArrayList;

/*
    ESTUTURA DE DADOS DEQUE
    
    - Deque = Double-Ended Queue (fila de duas pontas)
    - Deque é uma lista linear de acesso restrito, que permite apenas as operações
      de enfileiramento (insertFront/insertBack) e desenfileiramento (removeFront/
      removeBack), acontecendo em qualquer uma das extremidades da estrutura.
    - Como consequência, o deque NÃO SEGUE o princípio FIFO (First In, First Out -
      primeiro a entrar, primeiro a sair).
    - A principal aplicação dos deques são situações em que filas precisam aceitar
      a inserção de itens prioritários e a desistência do último item.
*/

public class Deque<T> {

    private ArrayList<T> data; // Lista privada

    public Deque() {
        this.data = new ArrayList<T>(); // Lista vazia
    }

    // Método para inserção no início da estrutura
    public void insertFront(T val) {
        this.data.add(0, val);
    }

    // Método para inserção no final da estrutura
    public void insertBack(T val) {
        this.data.add(val);
    }

    // Método para remoção do início da estrutura
    public T removeFront() {
        if (isEmpty())
            return null;
        return this.data.remove(0);
    }

    // Método para remoção do final da estrutura
    public T removeBack() {
        if (isEmpty())
            return null;
        return this.data.remove(this.data.size() - 1);
    }

    // Método para consultar o início da estrutura
    public T peekFront() {
        if (isEmpty())
            return null;
        return this.data.get(0);
    }

    // Método para consultar o final da estrutura
    public T peekBack() {
        if (isEmpty())
            return null;
        return this.data.get(this.data.size() - 1);
    }

    // Método para informar se o deque está ou não vazio
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    // Método que imprime o deque (para efeitos de depuração)
    public String print() {
        StringBuilder output = new StringBuilder("[ ");
        for (int i = 0; i < this.data.size(); i++) {
            if (output.length() > 2)
                output.append(", ");
            output.append("(").append(i).append("): ").append(this.data.get(i));
        }
        output.append(" ]");
        return output.toString();
    }
}
