package br.com.natiteste.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.natiteste.DTO.UsuarioDTO;
import br.com.natiteste.model.Usuario;
import br.com.natiteste.service.implement.UsuarioServiceImplement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/administrador")
@Api(value = "Administrador EndPoint", description = "Administrador Controller", tags = { "Administrador EndPoint" })
public class AdministradorController {
	
	@Autowired
	UsuarioServiceImplement usuarioServiceImplement;

	@ApiOperation(value = "Lista todos os usuários por paginação")
	@GetMapping(value = "/v1/usuario", produces = { "application/json"})
	public ResponseEntity<PagedResources<UsuarioDTO>> listarUsuarios(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			PagedResourcesAssembler assembler) {
		
		Pageable pageable = PageRequest.of(page, limit);
		Page<UsuarioDTO> usuariosDTO = usuarioServiceImplement.listarUsuarioPorPagina(pageable);
		usuariosDTO.stream().forEach(p ->p.add(linkTo(methodOn(AdministradorController.class).procurarUsuarioPorId(p.getKey())).withSelfRel()));
		
		return new ResponseEntity<>(assembler.toResource(usuariosDTO),HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Lista todos os usuários")
	@GetMapping(value = "/v1/usuario/todos", produces = { "application/json"})
	public List<UsuarioDTO> listarUsuarios() {
		List<UsuarioDTO> listaUsuariosDTO = usuarioServiceImplement.listarTodosUsuarios();
		return listaUsuariosDTO;
	}
	
	@ApiOperation(value = "Procura usuário por id")
	@GetMapping(value = "/v1/usuario/{id}", produces = { "application/json"})
	public UsuarioDTO procurarUsuarioPorId(@PathVariable("id") Long id) {
		UsuarioDTO usuarioDTO = usuarioServiceImplement.procurarUsuarioPorId(id);
		usuarioDTO.add(linkTo(methodOn(AdministradorController.class).procurarUsuarioPorId(id)).withSelfRel());
		return usuarioDTO;
	}
	
	@ApiOperation(value = "Cria usuário")
	@PostMapping(value = "/v1/usuario", produces = { "application/json"}, consumes = { "application/json"})
	public void criarUsuario(@RequestBody  Usuario usuario) {
		System.out.println(usuario);
		usuarioServiceImplement.criarUsuario(usuario);
	}
	
	@ApiOperation(value = "Deleta usuário")
	@DeleteMapping(value = "/v1/usuario/{id}")
	public void deletarUsuario(@PathVariable("id") Long id) {
		usuarioServiceImplement.deletarUsuario(id);
	}
	
	@ApiOperation(value = "Atualiza usuário")
	@PutMapping(value = "/v1/usuario", produces = { "application/json"}, consumes = { "application/json"})
	public void atualizarUsuario(@RequestBody Usuario usuario) {
		usuarioServiceImplement.atualizarUsuario(usuario);
	}
	
}
