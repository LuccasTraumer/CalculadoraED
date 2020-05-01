import java.lang.reflect.Method;

public class Fila<X> {
    private Object[] elementos;
    private int tamanho = -1;
    private int fim = -1;
    private int inicio = -1;

    public Fila(){
        tamanho = 10;
        elementos = new Object[tamanho];
    }
    public Fila(int tamanho){
        this.tamanho = tamanho;
        this.elementos = new Object[tamanho];
    }


    // Metodos Especificos da Fila
    public boolean estaCheio(){
        return fim == tamanho-1;
    }
    public boolean estaVazio(){
        return inicio == -1;
    }
    public void inserir(X elemento) throws Exception{
        if(!estaCheio()){
            if(fim == tamanho-1){
                fim = 0;
            }else{
                if(inicio == -1){
                    inicio++;
                }
                this.elementos[++fim] = elemento;
            }
        }else{
            throw new Exception("Fila esta cheia!");
        }
    }
    public X remover() throws Exception{
        X aux = null;
        if(!estaVazio()){
            aux = (X)this.elementos[inicio];
            this.elementos[inicio] = null;
            inicio++;
        }else{
            throw new Exception("Fila esta Vazia!");
        }
        return aux;
    }
    public X inicio() throws Exception{
        X aux = null;
        if(!estaVazio()){
            aux = (X)this.elementos[inicio];
        }else{
            throw new Exception("Fila vazia, não ha o que exibir!");
        }
        return aux;
    }

    public X meuCloneX(X x){
        X ret = null;

        try
        {
            Class<?> classe = x.getClass();
            // Class<?>[] tipoParms = null;
            Method metodo = classe.getMethod("clone", (Class<?>[])null); // no lugar de "(Class<?>[])null" pode ser tipoParms desde que a linha comentada acima tenha sido feita
            // Object[] parms = null;
            ret = (X)metodo.invoke(x, (Object[])null); // no lugar de "(Object[])null" pode ser parms desde que a linha comentada acima tenha sido feita
        }
        catch(Exception ex) {}

        return ret;
    }


    // GETTERS
    public int getFim() {
        return this.fim;
    }
    public int getInicio(){
        return this.inicio;
    }
    public int getTamanho(){
        return this.tamanho;
    }

    // Metodos Obrigatorios
    public Object clone(){
        Fila<X> ret = null;
        try{
            ret = new Fila<X>(this);
        }catch(Exception err){
            err.getMessage();
        }
        return ret;
    }
    public Fila(Fila<X> obj) throws Exception{
        if(obj == null)
            throw new Exception("Objeto vazio, não foi possivel clona-lo");

        this.inicio = obj.inicio;
        this.fim = obj.fim;
        this.tamanho = obj.tamanho;
        this.elementos = new Object[obj.elementos.length];

        for(int i=inicio; i < this.fim; i++){
            this.elementos[i] = obj.elementos[i];
        }

    }
    public String toString(){
        String ret = "";
        if(!estaVazio()){
            for(int i=inicio; i <= this.fim; i++){
                ret += this.elementos[i].toString();
            }
        }else{
            return "Nenhum elemento na Fila!";
        }
        return ret;
    }
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj.getClass() != this.getClass())
            return false;
        Fila<X> aux = (Fila<X>) obj;
        if(aux.getTamanho() != this.getTamanho())
            return false;
        if(aux.inicio != this.inicio)
            return false;
        if(aux.fim != this.fim)
            return false;
        for(int i = inicio; i <= aux.fim; i++){
            if(!aux.elementos[i].equals(this.elementos[i])){
                return false;
            }
        }
        return true;
    }
    public int hashCode(){
        int ret = 7;

        ret = ret * 11 + new Integer(tamanho).hashCode();
        ret = ret * 11 + new Integer(fim).hashCode();
        ret = ret * 11 + new Integer(inicio).hashCode();

        if(!estaVazio()) {
            for (int i = inicio; i < this.elementos.length - 1; i++) {
                ret = ret * 11 + this.elementos[i].hashCode();
            }
        }
        if(ret < 0)
            ret -= ret;

        return ret;
    }

}
