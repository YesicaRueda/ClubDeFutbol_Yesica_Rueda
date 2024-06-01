package com.Parcial3_Java_R_D.app.Services;

import java.util.List;

import com.Parcial3_Java_R_D.app.entidades.Asociacion;


public interface InterfaceAsociacionService {
	
public List<Asociacion> findAll();
	
	public void save (Asociacion asociacion);
	
	public Asociacion findOne(Long id);
	
	public void delete(Long id);

}
