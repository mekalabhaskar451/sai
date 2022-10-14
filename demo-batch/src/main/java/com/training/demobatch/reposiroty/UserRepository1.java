package com.training.demobatch.reposiroty;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.training.demobatch.model.ZipooTradingCompany;

@Repository
public interface UserRepository1 extends JpaRepository<ZipooTradingCompany, Integer>{



}
