package estruturas;

import lib.Queue;

public class Fila {

    public static void main(String[] args) {
        Queue<String> fila = new Queue<>();
        System.out.println(fila.print());

        // Inserções na fila
        fila.enqueue("Cleverton");
        fila.enqueue("Lindalvânia");
        fila.enqueue("Praxedes");
        fila.enqueue("Gerinalda");

        System.out.println(fila.print());

        // Remoção da fila
        String atendido = fila.dequeue();
        System.out.println("Atendido: " + atendido);
        System.out.println(fila.print());

        // Novas inserções
        fila.enqueue("Osclerson");
        fila.enqueue("Hermenevaldo");
        System.out.println(fila.print());

        // Observando o início da fila
        String proximo = fila.peek();
        System.out.println("Próximo: " + proximo);
        System.out.println(fila.print());

        // Nova remoção
        atendido = fila.dequeue();
        System.out.println("Atendido: " + atendido);
        System.out.println(fila.print());
    }
}
