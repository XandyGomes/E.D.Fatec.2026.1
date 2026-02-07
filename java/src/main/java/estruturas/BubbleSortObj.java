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

public class BubbleSortObj {

    public static int pass, comps, trocas;

    public static <T> void bubbleSort(List<T> vetor, BiPredicate<T, T> fnComp) {
        pass = 0;
        comps = 0;
        trocas = 0;
        boolean trocou;
        do {
            pass++;
            trocou = false;
            for (int i = 0; i < vetor.size() - 1; i++) {
                comps++;
                if (fnComp.test(vetor.get(i), vetor.get(i + 1))) {
                    T temp = vetor.get(i);
                    vetor.set(i, vetor.get(i + 1));
                    vetor.set(i + 1, temp);
                    trocou = true;
                    trocas++;
                }
            }
        } while (trocou);
    }

    public static void main(String[] args) {
        List<String[]> data = DataUtils.loadCSV("data/motoristas.csv");
        // Usamos ArrayList para permitir modificação (List.of/toList costumam ser
        // imutáveis)
        List<Motorista> motoristas = new ArrayList<>(data.stream().map(Motorista::new).toList());

        // Para testes, vamos pegar apenas os primeiros 1000 para não demorar demais
        List<Motorista> subset = motoristas.subList(0, Math.min(1000, motoristas.size()));

        long start = System.currentTimeMillis();
        bubbleSort(subset, (m1, m2) -> m1.nome_motorista.compareTo(m2.nome_motorista) > 0);
        long end = System.currentTimeMillis();

        System.out.println("Tempo de ordenação (1000 registros): " + (end - start) + "ms");
        System.out.println("Passadas: " + pass + ", Comparações: " + comps + ", Trocas: " + trocas);

        // Se quiser ver os resultados:
        // for(int i=0; i<10; i++) System.out.println(subset.get(i));
    }
}