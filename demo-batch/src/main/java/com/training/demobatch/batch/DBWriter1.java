package com.training.demobatch.batch;

import java.util.List;



import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.training.demobatch.model.User;
import com.training.demobatch.model.ZipooTradingCompany;
//import com.training.demobatch.reposiroty.UserRepository;
import com.training.demobatch.reposiroty.UserRepository1;

@Component
public class DBWriter1 implements ItemWriter<ZipooTradingCompany>{
	
    private UserRepository1 userRepository1;
//    private UserRepository userRepository;
    

    @Autowired
    public DBWriter1 (UserRepository1 userRepository1) {
        this.userRepository1 = userRepository1;
    }
	
	@Override
	public void write(List<? extends ZipooTradingCompany> ztc) throws Exception {
		System.out.println("Data saved for users :" +ztc);
		userRepository1.saveAll(ztc);
		
	}
	/*
	 * @Override public void write1(List<? extends User> user) throws Exception {
	 * System.out.println("Data saved for users----------------------- :" +user);
	 * userRepository.saveAll(user);
	 * 
	 * }
	 */

}
