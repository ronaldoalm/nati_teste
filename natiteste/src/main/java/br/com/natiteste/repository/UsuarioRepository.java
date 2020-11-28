package br.com.natiteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.natiteste.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
