package fundamentos;

import java.util.Random;

public class DoWhileExemplo {

    public static int inteiroAleatorio(int num) {
        Random rand = new Random();
        return rand.nextInt(num);
    }

    public static void main(String[] args) {
        int opcao;

        do {
            opcao = inteiroAleatorio(15);
            System.out.println("Opção escolhida foi " + opcao);
        } while (opcao != 14);
    }
}
