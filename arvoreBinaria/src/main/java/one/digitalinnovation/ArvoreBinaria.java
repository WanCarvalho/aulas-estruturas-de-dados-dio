package one.digitalinnovation;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    //método público sobrecarregado que vai chamar o método inserir() de baixo
    public void inserir(T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo){

        if (atual == null){
            return novoNo;
        }else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0){
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        }else{
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));
        }
        return atual;
    }

    //exibe em ordem crescente em relação a todos os Nó's da árvore
    public void exibirInOrdem(){
        System.out.println("\n Exibindo em ordem");
        exibirInOrdem(this.raiz);
    }

    private void exibirInOrdem(BinNo<T> atual){
        if (atual != null){
            exibirInOrdem(atual.getNoEsq());
            System.out.println(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDir());
        }
    }

    //visita primeiro para depois exibir, vai exibindo os Nó's mais abaixo priorizando os da esquerda e terminando exibindo as raízes
    public void exibirPosOrdem(){
        System.out.println("\n Exibindo pós ordem");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(BinNo<T> atual){
        if (atual != null){
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.println(atual.getConteudo() + ", ");
        }
    }

    //
    public void exibirPreOrdem(){
        System.out.println("\n Exibindo pré ordem");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPreOrdem(BinNo<T> atual){
        if (atual != null){
            System.out.println(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());
        }
    }

}
