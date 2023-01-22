package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//Anotação repository
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    //lista com todos os alunos com a data de nascimento passada como parâmetro da função
    //Precisamos usar findBy e depois atributo (nesse caso dataDeNascimento)
    //Dessa forma já dará certo
    List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);

}
