package br.com.natiteste.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natiteste.model.Disciplina;
import br.com.natiteste.repository.DisciplinaRepository;
import br.com.natiteste.service.DisciplinaService;

@Service
public class DisciplinaServiceImplement implements DisciplinaService{
	
	@Autowired
	DisciplinaRepository disciplinaRepository;

	@Override
	public Disciplina criarDisciplina(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}

	@Override
	public Disciplina atualizarDisciplina(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}

	@Override
	public void deletarDisciplina(Long id) {
		Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow();
		disciplinaRepository.delete(disciplina);	
	}

	@Override
	public List<Disciplina> listarDisciplinas() {
		return disciplinaRepository.findAll();
	}

}
