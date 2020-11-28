package br.com.natiteste.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.natiteste.model.Usuario;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
@Api(value = "Login EndPoint", description = "Login Controller", tags = { "Login EndPoint" })
public class LoginController {
	
	@PostMapping(value = "/v1/login", produces = { "application/json"}, consumes = { "application/json"})
	public void logar(@RequestBody Usuario usuario) {
		//TODO Implementar metodo de logar
	}
	
}
