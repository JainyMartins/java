import java.util.*;

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

        System.out.println("Exiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);
        //Retorna um Set

        System.out.println("Exiba os consumos: ");
        Collection<Double> consumos =  carrosPopulares.values();
        System.out.println(consumos);
        //Retorna um Collection

        //Retornar carro que faz mais litros
        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        //Agora precisa saber qual chave é - vai retornar getKey e getValue no entry
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet(); //Retorna Set e elementos é do tipo entry
        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry : entries){
            if (entry.getValue().equals(consumoMaisEficiente))
                modeloMaisEficiente = entry.getKey();
        }
        System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
        //Se tiver mais de 1 igual vai imprimir a quantidade que tiver dos maiores

        System.out.println("Exiba o modelo menos econômico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";

        for(Map.Entry<String, Double> entry : carrosPopulares.entrySet()){
            if (entry.getValue().equals(consumoMenosEficiente))
                modeloMenosEficiente = entry.getKey();
        }
        System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
        //Se tiver mais de 1 igual vai imprimir todos

        System.out.println("Exiba a soma dos consumos: ");

        Iterator<Double> iterator = carrosPopulares.values().iterator(); //Consegue chamar iterator porque retorno é Collection
        Double soma = 0d;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: " + soma);

        System.out.println("Exiba a média dos consumos deste dicionário de carros: " + (soma/carrosPopulares.size()));

        System.out.println("Remova os modelos com o consumo igual a 15,6 km/L: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);

        //Vamos usar LinkedHashMap
        System.out.println("Exiba todos os carros na ordem que foram informados: ");
        Map<String, Double> carrosPopulares2 = new LinkedHashMap<String, Double>(){{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("Hb20", 14.5);
            put("Kwid", 16.6);
        }};
        System.out.println(carrosPopulares2);

        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        //Quem ordena chave é o TreeMap
        Map<String, Double> carrosPopulares3 = new TreeMap<String, Double>(carrosPopulares);
        System.out.println(carrosPopulares3.toString());

        System.out.println("Apague o dicionário de carros: ");
        carrosPopulares.clear();
        System.out.println(carrosPopulares);

        System.out.println("Confire se o dicionário está vazio: " + carrosPopulares.isEmpty());

    }
}