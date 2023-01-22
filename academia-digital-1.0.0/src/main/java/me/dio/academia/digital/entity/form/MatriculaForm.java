package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaForm {

  //Números e data usamos notNull, char e string usamos notBlank
  @NotNull(message = "Preencha o campo corretamente.")
  //Valida se é maior que 0
  @Positive(message = "O Id do aluno precisa ser positivo")
  private Long alunoId;



}
