package fundamentos;

public class LacosRepeticao {
    public static void main(String[] args) {
        // Laço for
        for (int i = 1; i <= 10; i++) {
            System.out.println("Contador for = " + i);
        }
        System.out.println("FIM DO FOR");

        // Laço while
        int contador = 1;
        while (contador <= 10) {
            System.out.println("Contador while = " + contador);
            contador++;
        }
        System.out.println("FIM DO WHILE");
    }
}
