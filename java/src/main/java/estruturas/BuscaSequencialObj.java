package estruturas;

import lib.DataUtils;
import java.util.List;
import java.util.function.Predicate;

/*
    Quando um algoritmo de busca precisa atuar sobre um vetor
    de objetos, a comparação não deve ser feita dentro da função
    que implementa o algoritmo. Em vez disso, recebemos uma outra
    função (externa) como parâmetro que resolverá a comparação.

    Essa função externa será chamada passando o objeto atual do vetor
    e esperará um retorno true, caso a função externa determine que
    o objeto atual contém o valor de busca, ou false, caso contrário.
*/

// Representação simples de um objeto de nome
class Nome {
    public String first_name;
    public String group_name;
    public String classification;
    public String frequency_female;
    public String frequency_male;
    public int frequency_total;
    // ... outros campos se necessário

    public Nome(String[] parts) {
        this.first_name = parts[0];
        this.group_name = parts[1];
        this.classification = parts[2];
        this.frequency_female = parts[3];
        this.frequency_male = parts[4];
        try {
            this.frequency_total = Integer.parseInt(parts[5]);
        } catch (Exception e) {
            this.frequency_total = 0;
        }
    }
}

public class BuscaSequencialObj {

    public static <T> int buscaSequencial(List<T> vetor, Predicate<T> fnComp) {
        // Percurso do vetor com for tradicional
        for (int i = 0; i < vetor.size(); i++) {
            // A comparação será feita pela função externa fnComp
            if (fnComp.test(vetor.get(i)))
                return i;
        }
        return -1; // não encontrado
    }

    public static void main(String[] args) {
        List<String[]> data = DataUtils.loadCSV("data/obj-nomes.csv");
        List<Nome> objNomes = data.stream().map(Nome::new).toList();

        long start = System.currentTimeMillis();
        System.out.println("Posição de AABRAO: " + buscaSequencial(objNomes, obj -> obj.first_name.equals("AABRAO")));
        System.out.println("Tempo: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(
                "Posição de CLAUDEMIR: " + buscaSequencial(objNomes, obj -> obj.first_name.equals("CLAUDEMIR")));
        System.out.println("Tempo: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println("Posição de MOACIR: " + buscaSequencial(objNomes, obj -> obj.first_name.equals("MOACIR")));
        System.out.println("Tempo: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println("Posição de GERCINA: " + buscaSequencial(objNomes, obj -> obj.first_name.equals("GERCINA")));
        System.out.println("Tempo: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(
                "Posição frequency_total 14909: " + buscaSequencial(objNomes, obj -> obj.frequency_total == 14909));
        System.out.println("Tempo: " + (System.currentTimeMillis() - start) + "ms");
    }
}
