package br.com.natiteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.natiteste.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
