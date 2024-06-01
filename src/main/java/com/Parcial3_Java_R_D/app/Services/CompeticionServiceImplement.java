package com.Parcial3_Java_R_D.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Parcial3_Java_R_D.app.entidades.Competicion;
import com.Parcial3_Java_R_D.app.repository.CompeticionRepository;

@Service
public class CompeticionServiceImplement implements InterfaceCompeticionService {
	
	@Autowired
	private CompeticionRepository competicionrepository;

	@Override
	@Transactional(readOnly = true)
	public List<Competicion> findAll() {
		// TODO Auto-generated method stub
		return (List<Competicion>) competicionrepository.findAll();
	}
	@Override
	public void save(Competicion competicion) {
		// TODO Auto-generated method stub
		competicionrepository.save(competicion);
	}
	@Override
	public Competicion findOne(Long id) {
		// TODO Auto-generated method stub
		return competicionrepository.findById(id).orElse(null);
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		competicionrepository.deleteById(id);
	}

}



