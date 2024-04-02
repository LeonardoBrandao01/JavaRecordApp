package javarecordscontrol;
public class Pilha<T> {
    private int topo;
    private T[] elementos;
    
    public Pilha(int tamanho){
          elementos =(T[]) new Object[tamanho];
          this.topo = -1;
    }
    public boolean isFull(){
        return topo==elementos.length-1;
        /*if(topo==elementos.length-1)
            return true;
        return false; */
    }
    public boolean isEmpty(){
        // return this.topo==-1;
        if(this.topo==-1)
            return true;
        return false;
    }
    
    public boolean push(T novoDado){
        if(!this.isFull()){
            if (topo == -1 || ((Recorde)novoDado).getTempo() < ((Recorde)elementos[topo]).getTempo()) {
                elementos[++topo] = novoDado;
                return true;
            } else {
                // Procura o índice onde o novo recorde deve ser inserido
                int indice = topo;
                while (indice >= 0 && ((Recorde)novoDado).getTempo() >= ((Recorde)elementos[indice]).getTempo()) {
                    indice--;
                }
                // Move os elementos para abrir espaço para o novo recorde
                for (int i = topo + 1; i > indice + 1; i--) {
                    elementos[i] = elementos[i - 1];
                }
                // Insere o novo recorde na posição correta
                elementos[indice + 1] = novoDado;
                topo++;
                return true;
            }
        }// fim if
        return false;
    }// fim push

    
    public T pop(){
        T retorno = elementos[topo];
        topo--;
        return retorno;
        //return elementos[topo--];
    }// fim pop
    public int size(){
        return topo+1;
    }
    
    public T peek(){
        return elementos[topo];
    }
    
    @Override
    public String toString(){
        StringBuilder retorno = new StringBuilder();
        for(int i=topo;i>=0;i--)
            retorno.append(elementos[i] + "\n");
        retorno.append("-----------");
        return retorno.toString();
    }
    
    public void clear(){
        topo = -1;
        //Arrys.fill(elementos, null);
    }
    
    
}
