package singleton;

/**
 * Singleton "lazy holder"
 *
 * @see <a href="https://stackoverflow.com/a/24018148">Referencia</a>
 * @author JainyMartins
 *
 */
public class SingletonLazyHolder {
    //Encapsula instância em classe estática interna - HOLDER vamos criar classe dentro do singleton
    //Encapsula, é thread safe
    private static class InstanceHolder {
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();

    }

    private SingletonLazyHolder(){
        super();
    }

    public static SingletonLazyHolder getInstancia(){
        //Vai acessar instância pelo holder
        return InstanceHolder.instancia;
    }
}
