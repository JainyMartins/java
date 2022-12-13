import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos valores: ");
        Map<String, Double> carrosPopulares = new HashMap<String, Double>(){{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("Hb20", 14.5);
            put("Kwid", 16.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("Substitua o consumo do gol por 15.2 km/l: ");
        //Não tem como add com mesma chave, ela já existe, basta fazer um put com o novo valor
        carrosPopulares.put("Gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo Tucson está no dicionário: " + carrosPopulares.containsKey("Tucson"));
        //Vai pesquisar pela chave
        System.out.printf("Exiba o consumo do Uno: " + carrosPopulares.get("Uno"));

        System.out.println("Exiba os modelos: " + carrosPopulares.keySet());
        //Retorna um Set

        System.out.println("Exiba os consumos: " + carrosPopulares.values());
        //Retorna um Collection

        //PAREI AQUI (07:39)
    }
}