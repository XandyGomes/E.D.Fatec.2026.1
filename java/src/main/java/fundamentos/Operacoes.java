package fundamentos;

public class Operacoes {
    public static void main(String[] args) {
        int x = 30;
        int y = 10;
        int res1 = x + y;
        int res2 = x - y;
        int res3 = x / y;
        int res4 = x * y;

        x += y; // x = x + y
        x -= y;

        System.out.println("A soma é: " + res1);
        System.out.println("A subtração é: " + res2);
        System.out.println("A divisão é: " + res3);
        System.out.println("A multiplicação é: " + res4);
    }
}
