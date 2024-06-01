package com.Parcial3_Java_R_D.app.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name="entrenadores")
public class Entrenador {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;
@NotEmpty
private String nombre;
@NotEmpty
private String apellido;
@NotEmpty
private String edad;
@NotEmpty
private String nacionalidad;


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
public String getEdad() {
	return edad;
}
public void setEdad(String edad) {
	this.edad = edad;
}
public String getNacionalidad() {
	return nacionalidad;
}
public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}

}
