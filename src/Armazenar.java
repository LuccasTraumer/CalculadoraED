public class Armazenar {

    protected static Pilha<Operador> PILHA_OPERADORES = new Pilha<>();

    protected  static Fila<Object> FILA_EXPRESSAO_EM_ORDEM;

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
        while(!clone.estaVazio()){
            if(clone.topo().getSinal() == Operador.PARENTESE_ABERTURA ){
                existeParentese = true;
                return;
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
    protected static void temSinal() throws Exception{
        while(!PILHA_OPERADORES.estaVazio()){
            FILA_EXPRESSAO_EM_ORDEM.inserir(PILHA_OPERADORES.remover());
        }
    }
    public static void inserirNumero(Integer numero) throws Exception{
        FILA_EXPRESSAO_EM_ORDEM.inserir(numero);
    }
    public final static void size(int length) {
        PILHA_OPERADORES = new Pilha<>(length);
        FILA_EXPRESSAO_EM_ORDEM = new Fila<>(length);
    }
}
