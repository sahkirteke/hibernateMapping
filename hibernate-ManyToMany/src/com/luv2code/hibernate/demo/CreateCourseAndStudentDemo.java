package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			Course tempCourse = new Course("Pacrrman -dersleri");
		
			System.out.println("  kurs kaydedilir");
			session.save(tempCourse);
			System.out.println("*****************");
			System.out.println("kaydedildi" +tempCourse);
			
			Student tempStudent = new Student("husamettirrn", "kirtrreke", "hrusam@com");
			Student tempStudent1 = new Student("seydarr", "kasrya", "asrya@com");
			
			tempCourse.addStudent(tempStudent);
			tempCourse.addStudent(tempStudent1);
			System.out.println("\n kaydeliyor ÖÐRENCÝ  ");
		
			session.save(tempStudent1);
			session.save(tempStudent);
			System.out.println("öðrenciler kaydedilgi" +tempCourse.getStudents());
			
			session.getTransaction().commit();
			System.out.println("bitti");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
