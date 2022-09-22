
// Abaixo segue um exemplo de código que você pode ou não utilizar
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroConta;
        String numeroAgencia;
        String nomeCliente;
        Double saldo;

        System.out.println("Por favor, digite o número da Conta: ");
        numeroConta = sc.nextInt();
        sc.nextLine();
        System.out.println("Por favor, digite o número da Agência: ");
        numeroAgencia = sc.nextLine();
        System.out.println("Por favor, digite o seu nome: ");
        nomeCliente = sc.nextLine();
        System.out.println("Por favor, digite o seu saldo: ");
        saldo = sc.nextDouble();
        sc.close();

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + numeroAgencia + ", conta " + numeroConta + " e seu saldo " + saldo + " já está disponível para saque");
    }
}