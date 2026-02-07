package estruturas;

import lib.BinarySearchTree;
import java.util.ArrayList;
import java.util.List;

public class ExemploBST {

    public static void main(String[] args) {
        BinarySearchTree<Integer> arvore = new BinarySearchTree<>();

        arvore.insert(48);
        arvore.insert(71);
        arvore.insert(15);
        arvore.insert(29);
        arvore.insert(57);
        arvore.insert(1);
        arvore.insert(80);
        arvore.insert(13);
        arvore.insert(19);
        arvore.insert(37);
        arvore.insert(23);
        arvore.insert(21);
        arvore.insert(25);
        arvore.insert(51);
        arvore.insert(64);

        // Percurso em-ordem
        List<Integer> percurso = new ArrayList<>();
        arvore.inOrderTraversal(val -> percurso.add(val));
        System.out.println("Percurso em-ordem: " + percurso);

        // Percurso pré-ordem
        percurso.clear();
        arvore.preOrderTraversal(val -> percurso.add(val));
        System.out.println("Percurso pré-ordem: " + percurso);

        // Percurso pós-ordem
        percurso.clear();
        arvore.postOrderTraversal(val -> percurso.add(val));
        System.out.println("Percurso pós-ordem: " + percurso);

        /********************************************** */
        // TESTES DE REMOÇÃO
        percurso.clear();
        arvore.inOrderTraversal(val -> percurso.add(val));
        System.out.println("ANTES DAS REMOÇÕES: " + percurso);

        // Remoção de um nodo de grau 0
        arvore.remove(64);
        percurso.clear();
        arvore.inOrderTraversal(val -> percurso.add(val));
        System.out.println("Após a remoção do 64: " + percurso);

        // Remoção de um nodo de grau 1
        arvore.remove(1);
        percurso.clear();
        arvore.inOrderTraversal(val -> percurso.add(val));
        System.out.println("Após a remoção do 1: " + percurso);

        // Remoção de um nodo de grau 2
        arvore.remove(15);
        percurso.clear();
        arvore.inOrderTraversal(val -> percurso.add(val));
        System.out.println("Após a remoção do 15: " + percurso);

        // Remoção da RAIZ (grau 2)
        arvore.remove(48);
        percurso.clear();
        arvore.inOrderTraversal(val -> percurso.add(val));
        System.out.println("Após a remoção do 48: " + percurso);

        // Descobrindo qual nodo assumiu a posição da raiz:
        // fazendo um percurso pré-ordem e capturando o primeiro valor
        percurso.clear();
        arvore.preOrderTraversal(val -> percurso.add(val));
        System.out.println("O novo valor na raiz é " + percurso.get(0));

        /******************************************************* */
        // TESTES DE BUSCA

        boolean existe13 = arvore.search(13);
        boolean existe23 = arvore.search(23);
        boolean existe40 = arvore.search(40);
        boolean existe57 = arvore.search(57);
        System.out.println("Existe 13? " + existe13);
        System.out.println("Existe 23? " + existe23);
        System.out.println("Existe 40? " + existe40);
        System.out.println("Existe 57? " + existe57);
    }
}
