package lib;

/*
    ESTRUTURA DE DADOS LISTA ENCADEADA
    - A lista encadeada é uma estrutura de dados formada por unidades
      de informação chamadas nodos ou nós.
    - Cada nodo da lista encadeada tem duas partes: uma, que armazena a
      informação e outra que guarda o endereço do próximo nodo da sequência
    - A qualquer momento, temos um conhecimento apenas limitado de onde
      se encontram todos os nodos da lista. Sabemos apenas onde está o
      primeiro e o último nodo da sequência. Os nodos intermediários precisam
      ser encontrados partindo-se do primeiro e percorrendo a sequência
*/

public class LinkedList<T> {

    /*
     * Classe interna que representa a unidade de armazenamento da lista encadeada
     */
    private static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T val) {
            this.data = val;
            this.next = null;
        }
    }

    private Node<T> head; // Início da lista (cabeça)
    private Node<T> tail; // Fim da lista (cauda)
    private int count; // Quantidade de nodos da lista

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    // Método que retorna se a lista encadeada está vazia ou não
    public boolean isEmpty() {
        return this.count == 0;
    }

    // Método que retorna a quantidade de elementos da lista
    public int getCount() {
        return this.count;
    }

    // Método para inserir em qualquer posição
    public void insert(int pos, T val) {

        // Cria o nodo para armazenar o valor pretendido
        Node<T> inserted = new Node<>(val);

        // 1º caso: a lista está vazia
        if (isEmpty()) {
            this.head = inserted; // 1º nodo
            this.tail = inserted; // último nodo
        }

        // 2º caso: lista não vazia, inserção na primeira posição
        else if (pos == 0) {
            // O sucessor do nodo inserido será o nodo que atualmente
            // ocupa a primeira posição da lista
            inserted.next = this.head;
            // O início da lista passa a ser o novo nodo inserido
            this.head = inserted;
        }

        // 3º caso: inserção no final da lista
        else if (pos >= this.count) {
            // O atual último nodo da lista passa a apontar para o inserido
            this.tail.next = inserted;
            // O último nodo passa a ser o nodo inserido
            this.tail = inserted;
        }

        // 4º caso: posição intermediária
        else {
            // Nodo da posição ANTERIOR à de inserção
            Node<T> before = this.head; // Começa pelo primeiro nodo

            // Percurso até a posição ANTERIOR à de inserção,
            // saltando de nodo em nodo por meio do ponteiro next
            for (int i = 1; i < pos; i++)
                before = before.next;

            // Nodo da posição POSTERIOR à de inserção
            Node<T> after = before.next;

            // O sucessor do nodo inserted passa a ser o nodo after
            inserted.next = after;

            // O sucessor do nodo before passa a ser o nodo inserted
            before.next = inserted;
        }

        this.count++;

    }

    // Método para inserção na primeira posição (atalho)
    public void insertHead(T val) {
        this.insert(0, val);
    }

    // Método para inserção na última posição (atalho)
    public void insertTail(T val) {
        this.insert(this.count, val);
    }

    // Método para remoção de um nodo na lista
    public T remove(int pos) {

        // 1º caso: a lista está vazia ou a posição informada está
        // fora dos limites da lista
        if (isEmpty() || pos < 0 || pos > this.count - 1)
            return null;

        Node<T> removed;

        // 2º caso: remoção do início da lista
        if (pos == 0) {
            removed = this.head; // Marca o primeiro nodo para remoção
            // O início da lista passa a ser o nodo seguinte
            this.head = this.head.next;

            // Atualizando o tail em caso de remoção do único nodo restante
            if (this.count == 1)
                this.tail = null;
        }

        // 3º caso: remoção de nodo intermediário ou final
        else {
            Node<T> before = this.head;
            // Percorre a lista até a posição ANTERIOR à re remoção
            for (int i = 1; i < pos; i++)
                before = before.next;

            // O nodo removido será o seguinte
            removed = before.next;

            Node<T> after = removed.next;

            // O nodo anterior ao removido passa a apontar para o nodo
            // posterior ao removido
            before.next = after;

            // Atualiza o tail em caso de remoção do último nodo
            if (pos == this.count - 1)
                this.tail = before;
        }

        // Decrementa contagem de nodos da lista
        this.count--;

        // Retorna a informação armazenada no nodo removido
        return removed.data;
    }

    // Método para remover o primeiro nodo da lista (atalho)
    public T removeHead() {
        return this.remove(0);
    }

    // Método para remover o último nodo da lista (atalho)
    public T removeTail() {
        return this.remove(this.count - 1);
    }

    // Método para verificar a posição da primeira ocorrência de um valor na lista
    public int indexOf(T val) {

        // 1º caso: lista vazia
        if (isEmpty())
            return -1;

        Node<T> node = this.head;

        for (int i = 0; i < this.count; i++) {
            // Se o nodo contém o valor procurado, retorna a posição do nodo
            if (node.data.equals(val))
                return i;
            node = node.next;
        }

        // Se chegamos ao final da lista sem encontrar o valor, retornamos -1
        return -1;
    }

    // Método que retorna (sem remover) um nodo da lista, de acordo com sua posição
    public T peek(int pos) {

        // 1º caso: lista vazia ou posição fora dos limites
        if (isEmpty() || pos < 0 || pos > this.count - 1)
            return null;

        // 2º caso: busca sequencial
        Node<T> node = this.head;

        for (int i = 0; i < pos; i++)
            node = node.next;

        return node.data;
    }

    // Método para retornar (sem remover) o valor do primeiro nodo da lista (atalho)
    public T peekHead() {
        return this.peek(0);
    }

    // Método para retornar (sem remover) o valor do último nodo da lista (atalho)
    public T peekTail() {
        return this.peek(this.count - 1);
    }

    // Método para exibição da lista encadeada
    public String print() {
        StringBuilder output = new StringBuilder("( ");
        Node<T> node = this.head;
        for (int i = 0; i < this.count; i++) {
            if (output.length() > 2)
                output.append(", ");
            output.append("[").append(i).append("]: ").append(node.data);
            node = node.next;
        }
        output.append(" ), count: ").append(this.count);
        return output.toString();
    }
}
