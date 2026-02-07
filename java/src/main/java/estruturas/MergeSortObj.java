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

public class MergeSortObj {

    public static int comps = 0, divisoes = 0, juncoes = 0;

    public static <T> List<T> mergeSort(List<T> vetor, BiPredicate<T, T> fnComp) {

        if (vetor.size() < 2)
            return vetor;

        int meio = vetor.size() / 2;

        List<T> vetEsq = new ArrayList<>(vetor.subList(0, meio));
        List<T> vetDir = new ArrayList<>(vetor.subList(meio, vetor.size()));

        divisoes++;

        vetEsq = mergeSort(vetEsq, fnComp);
        vetDir = mergeSort(vetDir, fnComp);

        int posEsq = 0, posDir = 0;
        List<T> vetRes = new ArrayList<>();

        while (posEsq < vetEsq.size() && posDir < vetDir.size()) {
            comps++;
            // A ordem dos parâmetros na chamada à função de comparação
            // deve ser INVERTIDA porque o if é verdadeiro quando o
            // primero elemento é MENOR (e não maior) que o segundo
            if (fnComp.test(vetDir.get(posDir), vetEsq.get(posEsq))) {
                vetRes.add(vetEsq.get(posEsq));
                posEsq++;
            } else {
                vetRes.add(vetDir.get(posDir));
                posDir++;
            }
        }

        List<T> sobra;
        if (posEsq < vetEsq.size()) {
            sobra = vetEsq.subList(posEsq, vetEsq.size());
        } else {
            sobra = vetDir.subList(posDir, vetDir.size());
        }

        juncoes++;

        List<T> resultado = new ArrayList<>(vetRes);
        resultado.addAll(sobra);
        return resultado;
    }

    public static void main(String[] args) {
        List<String[]> data = DataUtils.loadCSV("data/motoristas.csv");
        List<Motorista> motoristas = data.stream().map(Motorista::new).toList();

        comps = 0;
        divisoes = 0;
        juncoes = 0;

        long start = System.currentTimeMillis();
        List<Motorista> motoristasOrd = mergeSort(motoristas,
                (m1, m2) -> m1.nome_motorista.compareTo(m2.nome_motorista) > 0);
        long end = System.currentTimeMillis();

        System.out.println("Tempo de ordenação: " + (end - start) + "ms");
        System.out.println("Estatísticas: comps=" + comps + ", divisoes=" + divisoes + ", juncoes=" + juncoes);

        // System.out.println(motoristasOrd.subList(0, 10));
    }
}
