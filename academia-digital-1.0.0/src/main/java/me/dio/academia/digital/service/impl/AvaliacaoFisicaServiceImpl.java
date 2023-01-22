package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {
    @Autowired
    AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        //Para ter acesso ao aluno relacionado vamos ter que ter acesso ao alunoRepository
        //Avaliação física precisa de aluno para existir
        //Como retorna optional coloca get no final
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
        //Interessante fazer tto de exceção, mas não é o foco agora

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
        //O ideal na verdade não é retornar a entidade (como aqui retornando avaliação física),
        //Mas sim só uma VIEW porque se tivesse DADO CRÍTICO que não quer retornar não tem como tirar se retornar assim
        //Teria que criar método MAP pra fazer essa TRANSFORMAÇÃO - DTO, FORM, VIEW - ver
        //Poderia criar pasta chamada MAPPER e fazer uma VIEW para mostrar só o que quer
        //Poderia refatorar o código acima para melhorar
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return avaliacaoFisicaRepository.getById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.getById(id);
        avaliacaoFisica.setAltura(formUpdate.getAltura());
        avaliacaoFisica.setPeso(formUpdate.getPeso());
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public void delete(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}
