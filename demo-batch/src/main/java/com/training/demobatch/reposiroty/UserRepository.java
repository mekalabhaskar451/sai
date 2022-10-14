package com.training.demobatch.reposiroty;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.training.demobatch.model.ChennaiNationalBank;

@Repository
public interface UserRepository extends JpaRepository<ChennaiNationalBank, Integer>{



}
