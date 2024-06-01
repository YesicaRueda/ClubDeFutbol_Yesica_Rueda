package com.Parcial3_Java_R_D.app.Services;

import java.util.List;

import com.Parcial3_Java_R_D.app.entidades.Jugador;

public interface InterfaceJugadorService {

public List<Jugador> findAll();
	
	public void save (Jugador jugador);
	
	public Jugador findOne(Long id);
	
	public void delete(Long id);
}


