package hibernate.demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(student.class).buildSessionFactory();
			
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
		
			System.out.println("Creating new Student Session");
			student tempstudent=new student("Karan","Aggarwal","abc@gmail.com");
			session.beginTransaction();
			System.out.println("Saving the Student");
			session.save(tempstudent);
			session.getTransaction().commit(); 
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
	}

}
