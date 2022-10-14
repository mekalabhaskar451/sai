package com.training.demobatch.batch;

import java.util.HashMap;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.training.demobatch.model.ChennaiNationalBank;

@Component
public class Processor implements ItemProcessor<ChennaiNationalBank, ChennaiNationalBank>{
	
	private static final Map<String,String> DEPT_NAMES = new HashMap<>();
	 public Processor() {
		 DEPT_NAMES.put("1", "Technology");
		 DEPT_NAMES.put("2", "Operations");
		 DEPT_NAMES.put("3", "Accounts");
	 }
	 
	@Override
	public ChennaiNationalBank process(ChennaiNationalBank cnb) throws Exception {
	
		//validation
		String customeridregax = "/[U]\\d{9}/gm";
		Pattern pattern = Pattern.compile(customeridregax);  
		
		//Matcher matcher = pattern.matcher();
		
		//customername uppercase
		String namelowercase = cnb.getCustomername();
		cnb.setCustomername(namelowercase.toLowerCase());
		
		
//		if (cnb.getCustomerid() == null){
//		      System.out.println("Missing employee id : " + cnb.getCustomerid());
//		      return null;
//		    } 
//		     
//		    try
//		    {
//		      if(Integer.valueOf(cnb.getCustomerid()) <= 0) {
//		        System.out.println("Invalid employee id : " + cnb.getCustomerid());
//		        return null;
//		      }
//		    }
//		    catch (NumberFormatException e) {
//		      System.out.println("Invalid employee id : " + cnb.getCustomerid());
//		      return null;
//		    }
		    
		    
		return cnb;
	}

}
