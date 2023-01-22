package singleton;

/**
 * Singleton "apressado"
 * @author JainyMartins
 *
 */
public class SingletonEager {
    //Em vez de fazer verificação, já atribui instância assim que
    //Variável é definida - em que classe for acionada por alguém
    //instância é atribuída e já estará pronta para ser retornada
    private static SingletonEager instancia = new SingletonEager();

    private SingletonEager(){
        super();
    }

    public static SingletonEager getInstancia(){
        return instancia;
    }
}
