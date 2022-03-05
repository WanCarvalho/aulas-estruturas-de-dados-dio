package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {

        ListaCircular<String> minhaListaCircular = new ListaCircular<>();

        minhaListaCircular.add("c0");
        System.out.println(minhaListaCircular);

        minhaListaCircular.remove(0);
        System.out.println(minhaListaCircular);

        minhaListaCircular.add("c1");
        System.out.println(minhaListaCircular);

        minhaListaCircular.add("c2");
        minhaListaCircular.add("c3");
        System.out.println(minhaListaCircular);

        System.out.println(minhaListaCircular.get(0));
        System.out.println(minhaListaCircular.get(1));
        System.out.println(minhaListaCircular.get(2));

        //não possui o índice 3 nesse ponto da lista, porém por se tratar de uma lista circular ela retorna o elemento da cauda
        System.out.println(minhaListaCircular.get(3));

        //para mostrar a lista se repetindo por se tratar de uma lista circular
        System.out.println("Repetição da lista circular");
        for (int i = 0; i < 10; i++) {
            System.out.println(minhaListaCircular.get(i));
        }
    }
}
