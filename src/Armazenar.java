/**
 * creted by: Lucas Jesus
 * Date: 01/05/2020
 * repository: https://github.com/LuccasTraumer/CalculadoraED
 * */
public class Armazenar {

    /**
     * Pilha que vai armazenar os Operadores
     * */
    protected static Pilha<Operador> PILHA_OPERADORES = new Pilha<>();
    /**
     * Fila que vai armazenar a Expressão infixa
     * */
    protected  static Fila<Object> FILA_EXPRESSAO_EM_ORDEM;
    /**
     * Metodo que faz a comparacão de Precedencia
     * */
    protected static void empilharOperadores(Operador sinal) throws Exception{
        if(sinal.getSinal() == Operador.PARENTESE_ABERTURA){
            PILHA_OPERADORES.empilhar(sinal);
            return;
        }
        if(PILHA_OPERADORES.estaVazio()){
            PILHA_OPERADORES.empilhar(sinal);
            return;
        }
        if(sinal.getSinal() == Operador.PARENTESE_FECHADURA){
            removeParentese();
            return;
        }
        // Se sinal_precedencia for menor que Pilha_topo EE pilha_topo.sinal for diferente Parent_Abertura; INSERIR NA FILA E INSERIR SINAL NA PILHA
        if(sinal.getPrecedencia() < PILHA_OPERADORES.topo().getPrecedencia()
                && PILHA_OPERADORES.topo().getSinal() != Operador.PARENTESE_ABERTURA){
            FILA_EXPRESSAO_EM_ORDEM.inserir(PILHA_OPERADORES.remover());
            PILHA_OPERADORES.empilhar(sinal);
            return;
        }
        // Se sinal_precedencia for menor que pilha_topo EE pilha_topo.sinal for igual parent_Abertura; INSERIR NA PILHA
        if(sinal.getPrecedencia() < PILHA_OPERADORES.topo().getPrecedencia()
                && PILHA_OPERADORES.topo().getSinal() == Operador.PARENTESE_ABERTURA){
            PILHA_OPERADORES.empilhar(sinal);
            return;
        }
        // Se sinal_precedencia for igual a pilha_topo EE sinal_operador for diferente parent_Abertura OU sinal_operador for diferente de parent_fechadura;
        // INSERIR NA FILA E INSERIR NA PILHA
        if(sinal.getPrecedencia() == PILHA_OPERADORES.topo().getPrecedencia()
                && sinal.getSinal() != Operador.PARENTESE_ABERTURA){
            FILA_EXPRESSAO_EM_ORDEM.inserir(PILHA_OPERADORES.remover());
            PILHA_OPERADORES.empilhar(sinal);
            return;
        }
        //Se sinal_precedencia for maior que pilha.topo EE sinal_operador for diferente de parent_fechadura; INSERIR NA PILHA
        if(sinal.getPrecedencia() > PILHA_OPERADORES.topo().getPrecedencia()
                && sinal.getSinal() != Operador.PARENTESE_FECHADURA){
            PILHA_OPERADORES.empilhar(sinal);
            return;
        }
        // Se sinal_precedencia for menor que topo_precedencia; INSERIR NA PILHA
        if(sinal.getPrecedencia() < PILHA_OPERADORES.topo().getPrecedencia()){
            PILHA_OPERADORES.empilhar(sinal);
            return;
        }

    }
    /**
     * Caso a Expressão não tenha parentese
     * */
    protected static void verificarParentese() throws Exception{
        boolean existeParentese = false;
        Pilha<Operador> clone = new Pilha<>(PILHA_OPERADORES);
        while(!clone.estaVazio()){
            if(clone.topo().getSinal() == Operador.PARENTESE_ABERTURA ){
                existeParentese = true;
                return;
            }
        }
        inserirOperadores(existeParentese);
    }
    /**
     * Caso não tenha parentese, insere na Fila infixa
     * */
    private static void inserirOperadores(boolean existeParentes) throws Exception{
        if(!existeParentes){
            while (!PILHA_OPERADORES.estaVazio()){
                FILA_EXPRESSAO_EM_ORDEM.inserir(PILHA_OPERADORES.remover());
            }
        }
    }
    /**
     * Caso tenha parente de abertura comeca a retirar os Operadores, até que feche os Parenteses
     * */
    private static void removeParentese() throws Exception{
        while(PILHA_OPERADORES.topo().getSinal() != Operador.PARENTESE_ABERTURA){
            FILA_EXPRESSAO_EM_ORDEM.inserir(PILHA_OPERADORES.remover());
        }
        PILHA_OPERADORES.remover();
    }
    /**
     * Verifica se a Pilha de Operadores esta Vazia, caso não esteja insere na Fila
     * */
    protected static void temSinal() throws Exception{
        while(!PILHA_OPERADORES.estaVazio()){
            FILA_EXPRESSAO_EM_ORDEM.inserir(PILHA_OPERADORES.remover());
        }
    }
    /**
     * Insere numero na Fila de Expressão
     * */
    public static void inserirNumero(Double numero) throws Exception{
        FILA_EXPRESSAO_EM_ORDEM.inserir(numero);
    }
    /**
     * Instancia a Fila e Pilha, para armazenar os valores
     * */
    public final static void size(int length) {
        PILHA_OPERADORES = new Pilha<>(length);
        FILA_EXPRESSAO_EM_ORDEM = new Fila<>(length);
    }
}
