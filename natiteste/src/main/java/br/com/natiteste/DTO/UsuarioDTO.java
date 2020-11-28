package br.com.natiteste.DTO;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.natiteste.enums.TipoUsuario;


@JsonPropertyOrder({ "id", "nome_completo", "matricula", "tipo_usuario"})
public class UsuarioDTO extends ResourceSupport implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long key;
	
	@JsonProperty("nome_completo")
	private String nomeCompleto;
	
	@JsonProperty("matricula")
	private String matricula;
	
	@JsonProperty("tipo_usuario")
	private TipoUsuario tipoUsuario;

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nomeCompleto == null) ? 0 : nomeCompleto.hashCode());
		result = prime * result + ((tipoUsuario == null) ? 0 : tipoUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nomeCompleto == null) {
			if (other.nomeCompleto != null)
				return false;
		} else if (!nomeCompleto.equals(other.nomeCompleto))
			return false;
		if (tipoUsuario != other.tipoUsuario)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [key=" + key + ", nomeCompleto=" + nomeCompleto + ", matricula=" + matricula
				+ ", tipoUsuario=" + tipoUsuario + "]";
	}
	

	
}
