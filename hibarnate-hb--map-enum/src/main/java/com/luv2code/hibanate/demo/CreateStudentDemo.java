package com.luv2code.hibanate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibanate.demo.entity.Status;
import com.luv2code.hibanate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
     SessionFactory factory = new Configuration().
    		 				  configure("hibernate.cfg.xml").
    		 				  addAnnotatedClass(Student.class). 
    		 				  buildSessionFactory();
		
		
     Session session = factory.getCurrentSession();
     
     
     try {
		
   
    	 Student tempStudent1 = new Student("alattin", "ahmet", "husam@com" ,Status.ACTIVE);
    	 Student tempStudent2 = new Student("husam", "marry", "marrym@com" ,Status.INACTIVE);
    	 
    	 
     	 session.beginTransaction();
    	 
    	 
   
    	 System.out.println("kaydediliyor");
    	 
    	 
    	 session.persist(tempStudent1);

    	 session.persist(tempStudent2);
    	 
    	 
    	 session.getTransaction().commit();
    	 System.out.println("bitti");
    	 
    	 
    	 
	} finally {
		session.close();
		factory.close();
		
	} 
	}
}
