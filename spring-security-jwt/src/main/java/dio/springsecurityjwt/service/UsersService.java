package dio.springsecurityjwt.service;

import dio.springsecurityjwt.model.Users;
import dio.springsecurityjwt.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    UsersRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    //Vamos salvar usuário através do service quando realizar requisição
    //Mas antes de salvar vamos TER CRIPTOGRAFIA para NÃO DEIXAR SENHAS
    //EXPLÍCITAS NO BD - antes de salvar vai criptografar e pedir para
    //repository salvar no BD
    //Vamos ter momento para habilitar framework que vai validar a senha (decriptografá-la) e ver se está correta
    public void createUser (Users users){
        String pass = users.getPassword();
        //criptografando antes de salvar no banco
        users.setPassword(encoder.encode(pass));
        repository.save(users);
    }
}
