package dio.padroesprojetospring.repository;

import dio.padroesprojetospring.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//CrudRepository é um strategy
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
