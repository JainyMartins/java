import java.util.List;

//Aqui fazendo esse <T> estamos TRANSFORMANDO EM CLASSE GENÉRICA - que aceita tipo genérico
public class No<T> {
    //Teremos conteúdo de tipo genérico
    private T conteudo;
    //Conteúdo de todos os nós encadeados vão ser do tipo T também:
    private No<T> proximoNo;

    public No(T conteudo) {
        this.proximoNo = null;
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo='" + conteudo + '\'' +
                '}';
    }
}
