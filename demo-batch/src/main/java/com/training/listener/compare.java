package com.training.listener;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class compare {

//	ArrayList<User> user = new ArrayList<User>();
//	ArrayList<User1> user1 = new ArrayList<User1>();
//	

	public void sample() {
		/*
		 * ArrayList<User> users = new ArrayList<User>(); // ArrayList<User1> user1 =
		 * new ArrayList<User1>();
		 * 
		 * 
		 * User user1 = new User(); user1.setId(1); user1.setName("asfd");
		 * user1.setDept("asfdasf"); user1.setSalary(1234);
		 * 
		 * users.add(user1);
		 * 
		 * System.out.println("The list is: \n" + users);
		 * 
		 * Iterator<User> iter = users.iterator(); while (iter.hasNext()) {
		 * System.out.print(iter.next() + " "); }
		 */

		String path = "C:/Users/CHANDRAJ/Downloads/demo-batch/src/main/resources/users.csv";
		String path1 = "C:/Users/CHANDRAJ/Downloads/demo-batch/src/main/resources/user1.csv";
		
        String line ="";
        String line1 ="";
        
        try {
            
            BufferedReader bufferReader = new BufferedReader(new FileReader(path));
            BufferedReader bufferReader1 = new BufferedReader(new FileReader(path1));
            
            while((line = bufferReader.readLine()) != null) {
            	
            	while((line1 = bufferReader1.readLine()) != null) {
            		
            		
            		
            	}
            //    System.out.println(line);
                String[] values = line.split(",");
                System.out.println("Customer ID : " +values[0]+ " , Customer name : " + values[1] + " ,DOB is :" + values[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }



}
