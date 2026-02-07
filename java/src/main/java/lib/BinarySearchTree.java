package lib;

import java.util.function.Consumer;

/*
    ESTRUTURA DE DADOS ÁRVORE BINÁRIA DE BUSCA
    - Árvore ~> é uma estrutura de dados não-linear, hierárquica,
      que é formada recursivamente por outras subárvores.
    - Árvore binária ~> uma árvore na qual cada nodo tem grau máximo
      igual a 2 (ou seja, cada nodo pode ter, no máximo, dois descendentes
      diretos).
    - Árvore binária de busca ~> é uma árvore binária otimizada para a
      operação de busca binária. Por isso, na inserção, os valores são 
      colocados já em ordem.
*/

public class BinarySearchTree<T extends Comparable<T>> {

    /*
     * Classe interna que representa a unidade de informação da árvore binária de
     * busca
     */
    private static class Node<T> {
        public T data; // Armazena a informação relevante para o usuário
        public Node<T> left; // Ponteiro para a subárvore esquerda
        public Node<T> right; // Ponteiro para a subárvore direita

        public Node(T val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root; // Raiz da árvore

    public BinarySearchTree() {
        this.root = null;
    }

    /* Método para efetuar inserção na ABB */
    public void insert(T val) {
        Node<T> inserted = new Node<>(val);

        // 1º caso: árvore vazia
        // O primeiro nodo fica sendo a raiz da árvore
        if (this.root == null) {
            this.root = inserted;
        }
        // 2º caso: inserção recursiva, percorrendo a árvore
        else {
            insertNode(inserted, this.root);
        }
    }

    /* Método privado que insere um novo nodo na árvore */
    private void insertNode(Node<T> inserted, Node<T> root) {
        // 1º caso: o valor a ser inserido é MENOR que o valor da raiz;
        // inserção ocorre à ESQUERDA da raiz
        if (inserted.data.compareTo(root.data) < 0) {
            // Se a posição à esquerda da raiz está desocupada, faz aí a inserção
            if (root.left == null)
                root.left = inserted;
            // Senão, reinicia o processo de inserção, recursivamente, com a
            // subárvore esquerda como raiz
            else
                insertNode(inserted, root.left);
        }

        // 2º caso: o valor a ser inserido é MAIOR que o valor da raiz;
        // a inserção ocorre à DIREITA da raiz
        else if (inserted.data.compareTo(root.data) > 0) {
            // Se a posição à direita da raiz está desocupada, faz aí a inserção
            if (root.right == null)
                root.right = inserted;
            // Senão, reinicia o processo de inserção, recursivamente, com a
            // subárvore direita como raiz
            else
                insertNode(inserted, root.right);
        }

        // 3º caso: o valor a ser inserido é IGUAL ao valor da raiz;
        // não se faz nada, já que a ABB, por definição, não deve ter valores
        // repetidos
    }

    /************************************************************
     * PERCURSOS
     *************************************************************/

    /* Método que executa o percurso em-ordem (in-order traversal) */
    public void inOrderTraversal(Consumer<T> fnCallback) {
        inOrderTraversal(fnCallback, this.root);
    }

    private void inOrderTraversal(Consumer<T> fnCallback, Node<T> root) {
        if (root != null) {
            inOrderTraversal(fnCallback, root.left); // 1º
            fnCallback.accept(root.data); // 2º
            inOrderTraversal(fnCallback, root.right); // 3º
        }
    }

    /* Método que executa o percurso pré-ordem (pre-order traversal) */
    public void preOrderTraversal(Consumer<T> fnCallback) {
        preOrderTraversal(fnCallback, this.root);
    }

    private void preOrderTraversal(Consumer<T> fnCallback, Node<T> root) {
        if (root != null) {
            fnCallback.accept(root.data); // 1º
            preOrderTraversal(fnCallback, root.left); // 2º
            preOrderTraversal(fnCallback, root.right); // 3º
        }
    }

    /* Método que executa o percurso pós-ordem (post-order traversal) */
    public void postOrderTraversal(Consumer<T> fnCallback) {
        postOrderTraversal(fnCallback, this.root);
    }

    private void postOrderTraversal(Consumer<T> fnCallback, Node<T> root) {
        if (root != null) {
            postOrderTraversal(fnCallback, root.left); // 1º
            postOrderTraversal(fnCallback, root.right); // 2º
            fnCallback.accept(root.data); // 3º
        }
    }

    /**************************************************************/

    /* Método que retorna o nodo de menor valor da árvore */
    private Node<T> minNode(Node<T> root) {
        // A partir da raiz, percorre à esquerda enquanto possível
        while (root != null && root.left != null)
            root = root.left;
        return root;
    }

    /* Método que retorna o nodo de maior valor da árvore */
    private Node<T> maxNode(Node<T> root) {
        // A partir da raiz, percorre à direita enquanto possível
        while (root != null && root.right != null)
            root = root.right;
        return root;
    }

    /* Método público para excluir um valor da árvore */
    public void remove(T val) {
        this.root = removeNode(this.root, val);
    }

    /* Método privado para excluir um nodo da árvore */
    private Node<T> removeNode(Node<T> root, T val) {

        // 1º caso: árvore vazia
        if (root == null)
            return null;

        // 2º caso: o valor a ser excluído é MENOR que o valor da raiz
        if (val.compareTo(root.data) < 0) {
            root.left = removeNode(root.left, val);
            return root;
        }

        // 3º caso: o valor a ser excluído é MAIOR que o valor da raiz
        if (val.compareTo(root.data) > 0) {
            root.right = removeNode(root.right, val);
            return root;
        }

        // 4º caso: o valor a ser excluído é IGUAL ao valor da raiz

        // 4.1: nodo de grau 0 (nodo folha)
        if (root.left == null && root.right == null) {
            return null;
        }

        // 4.2: nodo de grau 1, com subárvore à esquerda
        if (root.left != null && root.right == null) {
            return root.left;
        }

        // 4.3: nodo de grau 1, com subárvore à direita
        if (root.left == null && root.right != null) {
            return root.right;
        }

        // 4.4: nodo de grau 2
        // Nodo de menor valor da subárvore direita
        Node<T> newRoot = minNode(root.right);

        // Copia o valor do nodo encontrado para o nodo que está sendo excluído
        root.data = newRoot.data;

        // Excluímos o valor duplicado que ficou na subárvore direita
        root.right = removeNode(root.right, newRoot.data);

        return root;
    }

    /* Método público que busca por um valor dentro da árvore */
    public boolean search(T val) {
        Node<T> node = searchNode(this.root, val);
        return node != null;
    }

    /* Método privado que retorna nodo que contém o valor especificado */
    private Node<T> searchNode(Node<T> root, T val) {
        // 1º caso: a árvore está vazia
        if (root == null)
            return null;

        // 2º caso: o valor procurado é MENOR que o valor da raiz
        if (val.compareTo(root.data) < 0)
            return searchNode(root.left, val);

        // 3º caso: o valor procurado é MAIOR que o valor da raiz
        if (val.compareTo(root.data) > 0)
            return searchNode(root.right, val);

        // 4º caso: o valor procurado é IGUAL ao valor da raiz
        return root;
    }
}
