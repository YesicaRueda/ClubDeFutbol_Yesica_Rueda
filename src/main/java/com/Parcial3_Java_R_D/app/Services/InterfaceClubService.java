package com.Parcial3_Java_R_D.app.Services;

import java.util.List;
import com.Parcial3_Java_R_D.app.entidades.Club;

public interface InterfaceClubService {
	
public List<Club> findAll();
	
	public void save (Club Club);
	
	public Club findOne(Long id);
	
	public void delete(Long id);
	
}


