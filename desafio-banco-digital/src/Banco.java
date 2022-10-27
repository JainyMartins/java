import java.util.List;

public class Banco {
    private String nome;
    protected static List<Cliente> clientes;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setContas(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
