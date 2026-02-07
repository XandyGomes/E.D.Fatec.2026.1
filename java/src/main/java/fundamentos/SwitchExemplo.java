package fundamentos;

public class SwitchExemplo {

    public static void resultado(double nota) {
        // Math.floor(nota) retorna double, precisamos converter para int para o switch
        switch ((int) Math.floor(nota)) {
            case 10:
            case 9:
                System.out.println("Aprovado com nota TOP");
                break;

            case 8:
            case 7:
            case 6:
                System.out.println("Aprovado com nota razoável");
                break;

            case 5:
            case 4:
                System.out.println("Recuperação");
                break;

            case 3:
            case 2:
            case 1:
                System.out.println("Substitutiva");
                break;

            case 0:
                System.out.println("Reprovado");
                break;

            default:
                System.out.println("Nota inválida");
        }
    }

    public static void main(String[] args) {
        resultado(9.8);
        resultado(5.5);
        resultado(11);
    }
}
