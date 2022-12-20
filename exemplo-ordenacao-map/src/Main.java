import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--\tOrdem Aleatória\t--");
        //HashMap
        Map<String, Livro> meusLivros = new HashMap<String, Livro>(){{
            put(" Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put(" Duhigg, Charles", new Livro("O Poder do Hábito", 400));
            put(" Harari, Yuval Noah", new Livro("21 Lições para o Século 21", 432));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("--\tOrdem de Inserção\t--");
        //LinkedHashMap
        Map<String, Livro> meusLivros2 = new LinkedHashMap<String, Livro>(){{
            put(" Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put(" Duhigg, Charles", new Livro("O Poder do Hábito", 400));
            put(" Harari, Yuval Noah", new Livro("21 Lições para o Século 21", 432));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros2.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("--\tOrdem Alfabética Autores\t--");
        //TreeMap
        Map<String, Livro> meusLivros3 = new TreeMap<String, Livro>(){{
            put(" Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put(" Duhigg, Charles", new Livro("O Poder do Hábito", 400));
            put(" Harari, Yuval Noah", new Livro("21 Lições para o Século 21", 432));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros3.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("--\tOrdem Alfabética Nomes dos Livros\t--");
        //Trabalhar com TreeSet porque precisa de Comparator
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros4)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem por Número de Páginas\t--");
        Set<Map.Entry<String, Livro>> meusLivros5 = new TreeSet<>(new ComparatorPagina());
        meusLivros5.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros5)
            System.out.println(livro.getKey() + " - " + livro.getValue().getPaginas());

    }
}
class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPagina implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return Integer.compare(l1.getValue().getPaginas(), l2.getValue().getPaginas());
    }
}