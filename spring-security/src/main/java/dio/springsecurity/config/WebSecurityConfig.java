package dio.springsecurity;

import dio.springsecurity.config.SecurityDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
//Habilitando que estamos alterando segurança de forma MANUAL através dessa classe
@EnableWebSecurity
//Vamos garantir RECURSOS GLOBAIS dessa configuração
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //Agora precisarmos do SecurityDatabaseService
    //Vai determinar como retornar usuários com devidas configs de acesso à segurança
    @Autowired
    private SecurityDatabaseService securityDatabaseService;

    //Agora vamos determinar que FORMA GLOBAL DE CONSUMIR CREDENCIAIS - ESTRATÉGIA DE CREDENCIAL
    //Será através do consumo do service
    //Autenticação de um gerenciador de autenticações que usará o service
    //Dizemos que BD não tem criptografia nesse momento com o NoOpPassword
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(securityDatabaseService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    //Iremos sobrescrever alguns métodos
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        //Vamos avaliar rotas e suas devidas permissões
        http.authorizeRequests()
                //Todos poderão acessar, inclusive quem não está logado
                .antMatchers("/").permitAll()
                //Aqui temos config adicional, que para RECURSO DE LOGIN só vai ser permitido REQUISIÇÕES DO TIPO POST
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                //Apenas managers
                .antMatchers("/managers").hasAnyRole("MANAGERS")
                //Users e managers
                .antMatchers("/users").hasAnyRole("USERS","MANAGERS")
                //Anteriormente usávamos LOGIN para tela de interação de autenticação,
                //Se quisermos usar CLIENT HTTP para realizar autenticação por módulos
                //E autenticação básica vamos SUBSTITUIR que será AUTENTICAÇÃO BÁSICA
                .anyRequest().authenticated().and().httpBasic();
    }
}