package br.com.natiteste.service;

import java.util.List;

import br.com.natiteste.model.Semestre;

public interface SemestreService {
	
	Semestre criarSemestre(Semestre semestre);

	Semestre atualizarSemestre(Semestre semestre);

	void deletarSemestre(Long id);

	List<Semestre> listarSemestre();
}
