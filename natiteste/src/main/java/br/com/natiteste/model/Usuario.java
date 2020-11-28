package br.com.natiteste.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.natiteste.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@Table
@ToString
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_completo")
	private String nomeCompleto;
	
	@Column(name = "matricula")
	private String matricula;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "access_token")
	private String accessToken;
	
	@Column(name= "tipo_usuario")
	@Enumerated(value = EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
}
