package lib;

/*
    Normalmente, se usa inicial maiúscula para nomear classes
*/
public class FormaGeometrica {

    /*
     * Variáveis usadas dentro de uma classe são chamadas ATRIBUTOS.
     * Existem dois tipos de atributos:
     * 1) Atributo PÚBLICO: pode ser acessado tanto de dentro quanto de fora da
     * classe.
     * 2) Atributo PRIVADO: só pode ser acessado de dentro da classe
     * (Encapsulamento).
     */

    private double base;
    private double altura;
    private char tipo;

    /*
     * O construtor é invocado toda vez que se tenta criar um objeto a partir da
     * classe.
     */
    public FormaGeometrica(double base, double altura, char tipo) {
        // Chamando os setters para fazer a validação
        setBase(base);
        setAltura(altura);
        setTipo(tipo);
    }

    // Funções getter: permitem ler atributos privados
    public double getBase() {
        return this.base;
    }

    public double getAltura() {
        return this.altura;
    }

    public char getTipo() {
        return this.tipo;
    }

    // Funções setter: permitem alterar atributos privados com validação
    public void setBase(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("ERRO: a base precisa ser maior que zero.");
        }
        this.base = valor;
    }

    public void setAltura(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("ERRO: a altura precisa ser maior que zero.");
        }
        this.altura = valor;
    }

    public void setTipo(char valor) {
        if (valor != 'R' && valor != 'T' && valor != 'E') {
            throw new IllegalArgumentException("ERRO: o tipo precisa ser um dos valores: 'R', 'T' ou 'E'.");
        }
        this.tipo = valor;
    }

    // Método público
    public double calcArea() {
        switch (this.tipo) {
            case 'R':
                return this.base * this.altura;
            case 'T':
                return this.base * this.altura / 2.0;
            case 'E':
                return (this.base / 2.0) * (this.altura / 2.0) * Math.PI;
            default:
                return 0;
        }
    }

    // Em Java, não temos "propriedades de leitura" nativas como getter do JS,
    // mas o getter getArea() cumpre esse papel.
    public double getArea() {
        return calcArea();
    }
}
