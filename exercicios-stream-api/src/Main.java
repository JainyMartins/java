import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6","5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
        numerosAleatorios.forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set: ");
        //Limit fala quantos quer pegar
        //Collect - pegue algo e colete para outro lugar
        //Set não aceita números repetidos
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        //Stream está retornando String - devolve corrente de objetos - dá acesso a vários métodos importantes
        //Map vai transformar lista de String em números inteiros - retorna Stream de Integer
        //Collect retorna lista de integer
        System.out.println("Transforme esta lista de String em uma lista de números inteiros: ");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //Pode colocar dentro de uma variável:
        List<Integer> collectList = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Pegue números pares maiores que 2 e coloque em uma lista: ");
//        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
//                .map(Integer::parseInt)
//                .filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer i) {
//                        if (i %2 == 0 && i > 2){
//                            return true;
//                        }
//                        return false;
//                    }
//                }).collect(Collectors.toList());
//        System.out.println(listParesMaioresQue2);
        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i %2 == 0 && i > 2).collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);

        //Vai transformar em int e usar average que retorna optional - precisa de função - pode lidar com null
        System.out.println("Mostre a média dos números: ");
//        numerosAleatorios.stream()
//                .mapToInt(new ToIntFunction<String>() {
//                    @Override
//                    public int applyAsInt(String s) {
//                        return Integer.parseInt(s);
//                    }
//                });
        //Se der certo retorna valor (ifPresent), senão não retorna nada
//        numerosAleatorios.stream()
//                .mapToInt(Integer::parseInt)
//                .average()
//                .ifPresent(new DoubleConsumer() {
//                    @Override
//                    public void accept(double value) {
//                        System.out.println(value);
//                    }
//                });
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        //Tem que trabalhar com lista de Integer
        //Precisa de um predicate igual o filter (que conterá condição)
        System.out.println("Remova os valores ímpares: ");
        List<Integer> listaAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//        listaAleatoriosInteger.removeIf(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                if(integer %2 !=0) return true;
//                return false;
//            }
//        });
//        System.out.println(listaAleatoriosInteger);
        listaAleatoriosInteger.removeIf(i -> i %2 !=0);
        System.out.println(listaAleatoriosInteger);
    }
}
//Existem operações terminais (só pode usar uma - retorna ou objeto, ou valor) e intermediárias (pode colocar várias operações intermediárias)
//Foreach é operação final