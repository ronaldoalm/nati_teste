package br.com.natiteste.service;

import java.util.List;

import br.com.natiteste.model.Curso;

public interface CursoService {

	Curso criarCurso(Curso curso);

	Curso atualizarCurso(Curso curso);

	void deletarCurso(Long id);

	List<Curso> listarCurso();
}
