package com.training.demobatch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import com.training.demobatch.config.SpringBatchConfig;
import com.training.listener.compare;

@SpringBootApplication
public class DemoBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBatchApplication.class, args);
		
		/*
		 * compare cm= new compare(); cm.sample();
		 */
		
		
		
	}

}
