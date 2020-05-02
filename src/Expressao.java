/**
 * creted by: Lucas Jesus
 * Date: 01/05/2020
 * repository: https://github.com/LuccasTraumer/CalculadoraED
 * */

public class Expressao{

    /**
     * Objeto que vai moldar o operador
     * */
    private static Operador SINAIS;
    /**
     * Vai armazenar o Resultado das Operações
     * */
    private static Pilha<Double> pilhaDeNumeros = new Pilha<>();
    /**
     * Metodo que vai chamar os metodos necessarios para ler e Resolver a Expressão
     * */
    public static double resolva(String strExp) throws Exception{
        PERCORRER_STRING(strExp);
        Armazenar.temSinal();
        Armazenar.verificarParentese();
        return pilharNumeros(Armazenar.FILA_EXPRESSAO_EM_ORDEM);
    }
    /**
     * Metodo que vai incluir os Numeros na Pilha de Numeros
     * */
    private static double pilharNumeros(Fila<Object> listaDados) throws Exception{
        while(!listaDados.estaVazio() && listaDados.inicio() != null || pilhaDeNumeros.getIndex() != 0) {
            if(listaDados.inicio() instanceof Double || listaDados.inicio() instanceof Integer) {
                pilhaDeNumeros.empilhar(Double.valueOf(listaDados.remover().toString()));
            }
            else{
                Double numDois = pilhaDeNumeros.remover();
                Double numUm = pilhaDeNumeros.remover();
                String sinal = listaDados.remover().toString();
                Double resultado = efetuarOperacao(numUm,numDois,sinal);
                 pilhaDeNumeros.empilhar(resultado);
            }
        }
        return pilhaDeNumeros.topo();
    }
    /**
     * Dado os Operando e Operador vai executar a Expressão
     * */
    private static Double efetuarOperacao(Double numUm,Double numDois, String operador){
        Double ret = 0.0;
        switch (operador){
            case "+":
                ret = numUm + numDois;
                break;
            case "-":
                ret = numUm - numDois;
                break;
            case "*":
                ret = numUm * numDois;
                break;
            case "/":
                ret = numUm / numDois;
                break;
            case "^":
                ret = Math.pow(numUm,numDois);
                break;
        }

        return ret;
    }
    /**
     * Metodo que vai ler a Expressão e separa Operando e Operadores
     * */
    private static void PERCORRER_STRING(String strExp) throws Exception{
        if(strExp == null || strExp.equals("") || strExp.equals(" "))
            throw new Exception("Expressão Invalida!");
        else{
            String exepressao = strExp.trim();
            String numero = "";
            Armazenar.size(strExp.length());
            for (int i = 0; i <= exepressao.length() - 1; i++) {
                char caracterAtual = exepressao.charAt(i);
                if (E_UM_NUMERO(caracterAtual) || caracterAtual == '.' || caracterAtual == ',') {
                    numero += caracterAtual + "";
                    if (E_UM_NUMERO(numero) && i == exepressao.length() - 1) {
                        inserirNumero(numero);
                    }
                } else {
                    inserirNumero(numero);
                    numero = "";
                    empilharOperador(caracterAtual);
                }
            }
        }

    }
    /**
     * Metodo que inclui os Operandos na Fila
     * */
    private static void inserirNumero(String numero) throws Exception{
        if(!numero.equals("") || numero.equals(" ")) {
            Armazenar.inserirNumero(converterCharToDouble(numero));
        }
    }
    /**
     * Metodo que insere os Operadores na Pilha
     * */
    private static void empilharOperador(char sinal) throws Exception{
        SINAIS = new Operador<Character, Integer>(sinal);
        Armazenar.empilharOperadores(SINAIS);
    }
    /**
     * Verifica se o caracter recebido é um numero
     * */
    private static boolean E_UM_NUMERO(char str){
        boolean ret = false;
        try{
            Integer num = Integer.parseInt(str+"");
            if(num != str){
                ret = true;
            }
        }catch(NumberFormatException err){
            err.getMessage();
        }
        return ret;
    }
    private static boolean E_UM_NUMERO(String str){
        boolean ret = false;
        Integer num = null;
        try{
            num = Integer.parseInt(str);
        }catch(NumberFormatException err){
            err.getMessage();
        }
        if(num != null){
            ret = true;
        }
        return ret;
    }
    /**
     * Converte o caracter recebido em um numero
     * */
    private static Double converterCharToDouble(String str){
        Double num = 0.0;
        try{
            num = Double.parseDouble(str+"");
        }catch(NumberFormatException err){
            err.getMessage();
        }
        return num;
    }
}