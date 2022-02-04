package com.luv2code.hibanate.demo;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibanate.demo.entity.Address;
import com.luv2code.hibanate.demo.entity.Student;

public class CreateStudentAdressDemo {

	public static void main(String[] args) {
		
     SessionFactory factory = new Configuration().
    		 				  configure("hibernate.cfg.xml").
    		 				  addAnnotatedClass(Student.class).
    		 				  addAnnotatedClass(Address.class).
    		 				  buildSessionFactory();
		
		
     Session session = factory.getCurrentSession();
     
     
     try {
		
   
    	 Student tempStudent1 = new Student("alattin", "ahmet", "husam@com");
    	 Address billingAddress = new Address("billik", "billikssss", "0000000");
    	 
    	 
     	 session.beginTransaction();
    	 
    	 
   
    	 System.out.println("kaydediliyor");
    	 
    	 tempStudent1.setBillingAddress(billingAddress);
    	 session.persist(tempStudent1);
    	 
    	 
    	 session.getTransaction().commit();
    	 System.out.println("bitti");
    	 
    	 
    	 
	} finally {
		session.close();
		factory.close();
		
	} 
	}
}
