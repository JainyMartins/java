package dio.springsecurityjwt.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
//Vai ler do application.properties
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {
    //Prefixo do token
    public static String PREFIX;
    //Chave privada para criptografar
    public static String KEY;
    //Tempo expiração do token
    public static Long EXPIRATION;

    public void setPrefix(String prefix){
        PREFIX = prefix;
    }

    public void setKey(String key){
        KEY = key;
    }

    public void setExpiration(Long expiration){
        EXPIRATION = expiration;
    }
}
