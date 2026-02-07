package estruturas;

import lib.Stack;

class InfoSimbolo {
    public char tipo;
    public int pos;

    public InfoSimbolo(char tipo, int pos) {
        this.tipo = tipo;
        this.pos = pos;
    }
}

public class PilhaAnaliseExpressao {

    public static void verifFechamento(char tipoFecha, int posFecha, InfoSimbolo infoAbre) {
        if (infoAbre == null) {
            System.out.println("ERRO: há mais símbolos de fechamento que de abertura; tipo " + tipoFecha + ", posição "
                    + posFecha);
        } else if (tipoFecha == infoAbre.tipo) {
            System.out.println("-> Símbolo tipo " + infoAbre.tipo + " aberto na posição " + infoAbre.pos
                    + " e fechado na posição " + posFecha);
        } else {
            System.out.println("ERRO: símbolo de fechamento do tipo " + tipoFecha + " encontrado na posição " + posFecha
                    + "; esperado tipo " + infoAbre.tipo);
        }
    }

    public static void main(String[] args) {
        String expressao = "3 / {2 + 4} * [-1 - (4 * 7) / 2)] + (2 * 7)}";

        Stack<InfoSimbolo> analisador = new Stack<>();

        for (int pos = 0; pos < expressao.length(); pos++) {
            char ch = expressao.charAt(pos);
            switch (ch) {
                case '{':
                    analisador.push(new InfoSimbolo('X', pos));
                    break;
                case '[':
                    analisador.push(new InfoSimbolo('C', pos));
                    break;
                case '(':
                    analisador.push(new InfoSimbolo('P', pos));
                    break;
                case '}':
                    verifFechamento('X', pos, analisador.pop());
                    break;
                case ']':
                    verifFechamento('C', pos, analisador.pop());
                    break;
                case ')':
                    verifFechamento('P', pos, analisador.pop());
                    break;
            }
        }

        while (!analisador.isEmpty()) {
            InfoSimbolo sobra = analisador.pop();
            System.out.println("ERRO: símbolo de abertura do tipo " + sobra.tipo + " na posição " + sobra.pos
                    + " não possui símbolo de fechamento correspondente");
        }
    }
}
