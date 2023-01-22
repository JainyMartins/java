package dio.apirest.handler;

import javax.annotation.Resource;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    //Capaz de pegar mensagens de origem da exceção executadas nas requisições HTTP
    @Resource
    private MessageSource messageSource;
    //Poderia add info no CABEÇALHO da resposta, nesse caso colocamos que conteúdo será JSON
    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
    //Vai constituir info de erro - recebe mensagem e statusCode, colocamos fixo o status, mas pode mudar
    private ResponseError responseError(String message, HttpStatus statusCode){
        ResponseError responseError = new ResponseError();
        responseError.setStatus("error");
        responseError.setError(message);
        responseError.setStatusCode(statusCode.value());
        return responseError;
    }

    //Anotação exceptionHandler - ao captar qualquer tipo de exceção ela faz verificação se é BusinessException,
    //Se for vai chamar outra handler abaixo e vai montar responseError de acordo com estrutura
    //Mensagem vai ser de acordo com msg passada pelo controller e vamos ilustrar statusCode do tipo conflito - requisição
    //Fora da regra de negócio
    //Abaixo vemos que se não for ela, vai ser erro mais genério - INTERNAL - poderia mapear
    //Para ter outros cenários cobertos além da BusinessException
    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
        if (e.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            return handleBusinessException((BusinessException) exception.getUndeclaredThrowable(), request);
        } else {
            String message = messageSource.getMessage("error.server", new Object[]{e.getMessage()}, null);
            ResponseError error = responseError(message,HttpStatus.INTERNAL_SERVER_ERROR);
            return handleExceptionInternal(e, error, headers(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }
    @ExceptionHandler({BusinessException.class})
    private ResponseEntity<Object> handleBusinessException(BusinessException e, WebRequest request) {
        ResponseError error = responseError(e.getMessage(),HttpStatus.CONFLICT);
        return handleExceptionInternal(e, error, headers(), HttpStatus.CONFLICT, request);
    }
}
