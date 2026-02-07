package estruturas;

/*
    Fatorial de um número natural é igual a ele próprio
    multiplicado por todos os seus antecessores

    5! = 5 * 4 * 3 * 2 * 1 (120)
    4! = 4 * 3 * 2 * 1 (24)
    3! = 3 * 2 * 1 (6)
    2! = 2 * 1 (2)

    Casos especiais:
    1! = 1
    0! = 1

    Expressando recursivamente:
    5! = 5 * 4!
    4! = 4 * 3!
    3! = 3 * 2!
    2! = 2 * 1!

    fatorial(n) = n * fatorial(n - 1), para qualquer n > 1
*/

public class Fatorial {

    // Implementação ITERATIVA
    public static long fatorial(int n) {
        long resultado = 1;
        for (int i = n; i > 1; i--)
            resultado *= i;
        return resultado;
    }

    // Implementação RECURSIVA
    public static long fatorialRec(int n) {
        if (n <= 1)
            return 1; // -> Condição de saída
        return n * fatorialRec(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Fatorial de 5: " + fatorial(5));
        System.out.println("Fatorial (recursivo) de 5: " + fatorialRec(5));
    }
}
