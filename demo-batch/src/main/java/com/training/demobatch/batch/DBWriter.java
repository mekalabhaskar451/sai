package com.training.demobatch.batch;

import java.util.List;


import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.demobatch.model.ChennaiNationalBank;
import com.training.demobatch.reposiroty.UserRepository;
import com.training.demobatch.reposiroty.UserRepository1;

@Component
public class DBWriter implements ItemWriter<ChennaiNationalBank> {

	private UserRepository userRepository;
	//private UserRepository1 userRepository1;

	@Autowired
	public DBWriter(UserRepository userRepository, UserRepository1 userRepository1) {
		this.userRepository = userRepository;
		//this.userRepository1 = userRepository1;
	}

	@Override
	public void write(List<? extends ChennaiNationalBank> cnb) throws Exception {
		System.out.println("Data saved for users :" + cnb);
		userRepository.saveAll(cnb);
		
	}

}
