package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matriculas")
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //1 matrícula só tem 1 aluno - em aluno não tem referência do aluno, sem problemas, pega da matrícula e acha aluno
  //Não precisa de mappedBy porque na tabela aluno não tem matrícula
  //Cascade - se excluir matrícula exclui aluno
  @OneToOne(cascade = CascadeType.ALL)
  //Nome da coluna que terá FK do aluno na matrícula
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
