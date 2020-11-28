package br.com.natiteste.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "semestre")
public class Semestre implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "semestre")
	private String semestre;
	
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "semestre_has_disciplina", joinColumns = { @JoinColumn (name = "semestre_id") },
			inverseJoinColumns = { @JoinColumn (name = "disciplina_id")})
	private List<Disciplina> disciplina;

}
