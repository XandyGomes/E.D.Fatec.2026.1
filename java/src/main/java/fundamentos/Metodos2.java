package fundamentos;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Metodos2 {

    public static void main(String[] args) {
        // Em Java, funções como objetos são implementadas via interfaces funcionais
        // (Lambdas)

        // Simulação de const imprimirSoma = function(a,b)
        BiFunction<Integer, Integer, Integer> soma = (a, b) -> a + b;
        System.out.println(soma.apply(2, 9));

        // Lambda com corpo (return explícito)
        BiFunction<Integer, Integer, Integer> somaCorpo = (a, b) -> {
            return a + b;
        };
        System.out.println(somaCorpo.apply(8, 10));

        // Lambda curta (expressão)
        BiFunction<Integer, Integer, Integer> sub = (a, b) -> a - b;
        System.out.println(sub.apply(10, 3));

        // Consumidor (apenas executa uma ação)
        Consumer<String> imp = a -> System.out.println(a);
        imp.accept("teste");
    }
}
