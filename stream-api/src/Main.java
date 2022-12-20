import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("--\tOrdem Aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<Integer, Contato>(){{
            put(1, new Contato("Simba", 5555));
            put(2, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda);
        for(Map.Entry<Integer, Contato> entry : agenda.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<Integer, Contato>(){{
            put(1, new Contato("Simba", 5555));
            put(2, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda1);
        for (Map.Entry<Integer, Contato> entry : agenda1.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem Id\t--");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        System.out.println(agenda2);
        for(Map.Entry<Integer, Contato> entry : agenda2.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem Número Telefone\t--");
        //Usando CLASSE ANÔNIMA
//        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
//                return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
//            }
//        });
        //Usando INTERFACE FUNCIONAL - Comparator.comparing - usa função
//        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
//                new Function<Map.Entry<Integer,Contato>, Integer>() {
//                    @Override
//                    public Integer apply(Map.Entry<Integer, Contato> cont) {
//                        return cont.getValue().getNumero();
//                    }
//                }));
        //Usando LÂMBDA - não consegue simplificar mais com reference method
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNumero()));
        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : set){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem Nome Contato\t--");
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(cont2 -> cont2.getValue().getNome()));
        set1.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : set1){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

    }
}