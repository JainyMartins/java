package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

//Precisamos da notação Data no CreateRequest (Form aqui) para ter getters, setters, hashCode, etc.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

  //Não pode ter campo vazio, aparece mensagem caso não preencha campo
  @NotEmpty(message = "Preencha o campo corretamente.")
  //Caso fuja vai apresentar mensagem - padrão EL expression - validatedValue vai passar valor que foi passado
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String nome;

  @NotEmpty
  //Verifica CPF
  @CPF(message = "'${validatedValue}' é inválido!")
  private String cpf;

  @NotEmpty
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String bairro;

  //Não pode ser nula
  @NotNull(message = "Preencha o campo corretamente")
  //Para garantir que está no passado, não no futuro
  @Past(message = "Data '${validatedValue}' é inválida.")
  private LocalDate dataDeNascimento;
}
