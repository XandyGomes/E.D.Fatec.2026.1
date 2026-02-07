package fundamentos;

import java.util.Arrays;

public class Variaveis {
    public static void main(String[] args) {
        String nome = "Alexandre"; // String
        int idade = 44; // integer
        double peso = 83.5; // double (float literal precisa de f no final em Java)
        boolean masculino = true; // boolean

        String[] nomes = { "Rafael", "Joao", "Jose", "Maria" }; // array (vetor)

        // Em Java, objetos costumam ser instâncias de classes.
        // Para simular o objeto literal do JS, criamos uma classe interna ou usamos um
        // Map.
        Cadastro cadastro = new Cadastro("xandy", 44, 83.5, false);

        System.out.println(nome);
        System.out.println(idade);

        System.out.println(nomes[2]);

        System.out.println("O nome do objeto cadastro é: " + cadastro.nome);
    }
}

class Cadastro {
    public String nome;
    public int idade;
    public double peso;
    public boolean feminino;

    public Cadastro(String nome, int idade, double peso, boolean feminino) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.feminino = feminino;
    }
}
