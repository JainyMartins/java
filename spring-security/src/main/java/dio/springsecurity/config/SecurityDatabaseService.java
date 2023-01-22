package dio.springsecurity.config;

import dio.springsecurity.model.Users;
import dio.springsecurity.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SecurityDatabaseService implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    //Determina que esse método retornará interface de UserDetails do core da springsecurity
    //Temos necessidade de interagir no banco
    public UserDetails loadUserByUsername(String username) {
        //Retorna usuário por username
        Users usersEntity = usersRepository.findByUsername(username);
        //Verifica se usuário existe no BD
        if (usersEntity == null){
            throw new UsernameNotFoundException(username);
        }
        //Valida configurações de segurança do usuário
        Set<GrantedAuthority> authorities = new HashSet<>();
        //Gera authorities no contexto - compostas por cada ROLE DEFINIDA NO CADASTRO DO USUÁRIO
        //Se usar padrão ROLE_ + role não precisa realizar nenhuma config adicional para mudar, expectativa do UserDetail é receber assim
        usersEntity.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        });
        //Composição explícita de pacote definindo username, senha e authorities - perfis correspondentes ao usuário
        UserDetails users = new org.springframework.security.core.userdetails.User(
                usersEntity.getUsername(),
                usersEntity.getPassword(),
                authorities);
        return users;
    }
}