package com.Parcial3_Java_R_D.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Parcial3_Java_R_D.app.entidades.Club;

@Repository
public interface ClubRepository extends CrudRepository<Club, Long> {

}
