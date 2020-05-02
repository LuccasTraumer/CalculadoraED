public class MainTest {

    public static void main(String[] args) throws Exception{

    Expressao test = new Expressao();

    //(A^B*C-D+E/F/(G+H))
    // A=10; B=1; C=2; D=3; E=10; F= 5; G=2; H=6
    //(10^1*2-3+10/5/(2+6))
    // POS INFIXA = AB^C*D-EF/GH+/+
    // 101^2*3-105/26+/+
//    test.PERCORRER_STRING("(10^1*2-3+10/5/(2+6))");
//        //System.out.println(Armazenar.FILA_NUMEROS.toString());
//        //System.out.println(Armazenar.PILHA_OPERADORES.toString());
//        System.out.println(Armazenar.FILA_EXPRESSAO_EM_ORDEM.toString());
        System.out.println(Expressao.resolva("(10^1*2-3+10/5/(2+6))"));

    }
}

