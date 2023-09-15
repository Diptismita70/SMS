package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ams.exception.UserNotFoundException;
import com.sms.bean.StudentDetailsInfo;
import com.sms.entity.StudentDetails;
import com.sms.repository.StudentDetailsRepo;
import com.sms.service.StudentDetailsService;

@RestController
@RequestMapping("studentdetails")

public class StudentDetailsController 
  {
	@Autowired
	StudentDetailsService studentdetailsService;
	
	@Autowired
	StudentDetailsRepo StudentDetailsRepo;
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	StudentDetails register(@RequestBody StudentDetailsInfo studentDetailsInfo) {
		return studentdetailsService.register(studentDetailsInfo);		
	}
	 @PutMapping("/edit/{id}")
	 StudentDetails update(@RequestBody StudentDetails newUser, @PathVariable Long id) {
	        return StudentDetailsRepo.findById(id)
	                .map(user -> {
	                    user.setName(newUser.getName());
	                    user.setStandard(newUser.getStandard());
	                    user.setRollNo(newUser.getRollNo());
	                    user.setDob(newUser.getDob());
	                    user.setFathersName(newUser.getFathersName());
	                    user.setMothersName(newUser.getMothersName());
	                    return StudentDetailsRepo.save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<StudentDetails> getAll(){
		
		return StudentDetailsRepo.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
   StudentDetails getUserById(@PathVariable Long id) {
        return StudentDetailsRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!StudentDetailsRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        StudentDetailsRepo.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

}


