public class Armazenar {

    public static Fila<Integer> FILA_NUMEROS;
    public static Pilha<Operador> PILHA_OPERADORES = new Pilha<>();

    public  static Fila<Object> FILA_EXPRESSAO_EM_ORDEM;

    public static void empilharOperadores(Operador sinal) throws Exception{
        if(sinal.getSinal() == Operador.PARENTESE_ABERTURA){
            PILHA_OPERADORES.empilhar(sinal);
            return;
        }
        if(PILHA_OPERADORES.estaVazio()){
            PILHA_OPERADORES.empilhar(sinal);
            return;
        }
        if(sinal.getSinal() == Operador.PARENTESE_FECHADURA){
            while(PILHA_OPERADORES.topo().getSinal() != Operador.PARENTESE_ABERTURA){
                FILA_EXPRESSAO_EM_ORDEM.inserir(PILHA_OPERADORES.remover());
            }
            PILHA_OPERADORES.remover();
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

    protected static void verificarParentese() throws Exception{
        boolean existeParentese = false;
        Pilha<Operador> clone = new Pilha<>(PILHA_OPERADORES);
        Pilha<Operador> aux = new Pilha<>(clone.getTamanho());
        while(clone.estaVazio()){
            if(clone.topo().getSinal() == Operador.PARENTESE_ABERTURA ){
                existeParentese = true;
            }
        }
        inserirOperadores(existeParentese);
    }
    private static void inserirOperadores(boolean existeParentes) throws Exception{
        if(!existeParentes){
            while (!PILHA_OPERADORES.estaVazio()){
                FILA_EXPRESSAO_EM_ORDEM.inserir(PILHA_OPERADORES.remover());
            }
        }
    }

    private static Fila<Object> removeParentese() throws Exception{
        Fila<Object> clone = new Fila<>(Armazenar.FILA_EXPRESSAO_EM_ORDEM);
        Fila<Object> aux = new Fila<>(clone.getTamanho());
        while(!clone.estaVazio()){
            if(!clone.inicio().equals(Operador.PARENTESE_ABERTURA)|| !clone.inicio().equals(Operador.PARENTESE_FECHADURA)){
                aux.inserir(clone.remover());
            }
        }
        FILA_EXPRESSAO_EM_ORDEM = aux;
        return FILA_EXPRESSAO_EM_ORDEM;
    }
    private static void temSinal() throws Exception{
        Fila<Object> aux = new Fila<>(FILA_EXPRESSAO_EM_ORDEM);

        boolean temAlgumSinal = false;
        for(int i= FILA_EXPRESSAO_EM_ORDEM.getInicio(); i < FILA_EXPRESSAO_EM_ORDEM.getFim(); i++){
            if(aux.inicio() instanceof Operador){
                temAlgumSinal = true;
                break;
            }
            aux.remover();
        }
        while(!PILHA_OPERADORES.estaVazio() || !temAlgumSinal){
            FILA_EXPRESSAO_EM_ORDEM.inserir(PILHA_OPERADORES.remover());
            if(PILHA_OPERADORES.estaVazio()){
                temAlgumSinal = true;
            }
        }
    }
    public static void inserirNumero(Integer numero) throws Exception{
        //FILA_NUMEROS.inserir(numero);
        FILA_EXPRESSAO_EM_ORDEM.inserir(numero);
    }
    public static Operador removerOperador() throws Exception{
        return PILHA_OPERADORES.remover();
    }
    public static int removerNumero() throws Exception{
        return FILA_NUMEROS.remover();
    }


    public final static void size(int length) {
        FILA_NUMEROS =  new Fila<>(length);
        PILHA_OPERADORES = new Pilha<>(length);
        FILA_EXPRESSAO_EM_ORDEM = new Fila<>(length);
    }
    private static void percorrerFilaNumero() throws Exception{
        while (!FILA_NUMEROS.estaVazio()){
            inserirExpressaoOrdenada(FILA_NUMEROS.remover());
        }
    }
    private static void percorrerPilhaOperadores() throws Exception{
        while(!PILHA_OPERADORES.estaVazio()){
            inserirExpressaoOrdenada(PILHA_OPERADORES.remover());
        }
    }
    private static void inserirExpressaoOrdenada(Integer numero) throws Exception{
        FILA_EXPRESSAO_EM_ORDEM.inserir(FILA_NUMEROS.remover());
    }
    private static void inserirExpressaoOrdenada(Operador sinal) throws Exception{
        FILA_EXPRESSAO_EM_ORDEM.inserir(sinal);
    }
}
