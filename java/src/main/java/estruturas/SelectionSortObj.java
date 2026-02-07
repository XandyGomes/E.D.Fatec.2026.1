package estruturas;

import lib.DataUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.function.BiPredicate;

class Motorista {
    public String razao_social;
    public String cnpj;
    public String nome_motorista;
    public String cpf;
    public String vigencia_do_cadastro;

    public Motorista(String[] parts) {
        this.razao_social = parts[0];
        this.cnpj = parts[1];
        this.nome_motorista = parts[2];
        this.cpf = parts[3];
        this.vigencia_do_cadastro = parts[4];
    }

    @Override
    public String toString() {
        return "Motorista{" + "nome='" + nome_motorista + '\'' + ", empresa='" + razao_social + '\'' + '}';
    }
}

public class SelectionSortObj {

    public static int pass, comps, trocas;

    public static <T> void selectionSort(List<T> vetor, BiPredicate<T, T> fnComp) {
        pass = 0;
        comps = 0;
        trocas = 0;

        for (int posSel = 0; posSel < vetor.size() - 1; posSel++) {
            pass++;
            int posMenor = posSel + 1;

            for (int i = posMenor + 1; i < vetor.size(); i++) {
                if (fnComp.test(vetor.get(posMenor), vetor.get(i)))
                    posMenor = i;
                comps++;
            }

            comps++;
            if (fnComp.test(vetor.get(posSel), vetor.get(posMenor))) {
                T temp = vetor.get(posSel);
                vetor.set(posSel, vetor.get(posMenor));
                vetor.set(posMenor, temp);
                trocas++;
            }
        }
    }

    public static void main(String[] args) {
        List<String[]> data = DataUtils.loadCSV("data/motoristas.csv");
        List<Motorista> motoristas = new ArrayList<>(data.stream().map(Motorista::new).toList());

        // Subset para não demorar demais (Selection sort ainda é O(n^2))
        List<Motorista> subset = motoristas.subList(0, Math.min(5000, motoristas.size()));

        long start = System.currentTimeMillis();
        selectionSort(subset, (m1, m2) -> {
            if (m1.razao_social.equals(m2.razao_social)) {
                return m1.nome_motorista.compareTo(m2.nome_motorista) > 0;
            } else {
                return m1.razao_social.compareTo(m2.razao_social) > 0;
            }
        });
        long end = System.currentTimeMillis();

        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double memoryMB = memory / 1024.0 / 1024.0;

        System.out.println("Tempo de ordenação (5000 registros): " + (end - start) + "ms");
        System.out.println("Passadas: " + pass + ", Comparações: " + comps + ", Trocas: " + trocas);
        System.out.println("Memória usada: " + memoryMB + "MB");
    }
}