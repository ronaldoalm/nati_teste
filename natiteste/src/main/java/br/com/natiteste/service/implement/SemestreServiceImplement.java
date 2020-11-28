package br.com.natiteste.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natiteste.model.Semestre;
import br.com.natiteste.repository.SemestreRepository;
import br.com.natiteste.service.SemestreService;

@Service
public class SemestreServiceImplement implements SemestreService {

	@Autowired
	SemestreRepository semestreRepository;

	@Override
	public Semestre criarSemestre(Semestre semestre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Semestre atualizarSemestre(Semestre semestre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarSemestre(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Semestre> listarSemestre() {
		return semestreRepository.findAll();
	}

}
