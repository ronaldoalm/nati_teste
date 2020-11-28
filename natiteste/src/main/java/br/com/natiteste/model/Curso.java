package br.com.natiteste.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.natiteste.enums.Turno;
import lombok.Data;


@Data
@Entity
@Table(name = "curso")
public class Curso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name= "turno")
	@Enumerated(value = EnumType.STRING)
	private Turno turno;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
	private List<Semestre> semestre;
	
}
