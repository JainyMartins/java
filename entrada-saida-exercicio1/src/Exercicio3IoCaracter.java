import java.io.*;

public class Exercicio3IoCaracter {
    public static void copiarArquivo() throws IOException {
        //Pegará o caminho arquivo e nome
        File f = new File("recomendacoes.txt");
        String nomeArquivo = f.getName();

//        //Fará leitura do arquivo, pode iniciar com FileReader ou Reader mesmo
//        FileReader r = new FileReader(nomeArquivo);
//        //Armazena em Buffer
//        BufferedReader br = new BufferedReader(r);

        //Podemos usar o decorator
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
        //Leitura de linhas
        String line = br.readLine();

        //Aqui criamos substring para chegar tudo até antes do ponto e add -copy.txt
        String nomeArquivoCopia = nomeArquivo.substring(0, nomeArquivo.indexOf(".")).concat("-copy.txt");

        //Faz file com nome
        File fcopy = new File (nomeArquivoCopia);

        //Armazena num buffer
        BufferedWriter bw = new BufferedWriter(new FileWriter(fcopy.getName()));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = br.readLine();
        } while (!(line == null));

        System.out.printf("Arquivo \"%s\" copiado com sucesso! Com o tamanho: '%d' bytes.\n", f.getName(), f.length());
        System.out.printf("Arquivo \"%s\" criado com sucesso! Com o tamanho: '%d' bytes.\n", fcopy.getName(), f.length());

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Recomende 3 livros: ");
        pw.flush();

        adicionarInfoNoArquivo(fcopy.getName());

        pw.printf("Ok, tudo certo! Tamanho do arquivo '%d' bytes", fcopy.length());

        br.close();
        bw.close();
        pw.close();
    }
    public static void adicionarInfoNoArquivo(String arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        //Append vai acrescentar no final sem apagar o que já tinha
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));
        bw.newLine();
        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
            bw.flush();
        } while (!(line.equalsIgnoreCase("fim")));

    }
    public static void main (String[] args) throws IOException {
        copiarArquivo();
    }
}