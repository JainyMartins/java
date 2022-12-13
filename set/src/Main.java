import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        //Aqui criamos um conjunto de carros
        Set<Carro> hashSetCarros = new HashSet<>();
        hashSetCarros.add(new Carro("Ford"));
        hashSetCarros.add(new Carro("Chevrolet"));
        hashSetCarros.add(new Carro("Fiat"));
        hashSetCarros.add(new Carro("Peugeot"));
        hashSetCarros.add(new Carro("Zip"));
        hashSetCarros.add(new Carro("Alfa Romeo"));

        //Set não preserva ordem de inserção
        System.out.println(hashSetCarros);

        //Vamos implementar uma árvore - temos que ter parâmetro de comparação
        //Temos que ter o CompareTo - que fizemos em Carro, comparando pelo tamanho das strings ou pela ordem alfabética
        //Se precisa de estrutura ordenada faz esse compareTo de acordo com o que quer
        Set<Carro> treeSetCarros = new TreeSet<>();
        treeSetCarros.add(new Carro("Ford"));
        treeSetCarros.add(new Carro("Chevrolet"));
        treeSetCarros.add(new Carro("Fiat"));
        treeSetCarros.add(new Carro("Peugeot"));
        treeSetCarros.add(new Carro("Zip"));
        treeSetCarros.add(new Carro("Alfa Romeo"));

        System.out.println(treeSetCarros);
    }
}