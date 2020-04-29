public class Armazenar {

    public static Fila<Integer> FILA_NUMEROS;
    public static Pilha<Operador> PILHA_OPERADORES = new Pilha<>();

    private static Fila<Object> FILA_EXPRESSAO_EM_ORDEM;

    public static void empilharOperadores(Operador sinal) throws Exception{
        if(sinal.getPrecedencia() < PILHA_OPERADORES.topo().getPrecedencia()){

        }
        PILHA_OPERADORES.empilhar(sinal);
    }
    public static void inserirNumero(Integer numero) throws Exception{
        FILA_NUMEROS.inserir(numero);
    }
    public static Operador removerOperador() throws Exception{
        return PILHA_OPERADORES.remover();
    }
    public static int removerNumero() throws Exception{
        return FILA_NUMEROS.remover();
    }

    public static void juntar(){
        while (FILA_NUMEROS.estaVazio()){

        }
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
