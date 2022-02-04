package com.luv2code.hibanate.demo;
 
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibanate.demo.entity.Student;

public class CreateStudentImagesMapDemo {

	public static void main(String[] args) {
		
     SessionFactory factory = new Configuration().
    		 				  configure("hibernate.cfg.xml").
    		 				  addAnnotatedClass(Student.class).
    		 				  buildSessionFactory();
		
		
     Session session = factory.getCurrentSession();
     
     
     try {
		
   
    	 Student tempStudent1 = new Student("husam", "ahmet", "husam@com");

    	
    	 Map<String, String> theImages = tempStudent1.getImages();
    	
    	 
    	 
     	 session.beginTransaction();
     	 
    	 theImages.put("resim1.jpg" , "Resim 1");
    	 theImages.put("resim2.jpg", "Resim 2");
    	 theImages.put("resim3.jpg", "Resim 3");
    	  
    	 
   
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
