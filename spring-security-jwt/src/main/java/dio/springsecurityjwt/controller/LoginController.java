package dio.springsecurityjwt.controller;

import dio.springsecurityjwt.dto.Login;
import dio.springsecurityjwt.dto.Sessao;
import dio.springsecurityjwt.model.Users;
import dio.springsecurityjwt.repository.UsersRepository;
import dio.springsecurityjwt.security.JWTCreator;
import dio.springsecurityjwt.security.JWTObject;
import dio.springsecurityjwt.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//Teremos resposta de sessão com token
@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UsersRepository repository;

    //Login será recebido e retornará objeto sessão
    @PostMapping("/login")
    public Sessao logar(@RequestBody Login login){
        //Vai procurar no banco
        Users users = repository.findByUsername(login.getUsername());
        if(users!=null){
            //Vai verificar se senha do login bate com que está no banco
            boolean passwordOk = encoder.matches(login.getPassword(), users.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }
            //Estamos enviando um objeto Sessão para retornar mais info do usuário
            Sessao sessao = new Sessao();
            sessao.setLogin(users.getUsername());

            //Objeto sessão vai ter objeto JWT
            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION));
            jwtObject.setRoles(users.getRoles());
            //Vai gerar TOKEN no objeto sessão
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        } else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
