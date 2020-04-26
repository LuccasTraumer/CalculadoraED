public class Pilha<X> {
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
    public void empilhar(X elemento){
        this.elementos[++index] = elemento;
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
    public boolean estaCheio(){
        return elementos.length == tamanho;
    }
    public boolean estaVazio(){
        return elementos == null || elementos.length < 0;
    }
    public String toString(){

    }
}
