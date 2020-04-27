public class Operadores<SINAL,PRECEDENCIA>{

    public static final char SOMA = '+';
    public static final char SUBTRACAO = '-';
    public static final char MULTIPLICACAO = '*';
    public static final char DIVISAO = '/';
    public static final char POTENCIACAO = '^';
    public static final char PARENTESE_ABERTURA = '(';
    public static final char PARENTESE_FECHADURA = ')';

    private char sinal = ' ';
    private int precedencia = 0;
    public Operadores(char sinal, int precedencia){
        this.sinal = sinal;
        this.precedencia = precedencia;
    }
    public Operadores(char sinal){
        this.sinal = sinal;
        this.precedencia = saberPrecedencia(sinal);
    }

    /**
     *
     * @param sinal(char)
     * @return o inteiro referente a precedencia, caso não encontre o sinal retorn 666.
     */
    public int saberPrecedencia(char sinal){
        int ret = 0;
        switch (sinal){
            case Operadores.SUBTRACAO:
                ret = 1;
                break;
            case Operadores.SOMA:
                ret = 1;
                break;
            case Operadores.DIVISAO:
                ret = 2;
                break;
            case Operadores.MULTIPLICACAO:
                ret = 2;
                break;
            case Operadores.POTENCIACAO:
                ret = 3;
                break;
            case Operadores.PARENTESE_ABERTURA:
                ret = 4;
                break;
            case Operadores.PARENTESE_FECHADURA:
                ret = 4;
                break;
            default:
                ret = 666;
                break;
        }
        return ret;
    }

    public char getSinal(){
        return this.sinal;
    }
    public int getPrecedencia(){
        return this.precedencia;
    }
}