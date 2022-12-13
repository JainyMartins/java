import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MesTemperatura> temperaturaMedia = new ArrayList<>(){{
           add(new MesTemperatura("Janeiro", 25d));
           add(new MesTemperatura("Fevereiro", 27d));
           add(new MesTemperatura("Março", 28d));
           add(new MesTemperatura("Abril", 31d));
           add(new MesTemperatura("Maio", 30d));
           add(new MesTemperatura("Junho", 32d));
        }};
        Double somaSemestral = 0d;
        for(MesTemperatura temp : temperaturaMedia){
            Double tempMes = temp.getTemperatura();
            somaSemestral += tempMes;
        }
        Double mediaSemestral = somaSemestral/temperaturaMedia.size();

        System.out.println(mediaSemestral);
        for (MesTemperatura mesTemperatura : temperaturaMedia) {
            Double next = mesTemperatura.getTemperatura();
            if (next > mediaSemestral) {
                System.out.println(next);
            }
        }
    }
}

class MesTemperatura {
    private Double temperatura;
    private String mes;

    public MesTemperatura(String mes, Double temperatura) {
        this.temperatura = temperatura;
        this.mes = mes;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public String getMes() {
        return mes;
    }

    @Override
    public String toString() {
        return "MesTemperatura{" +
                "temperatura=" + temperatura +
                ", mes='" + mes + '\'' +
                '}';
    }
}