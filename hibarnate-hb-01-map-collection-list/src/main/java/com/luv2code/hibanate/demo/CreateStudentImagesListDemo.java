package com.luv2code.hibanate.demo;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibanate.demo.entity.Student;

public class CreateStudentImagesListDemo {

	public static void main(String[] args) {
		
     SessionFactory factory = new Configuration().
    		 				  configure("hibernate.cfg.xml").
    		 				  addAnnotatedClass(Student.class).
    		 				  buildSessionFactory();
		
		
     Session session = factory.getCurrentSession();
     
     
     try {
		
   
    	 Student tempStudent1 = new Student("husam", "ahmet", "husam@com");

    	 List<String> theImages1 = tempStudent1.getImages();
    	
    	 
     	 session.beginTransaction();
    	 theImages1.add("resim1.jpg");
    	 theImages1.add("resim2.jpg");
    	 theImages1.add("resim3.jpg");
    	 theImages1.add("resim4.jpg");
    	 theImages1.add("resim4.jpg");
    	  
    	 
   
    	 System.out.println("kaydediliyor");
    	 session.persist(tempStudent1);
    	
    	 
    	 session.getTransaction().commit();
    	 System.out.println("bitti");
    	 
    	 
    	 
	} finally {
		session.close();
		factory.close();
		
	} 
	}
}
