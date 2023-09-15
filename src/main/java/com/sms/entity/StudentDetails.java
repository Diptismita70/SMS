package com.sms.entity;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="studentdetails")

public class StudentDetails 
 {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column
   private String name;
   @Column
   private String standard;
   @Column
   private String rollNo;
   @Column
   private Date dob;
   @Column
   private String fathersName;
   @Column
   private String mothersName;
   @Column
   private String contactNo;
   @Column
   private String address;
}
