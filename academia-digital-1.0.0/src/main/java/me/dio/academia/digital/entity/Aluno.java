package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Anotação do Lombok - serve para ABSTRAIR GETTER, SETTER, EQUALS E HASHCODE
@Data
//Anotação do Lombok - criar CONSTRUTOR VAZIO - hibernate precisa do construtor vazio
@NoArgsConstructor
//Anotação do Lombok - cria CONSTRUTOR que tem TODOS OS ATRIBUTOS DENTRO
@AllArgsConstructor
//Anotação para PERSISTÊNCIA NO BD - vai dizer que classe é tabela, pede PK
@Entity
@Table(name = "tb_alunos")
//Anotação que também serve para livrar de exceções - aqui diz que hibernate será Lazy porque estamos usando nas avaliações o carregamento lazy
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

  @Id
  //Se não passa generatedValue o JPA deixa AUTO. Utilizando o Hibernate como implementação da JPA, a estratégia AUTO escolherá o método de sequências (sequence) para o banco Postgres.
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //Não colocando notação de column vai criar coluna com nome do atributo
  //Importante saber que no BD vai ser salvo como snake case (NOME, DATA_DE_NASCIMENTO, ETC);
  private String nome;

  //unique - campo único, que não pode repetir valor
  @Column(unique = true)
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  //Se relaciona com tabela de avaliação física
  //Anotação de cardinalidade
  //1 aluno pode ter várias avaliações físicas
  //Será relacionamento bidirecional - na tabela avaliação física tem aluno
  //Então colocamos que mappedBy = "campo_que_referencia_aluno"
  //Diz também forma de CARREGAMENTO - no caso LAZY - preguiçoso - se pesquisar por Camila, por ex, vai carregar tudo, menos as avaliações físicas - criamos endpoint só pra avaliações - isso é boa prática para PERFORMANCE
  //Lista pode ficar ruim se toda vez puxar grande volume de dados para ver aluno, por ex
  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
  //Anotações que ajudam a tratar exceções relacionados ao carregamento LAZY - serialização, json, como de looping infinito - por ex, criar várias avaliações infinitamente
  //Poderíamos colocar propriedade no yml também para resolver essas exceções
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
}
