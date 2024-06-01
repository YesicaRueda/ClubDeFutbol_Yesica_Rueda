package com.Parcial3_Java_R_D.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Parcial3_Java_R_D.app.entidades.Jugador;
import com.Parcial3_Java_R_D.app.repository.JugadorRepository;

@Service
public class JugadorServiceImplement implements InterfaceJugadorService{

	@Autowired
	private JugadorRepository jugadorrepo;

	@Override
	@Transactional(readOnly = true)
	public List<Jugador> findAll() {
		// TODO Auto-generated method stub
		return (List<Jugador>) jugadorrepo.findAll();
	}
	@Override
	public void save(Jugador jugador) {
		// TODO Auto-generated method stub
		jugadorrepo.save(jugador);
	}
	
	@Override
	public Jugador findOne(Long id) {
		// TODO Auto-generated method stub
		return jugadorrepo.findById(id).orElse(null);
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		jugadorrepo.deleteById(id);
	}

}


