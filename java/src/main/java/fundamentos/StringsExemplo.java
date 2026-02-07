package fundamentos;

import java.util.Arrays;

public class StringsExemplo {
    public static void main(String[] args) {
        String facul = "FATEC";
        char a, b, c, d, e;

        a = facul.charAt(0);
        b = facul.charAt(1);
        c = facul.charAt(2);
        d = facul.charAt(3);
        e = facul.charAt(4);

        System.out.println("" + a + b + c + d + e);
        System.out.println(a + " " + b + " " + c + " " + d + " " + e);

        System.out.println(facul.charAt(4));
        System.out.println((int) facul.charAt(0)); // charCodeAt em Java é cast para int
        System.out.println(facul.indexOf("C"));
        System.out.println(facul.substring(1, 3)); // ATENÇÃO: em Java sub(1,3) pega pos 1 e 2
        System.out.println("Faculdade ".concat(facul).concat("!!!"));
        System.out.println(facul.replace("F", "3"));

        String nomesStr = "Alexandre,Joao,Pedro";
        String[] nomesArray = nomesStr.split(",");
        System.out.println(Arrays.toString(nomesArray));

        String[] listaNomes = { "alexandre", "joao", "maria", "fulano", "ciclano" };
        // Em Java, não temos slice() direto em arrays, usamos Arrays.copyOfRange
        String[] fatia = Arrays.copyOfRange(listaNomes, 1, 3);
        System.out.println(Arrays.toString(fatia));
    }
}
