package com.luv2code.hibanate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibanate.demo.entity.Instructor; 
import com.luv2code.hibanate.demo.entity.Student; 
public class CreateUserStudentInstrucvctorDemo {

	public static void main(String[] args) {
		
     SessionFactory factory = new Configuration().
    		 				  configure("hibernate.cfg.xml").
    		 				  addAnnotatedClass(Student.class).
    		 				  addAnnotatedClass(Instructor.class).
    		 				  buildSessionFactory();
		
		
     Session session = factory.getCurrentSession();
     
     
     try {
		
   
    	 Student tempStudent = new Student("alattin", "ahmet", "husam@com", " hibernate"  );
    	 Instructor tempInstructor = new Instructor("husam", "marry", "marrym@com", 2000.0  );
    	 
    	 
     	 session.beginTransaction();
    	  
    	 
   
    	 System.out.println("kaydediliyor");
    	 
    	 
    	 session.persist(tempStudent);

    	 session.persist(tempInstructor );
    	 
    	 
    	 session.getTransaction().commit();
    	 System.out.println("bitti");
    	 
    	 
    	 
	} finally {
		session.close();
		factory.close();
		
	} 
	}
}
