package dio.apirest.controller;

import dio.apirest.model.Usuario;
import dio.apirest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Faz com que todas as requisições comecem com prefixo users
@RequestMapping("/usuarios")
public class UsuarioController {

    //Repository é que tem a inteligência de fazer o que precisa - lógica;
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping()
    public List<Usuario> getUsers(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username){
        return usuarioRepository.findByUsername(username);
    }

    //Precisa de client HTTP
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        usuarioRepository.deleteById(id);
    }

    @PostMapping()
    public void postUser(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }

    @PutMapping()
    public void putser(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
