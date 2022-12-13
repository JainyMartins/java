import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Carro> queueCarro = new LinkedList<>();

        queueCarro.add(new Carro("Ford"));
        queueCarro.add(new Carro("Chevrolet"));
        queueCarro.add(new Carro("Fiat"));

        System.out.println(queueCarro.add(new Carro("Peugeot")));
        System.out.println(queueCarro);

        //Retorna falso se não conseguir executar - parecido com add, mas add dá erro, o offer só retorna falso se não conseguir
        System.out.println(queueCarro.offer(new Carro("Renault")));
        System.out.println(queueCarro);

        //Pega primeiro elemento da fila, mas não remove
        System.out.println(queueCarro.peek());
        System.out.println(queueCarro);

        //Remove primeiro da fila
        System.out.println(queueCarro.poll());
        System.out.println(queueCarro);

        System.out.println(queueCarro.isEmpty());

        //Para saber tamanho da fila
        System.out.println(queueCarro.size());

    }
}