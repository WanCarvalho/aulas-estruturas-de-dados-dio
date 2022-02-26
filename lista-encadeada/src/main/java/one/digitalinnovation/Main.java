package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {

        ListaEncadeada<String> minhaListaEncadeada = new ListaEncadeada<>();

        //método add() adicionando dados à lista
        minhaListaEncadeada.add("teste1");
        minhaListaEncadeada.add("teste2");
        minhaListaEncadeada.add("teste3");
        minhaListaEncadeada.add("teste4");
        //Imprimindo elementos da lista de acordo com seus índices
        System.out.println(minhaListaEncadeada.get(0));
        System.out.println(minhaListaEncadeada.get(1));
        System.out.println(minhaListaEncadeada.get(2));
        System.out.println(minhaListaEncadeada.get(3));

        //imprimindo lista inteira
        System.out.println(minhaListaEncadeada);

        //método remove() retirando nó de índice 3
        System.out.println(minhaListaEncadeada.remove(3));
        System.out.println(minhaListaEncadeada);
    }
}
