package dio.springsecurityjwt.controller;

import dio.springsecurityjwt.model.Users;
import dio.springsecurityjwt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService service;
    //Finalidade de cadastrar usuário
    @PostMapping
    public void postUser(@RequestBody Users users){
        service.createUser(users);
    }
}
