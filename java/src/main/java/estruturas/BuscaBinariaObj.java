package estruturas;

import lib.DataUtils;
import java.util.List;
import java.util.function.Function;

/*
    Para usar a busca binária em um VETOR DE OBJETOS, precisamos
    transferir a comparação para uma função externa que retorne um
    dos três valores:
    0 -> caso ambos os valores sejam IGUAIS
    1 -> caso o valor de busca seja MAIOR que o valor do meio do vetor
    -1 -> caso o valor de busca seja MENOR que o valor do meio do vetor
*/

class Nome {
    public String first_name;
    public String group_name;
    public String classification;
    public String frequency_female;
    public String frequency_male;
    public int frequency_total;

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

public class BuscaBinariaObj {

    public static int comps = 0;

    public static <T> int buscaBinaria(List<T> vetor, Function<T, Integer> fnComp) {
        comps = 0;
        int ini = 0;
        int fim = vetor.size() - 1;

        while (fim >= ini) {
            comps++;
            int meio = (ini + fim) / 2;

            int resultado = fnComp.apply(vetor.get(meio));

            switch (resultado) {
                case 0: // Encontrado
                    comps++;
                    return meio;
                case 1: // Valor busca > valor do meio
                    comps += 2;
                    ini = meio + 1;
                    break;
                default: // -1, valor busca < valor do meio
                    comps += 2;
                    fim = meio - 1;
                    break;
            }
        }
        return -1;
    }

    public static int comparar(Nome valorMeio, String valorBusca) {
        if (valorBusca.equals(valorMeio.first_name))
            return 0;
        else if (valorBusca.compareTo(valorMeio.first_name) > 0)
            return 1;
        else
            return -1;
    }

    public static void main(String[] args) {
        List<String[]> data = DataUtils.loadCSV("data/obj-nomes.csv");
        List<Nome> objNomes = data.stream().map(Nome::new).toList();

        System.out.println("Posição de first_name === ALEXANDRE: " +
                buscaBinaria(objNomes, obj -> comparar(obj, "ALEXANDRE")));
        System.out.println("Comparações: " + comps);

        System.out.println("Posição de first_name === ULISSES: " +
                buscaBinaria(objNomes, obj -> comparar(obj, "ULISSES")));
        System.out.println("Comparações: " + comps);

        System.out.println("Posição de first_name === TWITTERSON: " +
                buscaBinaria(objNomes, obj -> comparar(obj, "TWITTERSON")));
        System.out.println("Comparações: " + comps);
    }
}