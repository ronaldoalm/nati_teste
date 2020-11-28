package br.com.natiteste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.natiteste.model.Curso;
import br.com.natiteste.model.Disciplina;
import br.com.natiteste.model.Semestre;
import br.com.natiteste.service.implement.CursoServiceImplement;
import br.com.natiteste.service.implement.DisciplinaServiceImplement;
import br.com.natiteste.service.implement.SemestreServiceImplement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/coordenador")
@Api(value = "Coordenador EndPoint", description = "Coordenador Controller", tags = { "Coordenador EndPoint" })
public class CoodenadorController {

	@Autowired
	SemestreServiceImplement semestreServiceImplement;
	
	@Autowired
	CursoServiceImplement cursoServiceImplement;
	
	@Autowired
	DisciplinaServiceImplement disciplinaServiceImplement;

	@ApiOperation(value = "Lista todos os semestres")
	@GetMapping(value = "/v1/semestre", produces = { "application/json"})
	public List<Semestre> listarSemestre() {
		return semestreServiceImplement.listarSemestre();
	}
	
	@ApiOperation(value = "Cria um semestre")
	@PostMapping(value = "/v1/semestre", produces = { "application/json"}, consumes = { "application/json"})
	public void criarUsuario(@RequestBody  Semestre semestre) {
		semestreServiceImplement.criarSemestre(semestre);
	}
	
	@ApiOperation(value = "Deleta semestre")
	@DeleteMapping(value = "/v1/semestre/{id}")
	public void deletarSemestre(@PathVariable("id") Long id) {
		semestreServiceImplement.deletarSemestre(id);
	}
	
	@ApiOperation(value = "Atualiza semestre")
	@PutMapping(value = "/v1/semestre", produces = { "application/json"}, consumes = { "application/json"})
	public void atualizarSemestre(@RequestBody Semestre semestre) {
		semestreServiceImplement.atualizarSemestre(semestre);
	}
	
	
	@ApiOperation(value = "Lista todas as disciplinas")
	@GetMapping(value = "/v1/disciplinas", produces = { "application/json"})
	public List<Disciplina> listarDisciplinas() {
		return disciplinaServiceImplement.listarDisciplinas();
	}
	
	@ApiOperation(value = "Cria uma disciplina")
	@PostMapping(value = "/v1/disciplina", produces = { "application/json"}, consumes = { "application/json"})
	public Disciplina criarDisciplina(@RequestBody Disciplina disciplina) {
		return disciplinaServiceImplement.criarDisciplina(disciplina);
	}
	
	@ApiOperation(value = "Deleta uma disciplina")
	@DeleteMapping(value = "/v1/disciplina/{id}")
	public void deletarDisciplina(@PathVariable("id") Long id) {
		disciplinaServiceImplement.deletarDisciplina(id);
	}
	
	@ApiOperation(value = "Atualiza disciplina")
	@PutMapping(value = "/v1/disciplina", produces = { "application/json"}, consumes = { "application/json"})
	public void atualizarDisciplina(@RequestBody Disciplina disciplina) {
		disciplinaServiceImplement.atualizarDisciplina(disciplina);
	}
	
	@ApiOperation(value = "Cria um curso")
	@PostMapping(value = "/v1/curso", produces = { "application/json"}, consumes = { "application/json"})
	public Curso criarCurso(@RequestBody Curso curso) {
		return cursoServiceImplement.criarCurso(curso);
	}
	
	@ApiOperation(value = "Lista todos os cursos")
	@GetMapping(value = "/v1/curso", produces = { "application/json"})
	public List<Curso> listarCurso() {
		return cursoServiceImplement.listarCurso();
	}
	
	@ApiOperation(value = "Deleta um curso")
	@DeleteMapping(value = "/v1/curso/{id}")
	public void deletarCurso(@PathVariable("id") Long id) {
		cursoServiceImplement.deletarCurso(id);
	}
	
	@ApiOperation(value = "Atualizar curso")
	@PutMapping(value = "/v1/curso", produces = { "application/json"}, consumes = { "application/json"})
	public void atualizarCurso(@RequestBody Curso curso) {
		cursoServiceImplement.atualizarCurso(curso);
	}

}
