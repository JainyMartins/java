package copiadora;

import copiadora.Copiadora;

public class Xerox implements Copiadora {
    @Override
    public void copiar(){
        System.out.println("COPIANDO!");
    }
}
