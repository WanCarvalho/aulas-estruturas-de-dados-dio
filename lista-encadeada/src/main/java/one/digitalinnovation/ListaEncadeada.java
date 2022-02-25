package one.digitalinnovation;

public class ListaEncadeada<T> {

    No<T> refEntrada;

    //construtor padrão
    public ListaEncadeada() {
        this.refEntrada = null;
    }

    //método size
    public int size(){
        int tamanhoLista = 0;
        No<T> refAux = refEntrada;

        while (true){
            if (refAux != null){
                tamanhoLista++;
                if (refAux.getProximoNo() != null){
                    refAux = refAux.getProximoNo();
                }else{
                    break;
                }
            }else {
                break;
            }
        }

        return tamanhoLista;
    }

    //método isEmpty
    public boolean isEmpty(){
        return refEntrada == null ? true : false;
    }
}
