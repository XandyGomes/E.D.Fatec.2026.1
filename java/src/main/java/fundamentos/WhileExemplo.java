package fundamentos;

import java.util.Random;

public class WhileExemplo {

    public static int inteiroAleatorio(int num) {
        Random rand = new Random();
        return rand.nextInt(num); // Retorna de 0 até num-1
    }

    public static void main(String[] args) {
        int opcao = 0;

        while (opcao != 13) {
            opcao = inteiroAleatorio(15);
            System.out.println("Opção escolhida foi " + opcao);
        }
    }
}
