package hibernate.demo.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
			
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
		    
			Instructor tempInstructor=new Instructor("Karan","Aggarwal","karanaggarwal30@gmail.com");
			
			InstructorDetail tempDetail=new  InstructorDetail("http://www.tech4techies.com","Coding");
			
			tempInstructor.setInstructorDetail(tempDetail);
			
			session.save(tempInstructor);
			session.getTransaction().commit(); 
			
			
			
		}
		finally {
			factory.close();
		}
	}

}
