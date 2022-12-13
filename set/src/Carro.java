import java.util.Objects;

public class Carro implements Comparable<Carro>{
    String marca;

    public Carro(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //Primeiro compara para ver se parâmetro é igual o objeto,
    //Depois ele compara se é null ou se é diferente
    //Depois instancia objeto e retorna se objeto é igual a outro
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(marca, carro.marca);
    }

    //Utiliza hash da classe Objects, retorna número inteiro - hash gerado a partir do atributo marca para facilitar organizar carros nela
    @Override
    public int hashCode() {
        return Objects.hash(marca);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "marca='" + marca + '\'' +
                '}';
    }


//    //Por ordem de tamanho
//    @Override
//    public int compareTo(Carro o) {
//        if(this.marca.length() < o.marca.length()){
//            return -1;
//        } else if(this.marca.length() > o.marca.length()){
//            return 1;
//        }
//        return 0;
//    }

    //Por ordem alfabética
    @Override
    public int compareTo(Carro o){
        return this.getMarca().compareTo(o.getMarca());
    }
}
