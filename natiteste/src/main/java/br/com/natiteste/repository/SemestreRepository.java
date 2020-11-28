package br.com.natiteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.natiteste.model.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Long>{

}
