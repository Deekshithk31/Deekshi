package com.abc.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abc.Entity.Employee;
import com.abc.Entity.Project;

public class App {

	public static void main(String[] args) 
	{
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class).buildSessionFactory();
        
		Session session = factory.openSession();
		try
		{
			Transaction t=session.beginTransaction();
			Project p = new Project("yes bank App");
			session.save(p);
			
			Employee e1 = new Employee("bruuu", "bru@gmail.com");
			Employee e2 = new Employee("dee", "deeu@gmail.com");
			p.addEmployee(e1);
			p.addEmployee(e2);
			
			session.save(e1);
			session.save(e2);
			t.commit();
			
		}
		catch (Exception e) 
		{
			System.out.println("some problem");
		}
		finally 
		{
			factory.close();
			session.close();
		}
		
		
	}

}
