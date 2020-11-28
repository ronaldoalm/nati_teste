package br.com.natiteste.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natiteste.model.Curso;
import br.com.natiteste.repository.CursoRepository;
import br.com.natiteste.service.CursoService;

@Service
public class CursoServiceImplement implements CursoService {

	@Autowired
	CursoRepository cursoRepository;

	@Override
	public Curso criarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public Curso atualizarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public void deletarCurso(Long id) {
		Curso curso = cursoRepository.findById(id).orElseThrow();
		cursoRepository.delete(curso);

	}

	@Override
	public List<Curso> listarCurso() {
		return cursoRepository.findAll();
	}

}
