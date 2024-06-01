package com.Parcial3_Java_R_D.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Parcial3_Java_R_D.app.entidades.Club;
import com.Parcial3_Java_R_D.app.repository.ClubRepository;

@Service
public class ClubServiceImplement implements InterfaceClubService {
	
	@Autowired
	private ClubRepository clubrepository;

	@Override
	@Transactional(readOnly = true)
	public List<Club> findAll() {
		// TODO Auto-generated method stub
		return (List<Club>) clubrepository.findAll();
	}
	@Override
	public void save(Club Club) {
		// TODO Auto-generated method stub
		clubrepository.save(Club);
	}

	@Override
	@Transactional(readOnly = true)
	public Club findOne(Long id) {
		return clubrepository.findById(id).orElse(null);
	}
	@Override
	public void delete(Long id) {
		clubrepository.deleteById(id);
		
	}

}
