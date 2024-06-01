package com.Parcial3_Java_R_D.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Parcial3_Java_R_D.app.entidades.Asociacion;
import com.Parcial3_Java_R_D.app.repository.AsociacionRepository;

@Service
public class AsociacionServiceImplement implements InterfaceAsociacionService {
	
	@Autowired
	private AsociacionRepository asociacionrepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Asociacion> findAll() {
		// TODO Auto-generated method stub
		return (List<Asociacion>) asociacionrepo.findAll();
	}

	@Override
	public void save(Asociacion asociacion) {
		asociacionrepo.save(asociacion);
	}

	@Transactional(readOnly = true)
	public Asociacion findOne(Long id) {
		// TODO Auto-generated method stub
		return asociacionrepo.findById(id).orElse(null);
	}
	@Override
	public void delete(Long id) {
		asociacionrepo.deleteById(id);
		
	}

}