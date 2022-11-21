public class Pilha {
    private No refNoEntradaPilha;

    public Pilha(){
        this.refNoEntradaPilha = null;
    }

    public boolean isEmpty(){
        return refNoEntradaPilha == null ? true : false;
    }

    //Ao executar um system.out vai exibir esse toString
    @Override
    public String toString(){
        String stringRetorno = "--------------\n";
        stringRetorno += "    Pilha\n";
        stringRetorno += "--------------\n";

        //Vai percorrer pilha e mostrar nós
        No noAuxiliar = refNoEntradaPilha;

        while (true){
            if(noAuxiliar != null){
                stringRetorno += "[No{dado=" + noAuxiliar.getDado() + "}]\n";
                noAuxiliar = noAuxiliar.getRefNo();
                //Quando ref for nula vai dar break
            } else{
                break;
            }

        }
        stringRetorno += "==============\n";
        return stringRetorno;
    }

    public No top(){
        return refNoEntradaPilha;
    }

    public void push(No novoNo){
        No refAuxiliar = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setRefNo(refAuxiliar);
    }

    public No pop(){
        if(!this.isEmpty()){
            No noPopped = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
            return noPopped;
        }
        return null;
    }
}
