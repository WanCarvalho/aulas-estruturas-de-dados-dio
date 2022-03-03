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
        return this.getNo(index).getConteudo();
    }

    //método usado para adicionar nó's na lista
    public void add(T elemento){
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(null);
        novoNo.setNoPrevio(ultimoNo);
        if (primeiroNo == null){
            primeiroNo = novoNo;
        }
        if (ultimoNo != null){
            ultimoNo.setNoProximo(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }

    //método add() com sobrecarga dos parâmetros de entrada, +index/índice
    public void add(int index, T elemento){
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliar);

        if (novoNo.getNoProximo() != null){
            novoNo.setNoProximo(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);
        }else{
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }

        if (index == 0){
            primeiroNo = novoNo;
        }else {
            novoNo.setNoProximo(novoNo);
        }
        tamanhoLista++;
    }

    //método remove() para remover nó utilizando o index/índice
    public void remove(int index){
        if (index == 0){
            primeiroNo = primeiroNo.getNoProximo();
            if (primeiroNo != null){
                primeiroNo.setNoPrevio(null);
            }
        }else{
            NoDuplo<T> noAuxiliar = getNo(index);
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
            if (noAuxiliar != ultimoNo){
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
            }else{
                ultimoNo = noAuxiliar;
            }
        }
        this.tamanhoLista--;
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
        return this.tamanhoLista;
    }

    //método que vai imprimir a lista duplamente encadeada
    @Override
    public String toString() {
        String strRetorno = "";

        NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0; i < size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]-->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        strRetorno+= "null";
        return strRetorno;
    }
}
