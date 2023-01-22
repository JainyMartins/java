package facade;

import facade.subsistema1.crm.CrmService;
import facade.subsistema2.cep.CepApi;

public class Facade {
    public void migrarCliente (String nome, String cep){
        //Integrações com subsistemas
        //Não temos cidade e estado, mas tem subsistema que pode ajudar
        //Recuperou cidade e estado
        String cidade = CepApi.getInstancia().recuperarCidade(cep);
        String estado = CepApi.getInstancia().recuperarEstado(cep);

        CrmService.gravarCliente(nome, cep, cidade, estado);
    }
}
