import facade.Facade;
import singleton.SingletonEager;
import singleton.SingletonLazy;
import singleton.SingletonLazyHolder;
import strategy.*;

public class Test {
    public static void main(String[] args) {
        //Testes relacionados ao Design Pattern Singleton

        //Não pode dar new, só pegar instância
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        //Aqui deve ser a mesma instância
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        //Aqui deve ser a mesma instância
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);
        //Aqui deve ser a mesma instância
        lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);

        //Testes relacionados ao Design Pattern Strategy

        //Temos 1 instância de cada comportamento possível do robô
        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);
        //Robô vai mover normalmente
        robo.mover();
        robo.mover();
        robo.setComportamento(agressivo);
        robo.mover();
        robo.mover();
        robo.mover();
        robo.setComportamento(defensivo);
        robo.mover();
        //Vai conseguir se mover de formas diferentes porque tem diferentes implementações do strategy (comportamento)
        //Porque definimos padrão de strategy para que fosse possível outros comportamentos
        //Como robô ter interface como atributo ele pode usar qualquer implementação dela - conceito também de polimorfismo

        //Testes relacionados ao Design Pattern Facade

        Facade facade = new Facade();
        facade.migrarCliente("Jainy", "35500134");

    }
}