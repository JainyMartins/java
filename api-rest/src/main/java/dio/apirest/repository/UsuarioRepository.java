package dio.apirest.repository;

import dio.apirest.handler.BusinessException;
import dio.apirest.handler.CampoObrigatorioException;
import dio.apirest.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {
    //Criamos esses métodos porque não estamos usando JPA;
    public void save (Usuario usuario){
        if(usuario.getLogin()==null)
            throw new CampoObrigatorioException("login");
        if(usuario.getPassword()==null)
            throw new CampoObrigatorioException("password");
        if(usuario.getId()==null)
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        else
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório para update");
        System.out.println(usuario);
    }

    public void deleteById(Integer id){
        System.out.printf("DELETE/id - Recebendo o id: %d para excluir um usuário\n", id);
        System.out.println(id);
    }

    public List<Usuario> findAll(){
        System.out.println("LIST - Listando os usuários do sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("gleyson","password"));
        usuarios.add(new Usuario("jainy", "123456"));
        return usuarios;
    }

    public Usuario findById(Integer id){
        System.out.printf("FIND/id - Recebendo o id: %d para localizar um usuário\n", id);
        return new Usuario("gleyson","password");
    }

    public Usuario findByUsername(String username){
        System.out.printf("FIND/username - Recebendo o id: %s para para localizar um usuário\n", username);
        return new Usuario("gleyson","password");
    }
}
