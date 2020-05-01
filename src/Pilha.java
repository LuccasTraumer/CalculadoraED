import java.lang.reflect.Method;

public class Pilha<X> {
    //Atributos
    private Object[] elementos;
    private int tamanho = -1;
    private int index = -1;

    public Pilha(){
        tamanho = 10;
        elementos = new Object[tamanho];
    }
    public Pilha(int tamanho){
        this.tamanho = tamanho;
        this.elementos = new Object[tamanho];

    }


   // Metodos Especificos da Pilha
    public void empilhar(X elemento) throws Exception{
        if(!estaCheio()) {
            this.elementos[++index] = elemento;
        }else{
            throw new Exception("Pilha encheu!");
        }
   }
    public X remover() throws Exception{
        X aux = null;
        if(!estaVazio()){
            aux  = (X)this.elementos[index];
            this.elementos[index] = null;
            index--;
        }else{
            throw new Exception("Pilha está Vazia!");
        }
        return aux;
    }
    public X topo(){
        return (X)this.elementos[index];
    }
    public boolean estaCheio(){
        return index == tamanho-1;
    }
    public boolean estaVazio(){
        return elementos == null || index == -1;
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
    public int getIndex() {
        return this.index;
    }
    public int getTamanho(){
        return this.tamanho;
    }

    // Metodos Obrigatorios
    public Object clone(){
        Pilha<X> ret = null;
        try{
            ret = new Pilha<X>(this);
        }catch(Exception err){
            err.getMessage();
        }
        return ret;
    }
    public Pilha(Pilha<X> obj) throws Exception{
        if(obj == null)
            throw new Exception("Objeto vazio, não foi possivel clona-lo");

        this.index = obj.index;
        this.tamanho = obj.tamanho;
        this.elementos = new Object[obj.elementos.length];

        for(int i=0; i < this.index; i++){
            this.elementos[i] = obj.elementos[i];
        }

    }
    public String toString(){
        String ret = "";
        if(!estaVazio()){
            for(int i=0; i <= this.index; i++){
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
        Pilha<X> aux = (Pilha<X>) obj;
        if(aux.getTamanho() != this.getTamanho())
            return false;
        if(aux.getIndex() != this.getIndex())
            return false;
        if(aux.topo() != this.topo())
            return false;
        for(int i = 0; i <= aux.getIndex(); i++){
            if(!aux.elementos[i].equals(this.elementos[i])){
                return false;
            }
        }
        return true;
    }
    public int hashCode(){
        int ret = 7;

        ret = ret * 11 + new Integer(tamanho).hashCode();
        ret = ret * 11 + new Integer(index).hashCode();

        if(!estaVazio()) {
            for (int i = 0; i < this.elementos.length - 1; i++) {
                ret = ret * 11 + this.elementos[i].hashCode();
            }
        }
        if(ret < 0)
            ret -= ret;

        return ret;
    }

}
