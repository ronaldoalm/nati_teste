package br.com.natiteste.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.natiteste.DTO.UsuarioDTO;
import br.com.natiteste.model.Usuario;

public interface UsuarioService {
	
	Usuario criarUsuario(Usuario usuario);
	
	Usuario atualizarUsuario(Usuario usuario);
	
	void deletarUsuario(Long id);
	
	UsuarioDTO procurarUsuarioPorId(Long id);
	
	List<UsuarioDTO> listarTodosUsuarios();
	
	Page<UsuarioDTO> listarUsuarioPorPagina(Pageable pageable);
	
}
