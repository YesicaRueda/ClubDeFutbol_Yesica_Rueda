package com.Parcial3_Java_R_D.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Parcial3_Java_R_D.app.entidades.Entrenador;
import com.Parcial3_Java_R_D.app.repository.EntrenadorRepository;

@Service
public class EntrenadorServiceImplement implements InterfaceEntrenadorService{

	@Autowired
	private EntrenadorRepository entrenadorrepository;

	@Override
	@Transactional(readOnly = true)
	public List<Entrenador> findAll() {
		// TODO Auto-generated method stub
		return (List<Entrenador>) entrenadorrepository.findAll();
	}
	@Override
	public void save(Entrenador entrenador) {
		// TODO Auto-generated method stub
		entrenadorrepository.save(entrenador);
	}
	@Override
	@Transactional(readOnly = true)
	public Entrenador findOne(Long id) {
		// TODO Auto-generated method stub
		return entrenadorrepository.findById(id).orElse(null);
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		entrenadorrepository.deleteById(id);
	}

}
