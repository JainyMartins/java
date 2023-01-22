package singleton;

/**
 * Singleton "preguiçoso"
 * @author JainyMartins
 *
 */
public class SingletonLazy {
    private static SingletonLazy instancia;

    //Garantir que ninguém externamente vai conseguir instanciar objeto
    private SingletonLazy() {
        super();
    }

    //Método para expor de maneira pública
    public static SingletonLazy getInstancia(){
        //Não está preparada para ser retornada, tem que ser instanciada
        if (instancia == null){
            instancia = new SingletonLazy();
        }
        return instancia;
    }
}
