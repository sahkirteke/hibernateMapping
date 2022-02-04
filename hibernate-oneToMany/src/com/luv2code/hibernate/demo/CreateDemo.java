package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
			
			Instructor tempInstructor = new Instructor("husanmee","kirrrrrteeke","hsam@com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.yourubesssssss.com","kodsssss yazmak");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			System.out.println("kaydediliyor"+ tempInstructor);
			session.save(tempInstructor);
			
		
			
			session.getTransaction().commit();
			System.out.println("bitti");
			
		} finally {
			factory.close();
		}

	}

}
