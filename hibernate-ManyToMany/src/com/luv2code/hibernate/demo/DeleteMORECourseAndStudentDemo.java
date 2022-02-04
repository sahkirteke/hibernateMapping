package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteMORECourseAndStudentDemo {

	public static void main(String[] args) {
		 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			  
			int courseId = 18;
			Course tempCourse = session.get(Course.class, courseId);
			System.out.println("kurs siliniyor " + tempCourse);
			
			session.delete(tempCourse);
			
			
			session.getTransaction().commit();
			System.out.println("bitti");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
