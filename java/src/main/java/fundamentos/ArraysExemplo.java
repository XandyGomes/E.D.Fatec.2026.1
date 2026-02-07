package fundamentos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysExemplo {
    public static void main(String[] args) {
        // Arrays em Java têm tamanho fixo.
        // Para o comportamento dinâmico do JS (push/pop), usamos ArrayList.

        // Exemplo com Array fixo
        int[] valores = { 7, 8, 9, 10, 11 };

        System.out.println(Arrays.toString(valores));
        System.out.println(valores[2] + " " + valores[4]);
        System.out.println(valores.length);

        // Para mudar o tamanho, precisaríamos criar outro array.
        // Vamos usar ArrayList para mostrar a semelhança com JS:
        List<Integer> vDinamico = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11));

        vDinamico.add(20); // Simula valores[5] = 20 ou push
        System.out.println(vDinamico);

        vDinamico.add(90); // push
        vDinamico.add(91); // push
        vDinamico.add(92); // push

        System.out.println(vDinamico);

        // pop() -> remove o último elemento
        if (!vDinamico.isEmpty()) {
            vDinamico.remove(vDinamico.size() - 1);
        }

        System.out.println(vDinamico);
    }
}
