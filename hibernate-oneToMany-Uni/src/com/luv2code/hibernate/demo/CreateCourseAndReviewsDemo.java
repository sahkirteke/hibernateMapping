package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman -dersleri");
			tempCourse.addReview(new Review("harika bir kurs cok sevdim"));
			tempCourse.addReview(new Review("bok gibi kurs"));
			tempCourse.addReview(new Review("boyle kursa sokam"));
			
			System.out.println("kaydediliyor");
			System.out.println(tempCourse);
			System.out.println("***************************");
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
			
			session.getTransaction().commit();
			System.out.println("bitti");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
