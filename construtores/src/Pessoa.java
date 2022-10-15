public class Pessoa {
    private String nome;
    private String cpf;
    private String endereco;

    //Abaixo vemos o construtor em ação, tem que ter o mesmo nome da classe
    public Pessoa (String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    //Podemos também ter mais de um construtor para construirmos de forma diferente
    public Pessoa (String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

}
