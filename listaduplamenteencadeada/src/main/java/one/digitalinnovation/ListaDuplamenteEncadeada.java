package one.digitalinnovation;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista;

    //para todas as vezes que a classe for instanciada ela parte com os atributos nulos
    public ListaDuplamenteEncadeada(){
        primeiroNo = null;
        ultimoNo = null;
        this.tamanhoLista = 0;
    }

    //pega o conteudo do nó referente ao index/índice passado
    public T get(int index){
        return this.getNo(index);
    }

    //método usado para pegar valor do index/índice passado. o método pecorre a lista até chegar ao index/índice passado
    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAuxiliar = primeiroNo;

        for (int i =0; (i < index) && (noAuxiliar != null); i++){//diferente de nulo pois a refNo = nulo se refere ao ultimo nó da lista
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    //retorna tamanho da lista duplamente encadeada
    public int size(){
        return tamanhoLista;
    }

}
