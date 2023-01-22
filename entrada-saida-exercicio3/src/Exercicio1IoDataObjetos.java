import java.io.*;
import java.util.Scanner;

//Criar arquivo "peca-de-roupa" e armazenar
//1. Nome do produto, tamanho (P/M/G/U), quantidade e preço
//2. Leia o arquivo e imprima no console
public class Exercicio1IoDataObjetos {
    public static void incluirProduto() throws IOException {
        File f = new File("produtos/peca-de-roupa.bin");

        //Imprime no console
        PrintStream ps = new PrintStream(System.out);
        ps.flush();

        //Persistir tipos primitivos no documento
//        OutputStream os = new FileOutputStream(f.getPath());
//        DataOutputStream dos = new DataOutputStream(os);
        //DataOutputStream faz serialização dos dados
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f.getPath()));

        //Abrir teclado
        Scanner scan = new Scanner(System.in);

        //Exibe no console o que quer
        ps.print("Nome da peça: ");
        //Pega o que digitou
        String nome = scan.nextLine();
        //Escreve no documento
        dos.writeUTF(nome);

        //Repete o processo
        ps.print("Tamanho da peça (P/M/G/U): ");
        //Como não temos método para pegar char, vamos pegar o int e transformar em char
        char tamanho = (char) System.in.read();
        dos.writeChar(tamanho);

        ps.print("Quantidade: ");
        int quant = scan.nextInt();
        dos.writeInt(quant);

        ps.print("Preço unitário: ");
        double preco = scan.nextDouble();
        dos.writeDouble(preco);

        ps.printf("O arquivo %s foi criado com %d bytes no diretório '%s'.\n", f.getName(), f.length(), f.getPath());

        lerProduto(f.getPath());

        dos.close();
        scan.close();
        ps.close();
    }
    public static void lerProduto(String caminhoArquivo) throws IOException {
        File f = new File(caminhoArquivo);

//        //Abrir arquivo
//        InputStream is = new FileInputStream(f.getPath());
//        DataInputStream dis = new DataInputStream(is);
        DataInputStream dis = new DataInputStream(new FileInputStream(f.getPath()));

        //Leitura de cada variável - tem que ser na mesma ordem
        String nome = dis.readUTF();
        char tamanho = dis.readChar();
        int quant = dis.readInt();
        double preco = dis.readDouble();

        //Precisamos ler linha por linha
        System.out.printf("\n Nome...............: %s\n", nome);
        System.out.printf("\n Quantidade...............: %d\n", quant);
        System.out.printf("\n Tamanho...............: %s\n", tamanho);
        System.out.printf("\n Preço...............: %f\n", preco);
        System.out.print("\nTotal do valor das peças: " + (quant*preco));

        dis.close();
    }
    public static void main (String[] args) throws IOException {
        incluirProduto();
    }
}
