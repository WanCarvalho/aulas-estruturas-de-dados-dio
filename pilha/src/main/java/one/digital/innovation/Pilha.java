package one.digital.innovation;

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    //metodo que adiciona elemento na pilha e atribui a referencia de topo da pilha ao mesmo
    public void push(No novoNo){
        No refAuxiliar = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setRefNo(refAuxiliar);
    }


    public No pop(){

        if(!this.isEmpty()){

            No noPoped = refNoEntradaPilha; //guarda valor de ref do nó que está sendo pego

            refNoEntradaPilha = refNoEntradaPilha.getRefNo(); //diz que a ref de entrada é o nó que esta abaixo do nó
            // que esta sendo pego pelo metodo pop()

            return noPoped;
        }
        return null;

    }

    //metodo para mostrar No que está referido como topo da pilha
    public No top(){
        return refNoEntradaPilha;
    }

    //metodo para mostrar se a pilha está vazia
    public boolean isEmpty() {

       /* if(refNoEntradaPilha == null){
           return true;
        }
       return false;
       }*/

        return refNoEntradaPilha == null ? true : false; //forma simplificada do código comentado acima

    }
}
