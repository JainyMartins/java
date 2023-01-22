package dio.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dio.aula.model.Users;

public interface UserRepository extends JpaRepository <Users, Integer> {

}
