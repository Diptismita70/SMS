package com.sms.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.sms.entity.StudentDetails;

import lombok.Data;

@Data

public class StudentDetailsInfo 
  {
	private String id;
	private String name;
	private String standard;
	private String rollNo;
	private String dob;
	private String fathersName;
	private String mothersName;
	private String contactNo;
	private String address;
	
	public StudentDetails converToEntity()
	{
		StudentDetails student = new StudentDetails();
		 if(id!=null  && id!="0")
	    	student.setId(Long.valueOf(id));
		    student.setName(name);
		    student.setRollNo(rollNo);
		    student.setFathersName(fathersName);
		    student.setMothersName(mothersName);
		    student.setContactNo(contactNo);
            student.setAddress(address);
            
            SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
    	  	try {
    	  		if(dob!=null && !dob.equals(""))
    	  			student.setDob(format.parse(dob));
    	  		
    	  	}
    	  	
    	  	catch (ParseException e) {
    	  		// TODO Auto-generated catch block
    	    	e.printStackTrace();
    	
    	  }
    	  	return student;
	}

}
