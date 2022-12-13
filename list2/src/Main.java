import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Formas de criar lista:
        //Antes não existia generics
        List notas = new ArrayList<>();
        //A partir Java 7 com Generics
        List<Double> notas2 = new ArrayList<>();
        //Não recomendado
        ArrayList<Double> notas3 = new ArrayList<>();
        //Dessa forma já coloca o conteúdo
        List<Double> notas4 = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 8d, 3.6));
        //Dessa forma não pode tirar ou add elementos
        List<Double> notas5 = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 8d, 3.6);
        //Não pode tirar nem add, é imutável
        List<Double> notas6 = List.of(7d, 8.5, 9.3, 5d, 7d, 8d, 3.6);


        List<Double> notas7 = new ArrayList<>();
        //Existem também várias formas de add
        notas7.add(7.0);
        notas7.add(8.5);
        notas7.add(9.3);
        notas7.add(5.0);
        notas7.add(7.0);
        notas7.add(0.0);
        notas7.add(3.6);
        System.out.println(notas7.toString());

        System.out.println("Posição da nota 5.0: " + notas7.indexOf(5d));
        notas7.add(4, 8.0);
        System.out.println("Adicione na lista a nota 8.0 na posição 4: " + notas7.get(4));
        notas7.set(3, 6.0);
        System.out.println("Substitua a nota 5.0 pela nota 6.0: " + notas7.get(3));
        System.out.println("Conferir se nota 5.0 está na lista: " + notas7.contains(5.0));
        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
        for (Double nota : notas7) System.out.println(nota);

        System.out.println("Exiba a terceira nota adicionada: " + notas7.get(2));

        //Aqui podemos usar método min de Collections passando a lista, Double tem Comparable
        System.out.println("Exiba a menor nota: " + Collections.min(notas7));
        System.out.println("Exiba a maior nota: " + Collections.max(notas7));

        System.out.println("Exiba a soma dos valores: ");
        Double somaNotas = 0d;
        for (Double nota : notas7){
            somaNotas += nota;
        }
        System.out.println(somaNotas);
        //OU
        Double somaNotas2 = 0d;
        Iterator<Double> iterator = notas7.iterator();
        while(iterator.hasNext()){
            Double next = iterator.next();
            somaNotas2 += next;
        }
        System.out.println(somaNotas2);

        System.out.println("Exiba a média das notas: " + somaNotas / notas7.size());

        //Pode passar posição ou objeto
        notas7.remove(0d);
        System.out.println("Remova a nota 0: " + notas7.get(6));

        notas7.remove(0);
        System.out.println("Remova a nota da posição 0: " + notas7.get(0));

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas7.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas7);

        System.out.println("Apague toda a lista");
        notas7.clear();
        System.out.println(notas7);

        System.out.println("Confira se a lista está vazia: " + notas7.isEmpty());
    }
}