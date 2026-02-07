package estruturas;

import lib.DataUtils;
import java.util.List;

public class BuscaBinaria {

    public static int comps = 0; // Variável global (estática) para contar as comparações

    public static int buscaBinaria(List<String> vetor, String valorBusca) {
        comps = 0; // Reseta as comparações
        int ini = 0;
        int fim = vetor.size() - 1;

        while (fim >= ini) {
            int meio = (ini + fim) / 2;
            comps++; // Incrementa comparação

            if (valorBusca.equals(vetor.get(meio))) {
                return meio;
            } else {
                comps++; // Incrementa comparação do if seguinte
                if (valorBusca.compareTo(vetor.get(meio)) > 0) {
                    ini = meio + 1;
                } else {
                    fim = meio - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> nums = List.of("00", "11", "22", "33", "44", "55", "66", "77", "88", "99");

        System.out.println("Posição de 77: " + buscaBinaria(nums, "77") + ", comps: " + comps);
        System.out.println("Posição de 81: " + buscaBinaria(nums, "81") + ", comps: " + comps);

        List<String> nomes = DataUtils.loadNames("data/nomes.txt");

        System.out.println("Posição de ALEXANDRE: " + buscaBinaria(nomes, "ALEXANDRE") + ", comps: " + comps);
        System.out.println("Posição de ADAMASTOR: " + buscaBinaria(nomes, "ADAMASTOR") + ", comps: " + comps);
        System.out.println("Posição de ZULEIDE: " + buscaBinaria(nomes, "ZULEIDE") + ", comps: " + comps);
        System.out.println("Posição de INSTAGRAMILDA: " + buscaBinaria(nomes, "INSTAGRAMILDA") + ", comps: " + comps);
        System.out.println("Posição de JERDERSON: " + buscaBinaria(nomes, "JERDERSON") + ", comps: " + comps);
    }
}
