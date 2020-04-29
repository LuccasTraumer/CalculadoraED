public class Expressao{

    private static Fila<Double> OPERANDOS;
    private static Fila<Object> ORDEM_CORRETA_EXPRESSAO;
    private static Operador SINAIS;

    public static double resolva(String strExp) throws Exception{
        PERCORRER_STRING(strExp);


    }

    public static double RESOLUCAO(Fila numero, Pilha operadores){
        double res = 0;
        while()

        return res;
    }
    public static void PERCORRER_STRING(String strExp) throws Exception{
        String exepressao = strExp.trim();
        String numero = "";
        Armazenar.size(strExp.length());
        for(int i=0; i <= exepressao.length()-1; i++){
            char numeroOuOperador = exepressao.charAt(i);
            if(E_UM_NUMERO(numeroOuOperador)){
                numero += numeroOuOperador+"";
                if(E_UM_NUMERO(numero) && i == exepressao.length()-1){
                    Armazenar.inserirNumero(converterCharToInt(numero));
                }
            }else{
               Armazenar.inserirNumero(converterCharToInt(numero));
               numero = "";
                SINAIS = new Operador<Character,Integer>(numeroOuOperador);
                  Armazenar.empilharOperadores(SINAIS);
            }
        }

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