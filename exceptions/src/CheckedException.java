import javax.swing.*;
import java.io.*;

public class CheckedException {
    public static void main (String[] args) {
        String nomeDoArquivo = "romances-black-croucah.txt";
        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
        }
        //A mais específica tem que vir antes
        catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "O arquivo não foi encontrado!" + e.getCause());
        }
        //Erro mais genérico
        catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado! Entre em contato com o suporte!" + e.getCause());
        } finally {
            System.out.println("Chegou no finally!");
        }

        System.out.println("Apesar da exception ou não, o programa continua...");
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        //Vai ler linha por linha e exibir no console
        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while (line != null);
        //descarregar
        bw.flush();
        //fechar arquivo
        br.close();
    }
}
