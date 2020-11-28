package br.com.natiteste.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.natiteste.DTO.UsuarioDTO;
import br.com.natiteste.model.Usuario;
import br.com.natiteste.repository.UsuarioRepository;
import br.com.natiteste.service.UsuarioService;

@Service
public class UsuarioServiceImplement implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepositoy;

	@Override
	public Usuario criarUsuario(Usuario usuario) {
		usuario.setSenha(gerarSenha());
		System.out.println(usuario);
		usuarioRepositoy.save(usuario);
		return usuarioRepositoy.save(usuario);
	}
	
	private String gerarSenha() {
		String[] carct ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

		 String senha="";

		 for (int x=0; x<10; x++){
		     int j = (int) (Math.random()*carct.length);
		     senha += carct[j];
		 }
		 
		 return senha;
	}

	@Override
	public Usuario atualizarUsuario(Usuario usuario) {
		return usuarioRepositoy.save(usuario);
	}

	@Override
	public void deletarUsuario(Long id) {
		Usuario usuario = usuarioRepositoy.findById(id).orElseThrow();
		usuarioRepositoy.delete(usuario);

	}

	@Override
	public Page<UsuarioDTO> listarUsuarioPorPagina(Pageable pageable) {
		var page = usuarioRepositoy.findAll(pageable);
		return page.map(this::converterParaUsuarioDTO);
	}

	private UsuarioDTO converterParaUsuarioDTO(Usuario usuario) {

		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setKey(usuario.getId());
		usuarioDTO.setMatricula(usuario.getMatricula());
		usuarioDTO.setNomeCompleto(usuario.getNomeCompleto());
		usuarioDTO.setTipoUsuario(usuario.getTipoUsuario());

		return usuarioDTO;
	}

	@Override
	public UsuarioDTO procurarUsuarioPorId(Long id) {
		Usuario usuario = usuarioRepositoy.findById(id).orElseThrow();

		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setKey(usuario.getId());
		usuarioDTO.setMatricula(usuario.getMatricula());
		usuarioDTO.setNomeCompleto(usuario.getNomeCompleto());
		usuarioDTO.setTipoUsuario(usuario.getTipoUsuario());

		return usuarioDTO;
	}

	@Override
	public List<UsuarioDTO> listarTodosUsuarios() {
		
		List<Usuario> usuarios = usuarioRepositoy.findAll();
		
		List<UsuarioDTO> listaUsuarioDTO = new ArrayList<UsuarioDTO>();
		
		for (Usuario usuario : usuarios) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setKey(usuario.getId());
			usuarioDTO.setMatricula(usuario.getMatricula());
			usuarioDTO.setNomeCompleto(usuario.getNomeCompleto());
			usuarioDTO.setTipoUsuario(usuario.getTipoUsuario());
			
			listaUsuarioDTO.add(usuarioDTO);
			
		}
		return listaUsuarioDTO;
	}
	

}
