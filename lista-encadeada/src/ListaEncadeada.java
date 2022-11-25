import javax.naming.NoPermissionException;

public class ListaEncadeada <T> {
    No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(this.isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }

        No<T> noAuxiliar = referenciaEntrada;
        for (int i = 0; i < this.size()-1; i++){
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        noAuxiliar.setProximoNo(novoNo);
    }

    private No<T> getNo(int index){
        validaIndice(index);

        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;
        for (int i = 0; i <= index; i++){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    public void validaIndice(int index){
        if(index >= size()){
            int ultimoIndice = size()-1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " +index + " desta lista. Esta lista só vai até o índice " + ultimoIndice + ".");
        }
    }

    public boolean isEmpty(){
        return referenciaEntrada == null ? true : false;
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }


    //Retorna tamanho da lista
    public int size(){
        int tamanhoLista = 0;
        No<T> referenciaAux = referenciaEntrada;
        while (true){
            if(referenciaAux != null){
                tamanhoLista++;
                if(referenciaAux.getProximoNo() != null){
                    referenciaAux = referenciaAux.getProximoNo();
                } else{
                    break;
                }
            } else{
                break;
            }
        }
        return tamanhoLista;
    }

    public T remove(int index){
        No<T> noPivot = this.getNo(index);
        //Referencia entrada vai apontar para próximo nó
        if(index == 0){
            referenciaEntrada = noPivot.getProximoNo();
            return noPivot.getConteudo();
        }//Aponta nó para o outro nó, tirando o pivot
        No<T> noAnterior = getNo(index - 1);
        noAnterior.setProximoNo(noPivot.getProximoNo());
        return noPivot.getConteudo();
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = referenciaEntrada;
        for(int i = 0; i < this.size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        strRetorno += "null";

        return strRetorno;
    }
}
