package dio.apirest.handler;

public class BusinessException extends RuntimeException {
    public BusinessException (String mensagem){
        super(mensagem);
    }
    //Abaixo com Object podemos tornar mensagens mais dinâmicas, recebendo parâmetros
    public BusinessException(String mensagem, Object ... params){
        super(String.format(mensagem, params));
    }
}