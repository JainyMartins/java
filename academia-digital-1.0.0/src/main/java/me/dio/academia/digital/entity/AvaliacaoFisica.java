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
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //Temos que colocar cardinalidade porque são tabelas relacionadas
  //Muitas avaliações tem 1 aluno
  //Cascade - alteração que fizer na avaliação física vai refletir no aluno
  @ManyToOne(cascade = CascadeType.ALL)
  //JoinColumn - quer dizer que COLUNAS das FK vão estar dentro da tabela de AVALIAÇÃO FÍSICA
  //Se não colocasse name ia ser o atributo_id mesmo, é a FK
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "peso_atual")
  private double peso;

  @Column(name = "altura_atual")
  private double altura;

}
