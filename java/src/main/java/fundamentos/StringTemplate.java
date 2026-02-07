package fundamentos;

public class StringTemplate {

    public static String conversaoMaiuscula(String m) {
        return m.toUpperCase();
    }

    public static void main(String[] args) {
        String nome1 = "Concatenar";
        String concatenar = "Olá " + nome1 + "!";
        System.out.println(concatenar);

        String nome2 = "Template";
        // Java não possui interpolação com backticks (``) como no JS.
        // As alternativas são concatenação, String.format ou formatted() (Java 15+).
        String template = String.format("Olá %s, tudo bem com você?", nome2);
        System.out.println(template);

        System.out.println("1 + 1 = " + (1 + 1));

        System.out.println(String.format("Olá %satecanos, tudo bem?", conversaoMaiuscula("f")));
    }
}
