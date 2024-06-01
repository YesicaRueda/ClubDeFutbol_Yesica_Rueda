package com.Parcial3_Java_R_D.app.Services;

import java.util.List;

import com.Parcial3_Java_R_D.app.entidades.Competicion;

public interface InterfaceCompeticionService {
	
public List<Competicion> findAll();
	
	public void save (Competicion competicion);
	
	public Competicion findOne(Long id);
	
	public void delete(Long id);

}


