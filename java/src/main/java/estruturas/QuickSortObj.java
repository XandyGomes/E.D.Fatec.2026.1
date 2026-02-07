package estruturas;

import lib.DataUtils;
import java.util.ArrayList;
import java.util.List;
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

public class QuickSortObj {

    public static int pass = 0, comps = 0, trocas = 0;

    public static <T> void quickSort(List<T> vetor, BiPredicate<T, T> fnComp) {
        pass = 0;
        comps = 0;
        trocas = 0;
        quickSort(vetor, fnComp, 0, vetor.size() - 1);
    }

    private static <T> void quickSort(List<T> vetor, BiPredicate<T, T> fnComp, int ini, int fim) {

        if (fim <= ini)
            return;

        pass++;

        int pivot = fim;
        int div = ini - 1;

        for (int i = ini; i < fim; i++) {
            comps++;
            if (fnComp.test(vetor.get(pivot), vetor.get(i))) {
                div++;
                if (div != i) {
                    T temp = vetor.get(i);
                    vetor.set(i, vetor.get(div));
                    vetor.set(div, temp);
                    trocas++;
                }
            }
        }

        div++;

        comps++;
        if (div != pivot && fnComp.test(vetor.get(div), vetor.get(pivot))) {
            T temp = vetor.get(div);
            vetor.set(div, vetor.get(pivot));
            vetor.set(pivot, temp);
            trocas++;
        }

        quickSort(vetor, fnComp, ini, div - 1);
        quickSort(vetor, fnComp, div + 1, fim);
    }

    public static void main(String[] args) {
        List<String[]> data = DataUtils.loadCSV("data/motoristas.csv");
        List<Motorista> motoristas = new ArrayList<>(data.stream().map(Motorista::new).toList());

        long start = System.currentTimeMillis();
        quickSort(motoristas, (m1, m2) -> {
            if (m1.razao_social.equals(m2.razao_social)) {
                return m1.nome_motorista.compareTo(m2.nome_motorista) > 0;
            } else {
                return m1.razao_social.compareTo(m2.razao_social) > 0;
            }
        });
        long end = System.currentTimeMillis();

        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double memoryMB = memory / 1024.0 / 1024.0;

        System.out.println("Tempo de ordenação: " + (end - start) + "ms");
        System.out.println("Estatísticas: pass=" + pass + ", comps=" + comps + ", trocas=" + trocas);
        System.out.println("Memória: " + memoryMB + "MB");
    }
}
