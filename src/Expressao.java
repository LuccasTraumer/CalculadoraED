import java.util.concurrent.ExecutionException;

class Expressao{

    private static Fila<Double> OPERANDOS;
    private static Pilha<Operadores> OPERADORES;

    private static Operadores sinaisPrecedencia;

    public static double resolva(String strExp){


    }
    private static PERCORRER_STRING(String strExp) throws Exception{
        String exepressao = strExp;
        String numero = "";
        for(int i=0; i < exepressao.length(); i++){
            char numeroOuOperador = exepressao.charAt(i);
            if(E_UM_NUMERO(numeroOuOperador)){
                numero = numeroOuOperador+"";
            }else{
               OPERANDOS.inserir(CONVERSOR(numero));
               numero = "";
               OPERADORES.empilhar(QUAL_OPERADOR(numeroOuOperador));
            }
        }
    }

    public static Operadores QUAL_OPERADOR(char operador) throws Exception{
        operadores = new Operadores(operador);
        return operadores;

    }
    public static char QUEM_TEM_PRIORIDADE(String operador){

    }
    private static boolean E_UM_NUMERO(char str){

    }
    private static double CONVERSOR(String elemento){

    }

}