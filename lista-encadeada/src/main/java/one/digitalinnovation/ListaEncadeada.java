package one.digitalinnovation;

public class ListaEncadeada<T> {

    No<T> refEntrada;

    //construtor padrão
    public ListaEncadeada() {
        this.refEntrada = null;
    }

    //método add: usado para adicionar novo Nó na lista
    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if (this.isEmpty()){
            refEntrada = novoNo;
            return;
        }

        No<T> noAux = refEntrada;
        for (int i = 0; i < this.size()-1; i++){
            noAux = noAux.getProximoNo();
        }
        noAux.setProximoNo(novoNo);
    }

    //método get: utilizado para pegar o conteudo de um índice referenciado
    public T get(int index){
        return getNo(index).getConteudo();
    }

    //método getNo: utilizado internamente na classe para obter dado referente a um índice da lista
    private No<T> getNo(int index){
        validaindice(index);

        No<T> noAuxiliar = refEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i < this.size()-1; i++){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    //método remove: para remover um elemento da lista
    public T remove(int index){
        No<T> noPivor = this.getNo(index);

        if (index == 0){
            refEntrada = noPivor.getProximoNo();
            return noPivor.getConteudo();
        }

        No<T> noAnterior = getNo(index - 1);
        noAnterior.setProximoNo(noPivor.getProximoNo());
        return noPivor.getConteudo();
    }

    //método size: para contar tamanho da lista
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

    //validação que serve para dizer se há dado no índice referido
    private void validaindice(int index){
        if (index >= size()){
            int ultimoIndice = size() -1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice" + index + " desta lista. Só vai até o índice " + ultimoIndice + '.');
        }
    }

    //método isEmpty: para verificar se a lista está vazia
    public boolean isEmpty(){
        return refEntrada == null ? true : false;
    }
}
