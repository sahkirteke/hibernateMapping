package com.luv2code.hibanate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibanate.demo.entity.Student;

public class GetStudentImagesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				  configure("hibernate.cfg.xml").
				  addAnnotatedClass(Student.class).
				  buildSessionFactory();


		Session session = factory.getCurrentSession();

		
		try {
			int theId=1;
			session.beginTransaction();
			
			Student student = session.get(Student.class, theId);
			
			System.out.println( "ogrenci bilgirilkeri" +student); 
			System.out.println("---------------------------------");
			
			System.out.println("rewsimlerin sıralannoış hali" +student.getImages());
			
			session.getTransaction().commit();
			
			System.out.println("**********************");
			System.out.println("bitti");
			
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
