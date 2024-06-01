package com.Parcial3_Java_R_D.app.entidades;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;

@Entity
@Table(name="clubes")
public class Club {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@OneToOne
	@Null
	@JoinColumn(name = "enternador_id")
	private Entrenador entrenador;
	
	@OneToMany
	@JoinColumn(name = "id_club")
	private List<Jugador> jugadores;
	
	@ManyToOne
	@Null
	private Asociacion asociacion;
	
	@ManyToMany
	@Null
	private List<Competicion>competiciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

