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
        //Ao indicar o 3 voltou pro loop contínuo - vai ficar repetindo
        System.out.println(minhaListaCircular.get(3));
        System.out.println(minhaListaCircular.get(4));

        //Sempre vai entrando na cauda e indo até a cabeça
        for (int i = 0; i < 20; i++){
            System.out.println(minhaListaCircular.get(i));
        }
    }
}