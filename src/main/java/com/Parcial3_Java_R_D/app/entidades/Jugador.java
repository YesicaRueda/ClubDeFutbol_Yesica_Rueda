package com.Parcial3_Java_R_D.app.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="jugadores")
public class Jugador {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;
@NotEmpty
private String nombre;
@NotEmpty
private String apellido;


@NotNull
@Positive
private int numero;

@NotEmpty
private String posicion;


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

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public int getNumero() {
	return numero;
}

public void setNumero(int numero) {
	this.numero = numero;
}

public String getPosicion() {
	return posicion;
}

public void setPosicion(String posicion) {
	this.posicion = posicion;
}

}
