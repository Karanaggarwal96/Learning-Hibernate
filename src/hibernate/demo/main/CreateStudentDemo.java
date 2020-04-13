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
		
		
			session.beginTransaction();
			List<student> theStudents=session.createQuery("from student").getResultList();
			
			for(student tempStudent: theStudents)
			{
				System.out.println(tempStudent);
			}
			
			theStudents=session.createQuery("from student s where s.firstname='Karan'").list();
			
			for(student tempStudent: theStudents)
			{
				System.out.println(tempStudent);
			}
			session.getTransaction().commit(); 
			
			
			
			
		}
		finally {
			factory.close();
		}
	}

}
