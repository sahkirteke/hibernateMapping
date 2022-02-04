package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateMORECourseAndStudentDemo {

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
			 
			int theId =5 ;
			
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("\n getririldi husam  : " +tempStudent);
			
			System.out.println("\n kursu : " + tempStudent.getCourses());
			
			Course tempCourse1= new Course("rubirrk kup kursu");
			Course tempCourse2 = new Course("oyurn  programlama kursu");
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			 
			System.out.println("\n kursalar kaydedilitýr");
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			
			session.getTransaction().commit();
			System.out.println("bitti");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
