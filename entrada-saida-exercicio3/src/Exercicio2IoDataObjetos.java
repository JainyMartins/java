import java.io.*;

//Instanciar objeto e serializar
//Desserializar objeto
//Mostrar no console
public class Exercicio2IoDataObjetos {
    public static void serializarObjeto() throws IOException {
        Gato gato = new Gato("Lanny", 5, "Laranja", true, false);

        //Cria o file
        File f = new File("gato");

//        OutputStream os = new FileOutputStream(f.getName());
//        ObjectOutputStream oos = new ObjectOutputStream(os);
        //Cria arquivo que vai conter objeto serializado - usando decorator - abre o fluxo de saída para escrever dentro do arquivo
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f.getName()));

        //Serializa objeto
        oos.writeObject(gato);

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo \"%s\" criado com sucesso! Tamanho '%d' bytes.", f.getName(), f.length());

        oos.close();
        ps.close();
    }
    public static void desserializarObjeto(String arquivo) throws IOException, ClassNotFoundException {
        //Já com decorator - para receber arquivo:
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));

        //Vai ler o objeto, ele vai devolver um gato, por isso podemos fazer um cast - vai desserializar
        Gato objetoGato = (Gato) ois.readObject();

        //Exibe informações
        //Não precisa ser na ordem, diferente do Data
        System.out.printf("\n Nome......................: %s\n", objetoGato.getNome());
        System.out.printf("\n Idade......................: %d\n", objetoGato.getIdade());
        System.out.printf("\n Cor......................: %s\n", objetoGato.getCor());
        System.out.printf("\n Castrado..................: %s\n", objetoGato.isCastrado());
        System.out.printf("\n Ronrona..................: %s\n", objetoGato.isRonrona());
        //Aqui usa o toString da classe Gato
        System.out.println(objetoGato);

        //Fecha fluxo
        ois.close();
    }
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        serializarObjeto();
        //Para desserializar temque comentar a serialização
        desserializarObjeto("gato");
    }
}