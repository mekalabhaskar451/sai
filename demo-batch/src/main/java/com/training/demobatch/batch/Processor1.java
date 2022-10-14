package com.training.demobatch.batch;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.training.demobatch.model.ZipooTradingCompany;

@Component
public class Processor1 implements ItemProcessor<ZipooTradingCompany, ZipooTradingCompany>{

	private static final Map<String, String> DEPT_NAMES = new HashMap<>();

//	public Processor1() {
//		DEPT_NAMES.put("1", "Technology");
//		DEPT_NAMES.put("2", "Operations");
//		DEPT_NAMES.put("3", "Accounts");
//		
//	
//	}
//	
	

//	public void comman(User user, User1 user1) {
//		if (user1.getName().equalsIgnoreCase(user.getName())) {
//			System.out.println(String.format("common data--->[%s]", user1.getName()));
//		}
//	}
	
//	public List<User> abc(User1 user1){
//		List data = new ArrayList<>();
//		
//		System.out.println(data);
//				
//		return data;
//		
//	}

	
	
	@Override
	public ZipooTradingCompany process(ZipooTradingCompany ztc) throws Exception {
		/*
		 * String deptCode = ztc.getDept(); String dept = DEPT_NAMES.get(deptCode);
		 * user1.setDept(dept);
		 * System.out.println(String.format("Converted User1 file from [%s] to [%s]",
		 * deptCode, dept));
		 */

		String uppername = ztc.getCustomername();
		String samplename = uppername.toUpperCase();
		ztc.setCustomername(samplename);
		
		if (ztc.getCustomerid() == null) {
			System.out.println("Missing employee id : " + ztc.getCustomerid());
			return null;
		}

		try {
			if (Integer.valueOf(ztc.getCustomerid()) <= 0) {
				System.out.println("Invalid employee id : " + ztc.getCustomerid());
				return null;
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid employee id : " + ztc.getCustomerid());
			return null;
		}

		System.out.println(String.format("Converted from [%s] to [%s]", uppername, samplename));

		return ztc;
	}

}
