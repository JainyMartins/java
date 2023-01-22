import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercicio1IoBytes {
    public static void copiarArquivo() throws IOException {
        File f = new File("D:\\OneDrive\\Documentos\\Ciência da Computação\\Cursos - Complementares\\Dio\\Formação Java Developer\\dio-trilha-java-basico\\Exercicio2IoBytes\\src\\recomendacoes-copy.txt");
        String nomeArquivo = f.getName();

//        //Abrir arquivo
//        InputStream is = new FileInputStream(f.getName());
//        //Facilitar o armazenamento em buffer
//        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Paths.get(f.getName())));

        //Preparar arquivo de saída
        String nomeArquivoCopy = nomeArquivo.substring(0, nomeArquivo.indexOf("-")).concat("-copy2.txt");

        //Preparar file que vai representar esse arquivo cópia
        File fCopy = new File (nomeArquivoCopy);

        //Criar documento
        BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(Paths.get(nomeArquivoCopy)));

        //Não temos linhas agora, temos bytes, se der -1 é porque acabou o arquivo
        int line = 0;
        while((line = bis.read()) != -1) {
            //Pega um inteiro, mas quer escrever um char
            bos.write((char) line);
            bos.flush();
        }
        bis.close();
        bos.close();

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo %s copiado com sucesso e está no diretório %s com %d bytes ", fCopy.getName(), fCopy.getPath(), fCopy.length());
    }
    public static void main(String[] args) throws IOException {
        copiarArquivo();
    }
}
