package com.Parcial3_Java_R_D.app.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="competiciones")
public class Competicion {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;
@NotEmpty
private String nombre;
@NotEmpty
private String montoPremio;
@NotEmpty
private String fechaInicio;
@NotEmpty
private String fechaFin;


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
public String getMontoPremio() {
	return montoPremio;
}
public void setMontoPremio(String montoPremio) {
	this.montoPremio = montoPremio;
}
public String getFechaInicio() {
	return fechaInicio;
}
public void setFechaInicio(String fechaInicio) {
	this.fechaInicio = fechaInicio;
}
public String getFechaFin() {
	return fechaFin;
}
public void setFechaFin(String fechaFin) {
	this.fechaFin = fechaFin;
}
	
	
	
}
