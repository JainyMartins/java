public class No <T> {
    //Todos os objetos do Java herdam do Object - pode colocar qualquer objeto, é conteúdo do nó
    private T object;
    private No<T> refNo;

    public No(T object){
        this.refNo = null;
        this.object = object;
    }

    public No(){
    }

    public Object getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public No getRefNo() {
        return refNo;
    }

    public void setRefNo(No refNo) {
        this.refNo = refNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "object=" + object +
                '}';
    }
}
