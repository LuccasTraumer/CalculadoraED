public class Expressao{


    private static Operador SINAIS;
    private static Pilha<Double> pilhaDeNumeros = new Pilha<>();

    //private String numero = "";
    public static double resolva(String strExp) throws Exception{
        PERCORRER_STRING(strExp);
        Armazenar.verificarParentese();
        return pilharNumeros(Armazenar.FILA_EXPRESSAO_EM_ORDEM);
    }

    public static double pilharNumeros(Fila<Object> listaDados) throws Exception{
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
    public static void PERCORRER_STRING(String strExp) throws Exception{
        if(strExp == null || strExp.equals("") || strExp.equals(" "))
            throw new Exception("Expressão Invalida!");
        else{
            String exepressao = strExp.trim();
            String numero = "";
            Armazenar.size(strExp.length());
            for (int i = 0; i <= exepressao.length() - 1; i++) {
                char caracterAtual = exepressao.charAt(i);
                if (E_UM_NUMERO(caracterAtual)) {
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


    private static void inserirNumero(String numero) throws Exception{
        if(!numero.equals("") || numero.equals(" ")) {
            Armazenar.inserirNumero(converterCharToInt(numero));
        }
    }
    private static void empilharOperador(char sinal) throws Exception{
        SINAIS = new Operador<Character, Integer>(sinal);
        Armazenar.empilharOperadores(SINAIS);
    }

    public static boolean E_UM_NUMERO(char str){
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
    public static boolean E_UM_NUMERO(String str){
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

    public static int converterCharToInt(char str){
        int num = 0;
        try{
            num = Integer.parseInt(str+"");
        }catch(NumberFormatException err){
            err.getMessage();
        }
        return num;
    }
    public static int converterCharToInt(String str){
        int num = 0;
        try{
            num = Integer.parseInt(str+"");
        }catch(NumberFormatException err){
            err.getMessage();
        }
        return num;
    }
}