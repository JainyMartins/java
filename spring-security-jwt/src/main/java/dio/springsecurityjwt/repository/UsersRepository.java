package dio.springsecurityjwt.repository;

import dio.springsecurityjwt.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query("SELECT e FROM Users e JOIN FETCH e.roles WHERE e.username= (:username)")
    public Users findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);
}
