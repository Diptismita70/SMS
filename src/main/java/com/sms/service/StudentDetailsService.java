package com.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.bean.StudentDetailsInfo;
import com.sms.entity.StudentDetails;
import com.sms.repository.StudentDetailsRepo;

@Service

public class StudentDetailsService 
       {
@Autowired
	
    StudentDetailsRepo StudentDetailsRepo;
	
	public StudentDetails register(StudentDetailsInfo studentDetailsinfo) {
		return StudentDetailsRepo.save(studentDetailsinfo.converToEntity());
	}
	
	public StudentDetails update(StudentDetails StudentDetails) {
		return StudentDetailsRepo.save(StudentDetails);
	}
	
	public List<StudentDetails> getAll() {
		return StudentDetailsRepo.findAll();
	}
	
	public Optional<StudentDetails> getById(Long id) {
		return StudentDetailsRepo.findById(id);
		
	}

}





