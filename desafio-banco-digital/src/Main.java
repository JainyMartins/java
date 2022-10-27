public class Main {
    public static void main (String[] args){
        Cliente jainy = new Cliente();
        jainy.setNome("Jainy");

        Conta cc = new ContaCorrente(jainy);
        Conta poupanca = new ContaPoupanca(jainy);
        //Pode instanciar como interface também se quiser (IConta)
        poupanca.imprimirExtrato();
        cc.depositar(100.00);
        cc.imprimirExtrato();
        cc.transferir(100, poupanca);
        poupanca.imprimirExtrato();
        cc.imprimirExtrato();
        System.out.println();
    }
}