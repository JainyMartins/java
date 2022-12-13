import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Gato> listaGatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "Preto"));
            add(new Gato("Simba", 6, "Tigrado"));
            add(new Gato("Jon", 12, "Amarelo"));
        }};
        //Para exibir tudo tem que ter o toString implementado
        System.out.println("Por ordem de inserção: " + listaGatos);

        //Usa Collections shuffle para aleatorizar
        System.out.println("Por ordem Aleatória: ");
        Collections.shuffle(listaGatos);
        System.out.println(listaGatos);

        //Vamos ter de add o Comparable, após ter add o Collections.sort pega o comparable
        System.out.println("Por ordem Natural (Nome): ");
        Collections.sort(listaGatos);
        System.out.println(listaGatos);

        System.out.println("Por ordem Idade: ");
        //Pode passar um comparator dessa forma
        Collections.sort(listaGatos, new ComparatorIdade());
//        Ou dessa
//        listaGatos.sort(new ComparatorIdade());
        System.out.println(listaGatos);

        System.out.println("Por ordem Cor: ");
        listaGatos.sort(new ComparatorCor());
        System.out.println(listaGatos);

        //Primeiro vai olhar nome, depois cor e depois idade
        System.out.println("Por Nome/Cor/Idade");
        listaGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(listaGatos);

    }
}

class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    //Comparação por nome
    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2){
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2){
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2){
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;
        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor;
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }

}