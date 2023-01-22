import java.io.*;

public class Exercicio1IoCaracter {
    public static void receberTecladoImprimirConsole() throws IOException {
//        //Recebendo teclado
//        InputStream is = System.in;
//        //Convertendo bit para caracter
//        InputStreamReader isr = new InputStreamReader(is);
//        //Armazenando em buffer
//        BufferedReader br = new BufferedReader(isr);

        System.out.println("Recomende 3 filmes: ");

        //Para fazer o que estava acima a forma mais comum é - padrão decorator
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Método vai ler cada linha e retornar String - precisa exceção i/o exception
        String line = br.readLine();

//        //Mesma coisa do de cima para a saída, podemos simplificar
//        OutputStream os = System.out;
//        OutputStreamWriter osw = new OutputStreamWriter(os);
//        BufferedWriter bw = new BufferedWriter(osw);

        //Padrão decorator:
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            //Escreve linha
            bw.write(line);
            //Pula linha
            bw.newLine();
            //Recarregar linha para repetir laço
            line = br.readLine();
        } while (!line.isEmpty());
        //Precisamos descarregar - O flush é para obrigar realmente a escrever os dados para disco.
        bw.flush();
        //Fecha fluxo
        br.close();
        bw.close();
    }

    public static void main (String[] args) throws IOException {
        receberTecladoImprimirConsole();
    }
}
