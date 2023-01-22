import java.io.Serializable;

public class Gato implements Serializable {
    private static final long serialVersionUID = 2L;
    private String nome;
    private int idade;
    private String cor;
    //Vamos add novo atributo, ao add não podemos apenas desserializar, a classe é outra
    //Vai dar classNotFoundException
    //Podemos criar atributo serialVersionUID - o Java ao serializar já faz isso, podemos fazer manualmente
    //Fazemos 2L porque a primeira versão era 1L
    //Ainda vai dar erro porque Java está direcionando ainda pra outra classe
    //Podemos serializar - ao fazer isso vai pra versão 2 e vai ser tornar compatível, ao definir a versão
    private boolean castrado;
    //Se quer add atributo sem alterar a versão de serial podemos add palavra reservada transient
    //Ele fica meio que invisível com ela
    //Se coloca pra desserializar já vai dar certo
    //Agora se quer que seja importante, tira transient, muda versão do serial e serializa de novo
    private transient boolean ronrona;



    public Gato(String nome, int idade, String cor, boolean castrado, boolean ronrona) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
        this.castrado = castrado;
        this.ronrona = ronrona;
    }

    public Gato() {
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public boolean isRonrona() {
        return ronrona;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                ", castrado=" + castrado +
                ", ronrona=" + ronrona +
                '}';
    }
}
