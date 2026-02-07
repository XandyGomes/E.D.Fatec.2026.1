package lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataUtils {

    /**
     * Carrega um arquivo de texto onde cada linha é um elemento de uma lista.
     */
    public static List<String> loadNames(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar nomes: " + e.getMessage());
        }
        return list;
    }

    /**
     * Carrega um arquivo CSV simples.
     * Nota: Esta implementação não lida com vírgulas dentro de aspas (aspas
     * duplas).
     * Para um curso de Estrutura de Dados, isso costuma ser aceitável.
     */
    public static List<String[]> loadCSV(String path) {
        List<String[]> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            // Pula o cabeçalho
            br.readLine();
            while ((line = br.readLine()) != null) {
                // Remove aspas simples e divide por vírgula
                String[] parts = line.split("\",\"");
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].replace("\"", "");
                }
                list.add(parts);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar CSV: " + e.getMessage());
        }
        return list;
    }
}
