package hibernate.demo.main;

import java.util.List;

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
			int studentId=1;
		
			session.beginTransaction();
		    student  myStudent=session.get(student.class, studentId);	
		    myStudent.setFirstname("Scooby");
			session.getTransaction().commit(); 
			
			Session session1=factory.getCurrentSession();
			session1.beginTransaction();
		    
			session1.createQuery("update student set email='hij@gmail.com'").executeUpdate();
			session1.getTransaction().commit(); 
			
			
			
		}
		finally {
			factory.close();
		}
	}

}
