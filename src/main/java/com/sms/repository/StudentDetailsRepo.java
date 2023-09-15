package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.StudentDetails;

public interface StudentDetailsRepo  extends JpaRepository<StudentDetails, Long> {

}
