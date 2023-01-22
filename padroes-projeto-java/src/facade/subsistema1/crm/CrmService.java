package facade.subsistema1.crm;

//Camada de serviço de um CRM (subsistema externo)
public class CrmService {
    //Garantir que quem vai consumir não vai instanciar ela sem necessidade - não tem atributos, só tem método estático
    private CrmService(){
        super();
    }
    public static void gravarCliente(String nome, String cep, String cidade, String estado){
        System.out.println("Cliente salvo no sistema de CRM");
        System.out.println(nome);
        System.out.println(cep);
        System.out.println(cidade);
        System.out.println(estado);
    }
}