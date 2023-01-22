package dio.aula;

import dio.aula.model.Users;
import dio.aula.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component - objeto gerenciado pelo spring framework
@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        Users user = new Users();
        user.setName("JAINY");
        user.setUsername("jainy");
        user.setPassword("dio123");

        userRepository.save(user);

        for(Users u : userRepository.findAll()){
            System.out.println(u);
        }
    }
}
