package com.Parcial3_Java_R_D.app.Services;

import java.util.List;

import com.Parcial3_Java_R_D.app.entidades.Entrenador;

public interface InterfaceEntrenadorService {

public List<Entrenador> findAll();
	
	public void save (Entrenador entrenador);
	
	public Entrenador findOne(Long id);
	
	public void delete(Long id);
}