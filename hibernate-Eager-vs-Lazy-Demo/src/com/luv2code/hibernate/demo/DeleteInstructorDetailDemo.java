package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
			 session.beginTransaction();
			 
			 int theId =4;
			
			 InstructorDetail  detail = session.get(InstructorDetail.class, theId);
			 
			 System.out.println(" eðitimen detayi" +detail);

			 System.out.println("burasý ne Eðitmeni" +detail.getInstructor());
			 
			 detail.getInstructor().setInstructorDetail(null);
			  
			 session.delete(detail);
			 
			session.getTransaction().commit();
			System.out.println("bitti");
			
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
