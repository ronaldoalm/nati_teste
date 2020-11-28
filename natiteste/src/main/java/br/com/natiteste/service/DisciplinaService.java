package br.com.natiteste.service;

import java.util.List;

import br.com.natiteste.model.Disciplina;

public interface DisciplinaService {

	Disciplina criarDisciplina(Disciplina disciplina);

	Disciplina atualizarDisciplina(Disciplina disciplina);

	void deletarDisciplina(Long id);

	List<Disciplina> listarDisciplinas();
}
