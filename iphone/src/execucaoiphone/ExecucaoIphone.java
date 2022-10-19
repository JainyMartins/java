package execucaoiphone;

import iphone.Iphone;

public class ExecucaoIphone {
    public static void main(String[] args) {
        Iphone ip = new Iphone();
        ip.tocar();
        ip.atualizarPagina();
        ip.atender();
    }
}