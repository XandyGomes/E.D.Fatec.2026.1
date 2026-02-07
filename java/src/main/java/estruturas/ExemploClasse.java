package estruturas;

import lib.FormaGeometrica;

public class ExemploClasse {

    public static void main(String[] args) {
        // Criando objetos a partir da classe
        FormaGeometrica forma1 = new FormaGeometrica(15, 16, 'T');

        System.out.println(forma1.getBase() + " " + forma1.getAltura() + " " + forma1.getTipo());

        FormaGeometrica forma2 = new FormaGeometrica(9.7, 5, 'E');
        System.out.println(forma2.getBase() + " " + forma2.getAltura() + " " + forma2.getTipo());

        forma1.setBase(7);
        forma1.setAltura(22.5);
        forma1.setTipo('R');
        System.out.println(forma1.getBase() + " " + forma1.getAltura() + " " + forma1.getTipo());

        FormaGeometrica forma3 = new FormaGeometrica(14, 10, 'T');

        System.out.println("Área da forma1: " + forma1.calcArea());
        System.out.println("Área da forma2: " + forma2.calcArea());
        System.out.println("Área da forma3: " + forma3.calcArea());

        // Usando o "getter" que funciona como propriedade
        System.out.println("Área da forma1 (getArea): " + forma1.getArea());
        System.out.println("Área da forma2 (getArea): " + forma2.getArea());
        System.out.println("Área da forma3 (getArea): " + forma3.getArea());
    }
}
