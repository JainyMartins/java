import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Carro> listaCarros = new ArrayList<>();
        listaCarros.add(new Carro("Ford"));
        listaCarros.add(new Carro("Chevrolet"));
        listaCarros.add(new Carro("Volkswagen"));

        //Usa equals para ver se existe esse objeto dentro da lista
        System.out.println(listaCarros.contains(new Carro("Ford")));

        //Aqui vemos hashcode do carro da marca Ford
        System.out.println(new Carro("Ford").hashCode());

        //Aqui vemos hashcode diferente se mudarmos marca
        System.out.println(new Carro("Ford1").hashCode());

        Carro carro1 = new Carro("Ford");
        Carro carro2 = new Carro("Ford");

        //Aqui vemos que comparou se objetos são iguais, e nesse caso são
        System.out.println(carro1.equals(carro2));

    }
}