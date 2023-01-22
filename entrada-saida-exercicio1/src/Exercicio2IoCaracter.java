import java.io.*;
import java.util.Scanner;

public class Exercicio2IoCaracter {
    public static void lerTecladoEscreverDocumento() throws IOException {
        //Para imprimir no console
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Digite 3 recomendações de filmes: ");
        pw.flush();

        //Abertura do teclado
        Scanner scan = new Scanner(System.in);
        //Pega linha retorna em String
        String line = scan.nextLine();

        //Vamos inicializar documento com path name, se quisesse outro diretório tinha que colocar caminho,
        //Nesse caso vai ficar na pasta raiz
        File f = new File("recomendacoes.txt");

        //Vai criar documento por conta do FileWriter
        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));

        do {
            bw.write(line);
            bw.newLine();
            line = scan.nextLine();
        } while (!line.equalsIgnoreCase("fim"));
        bw.flush();

        pw.printf("Arquivo \"%s\" foi criado com sucesso!", f.getName());
        pw.close();
        scan.close();
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        lerTecladoEscreverDocumento();
    }
}
