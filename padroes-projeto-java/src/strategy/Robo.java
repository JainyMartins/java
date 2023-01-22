package strategy;

public class Robo {
    //Vai ter estratégia de comportamento do robô
    private Comportamento comportamento;

    //Pode querer mudar estratégia (comportamento)
    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }


    //Faz com que robô se mova
    public void mover(){
        comportamento.mover();
    }
}
