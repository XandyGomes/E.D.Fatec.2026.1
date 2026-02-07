package estruturas;

/*
    O objeto em JavaScript permite a livre criação de propriedades.
    Em Java, geralmente usamos classes para definir a estrutura.
    Para demonstrar o conceito inicial, vamos usar uma classe simples.
*/

class Forma {
    public Object base;
    public Object altura;
    public char tipo;

    public Forma(Object base, Object altura, char tipo) {
        this.base = base;
        this.altura = altura;
        this.tipo = tipo;
    }
}

public class Objetos {

    public static Double calcArea(Forma forma) {
        if (!(forma.base instanceof Number) || !(forma.altura instanceof Number)) {
            return null;
        }

        double base = ((Number) forma.base).doubleValue();
        double altura = ((Number) forma.altura).doubleValue();

        switch (forma.tipo) {
            case 'R': // Retângulo
                return base * altura;
            case 'T': // Triângulo
                return base * altura / 2.0;
            case 'E': // Elipse
                return (base / 2.0) * (altura / 2.0) * Math.PI;
            default: // Forma desconhecida
                return null;
        }
    }

    public static void main(String[] args) {
        Forma forma1 = new Forma(15, 12, 'R');
        Forma forma2 = new Forma(10, 26, 'T');
        Forma forma3 = new Forma(20, 10, 'E');
        Forma forma4 = new Forma(7.5, 12.3, 'G');
        Forma forma5 = new Forma("batata", "cebola", 'E');

        System.out.println("Área de um retângulo de 15x12: " + calcArea(forma1));
        System.out.println("Área de um triângulo de 10x26: " + calcArea(forma2));
        System.out.println("Área de uma elipse de 20x10: " + calcArea(forma3));
        System.out.println("Área de forma4: " + calcArea(forma4));
        System.out.println("Área de forma5: " + calcArea(forma5));

        /*
         * CONCLUSÃO
         * O objeto em Java (através de classes) impõe mais rigor, mas se usarmos
         * Object,
         * ainda podemos ter problemas de tipos.
         * A solução ideal é usar tipos específicos e validação dentro da classe
         * (Encapsulamento).
         */
    }
}
