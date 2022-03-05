package one.digitalinnovation;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    //construtor padrão
    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    //método add para adicionar novo Nó na lista circular
    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if (this.tamanhoLista == 0){
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProximo(cauda);
        }else{
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    //método remove para remover Nó da lista circular
    public void remove(int index){
        if (index >= this.tamanhoLista){
            throw new IndexOutOfBoundsException("O índice é maior que o tamanho da lista");
        }

        No<T> noAuxiliar = this.cauda;
        if (index == 0){
            this.cauda = this.cauda.getNoProximo();
            this.cabeca.setNoProximo(this.cauda);
        }else if(index == 1){
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        }else{
            for (int i = 0; i < index-1; i++){
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
        }
        this.tamanhoLista--;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    //método getNo para pegar Nó do index/índice referido
    private No<T> getNo(int index){
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException("A lista está vazia");
        }

        if (index == 0){
            return this.cauda;
        }

        No<T> noAuxiliar = this.cauda;
        for (int i = 0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    //método para testar se a lista está vazia
    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true : false;
    }

    //método que retorna o tamanho da lista
    public int size(){
        return this.tamanhoLista;
    }
}
