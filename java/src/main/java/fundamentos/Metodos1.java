package fundamentos;

public class Metodos1 {

    // Método sem retorno (void)
    public static void imprimirSoma(int a, int b) {
        System.out.println(a + b);
    }

    // Método com retorno
    public static int somaRetorno(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        imprimirSoma(5, 4);

        System.out.println(somaRetorno(5, 8));
    }
}
