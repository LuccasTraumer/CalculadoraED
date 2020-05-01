import java.util.concurrent.ExecutionException;

/**
 * creted by: Lucas Jesus
 * Date: 01/05/2020
 * repository: https://github.com/LuccasTraumer/CalculadoraED
 * */
public class Operador<SINAL,PRECEDENCIA>{

    /**
     * Atributos fixos para compração de Operadores
     * */
    public static final char SOMA = '+';
    public static final char SUBTRACAO = '-';
    public static final char MULTIPLICACAO = '*';
    public static final char DIVISAO = '/';
    public static final char POTENCIACAO = '^';
    public static final char PARENTESE_ABERTURA = '(';
    public static final char PARENTESE_FECHADURA = ')';

    private char sinal = ' ';
    private int precedencia = 0;
    /**
     * Recebendo o sinal, ele busca qual a precedencia e atribui ao atributo
     * */
    public Operador(char sinal) throws Exception{
        this.sinal = sinal;
        this.precedencia = saberPrecedencia(sinal);

        if(precedencia == 666)
            throw new Exception("Sinal de Operação Invalido!");
    }

    /**
     *
     * @param sinal(char)
     * @return o inteiro referente a precedencia, caso não encontre o sinal retorn 666.
     */
    protected int saberPrecedencia(char sinal){
        int ret = 0;
        switch (sinal){
            case Operador.SUBTRACAO:
                ret = 1;
                break;
            case Operador.SOMA:
                ret = 1;
                break;
            case Operador.DIVISAO:
                ret = 2;
                break;
            case Operador.MULTIPLICACAO:
                ret = 2;
                break;
            case Operador.POTENCIACAO:
                ret = 3;
                break;
            case Operador.PARENTESE_ABERTURA:
                ret = 4;
                break;
            case Operador.PARENTESE_FECHADURA:
                ret = 4;
                break;
            default:
                ret = 666;
                break;
        }
        return ret;
    }

    protected char getSinal(){
        return this.sinal;
    }
    protected int getPrecedencia(){
        return this.precedencia;
    }
    public String toString(){
        return this.sinal+"";
    }
}