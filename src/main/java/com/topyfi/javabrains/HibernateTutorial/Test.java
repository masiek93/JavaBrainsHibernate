package com.topyfi.javabrains.HibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topyfi.javabrains.HibernateTutorial.dto.UserDetails;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for(int i=0; i<10; i++){
			UserDetails user = new UserDetails();
			user.setUserName("User " + i);
			session.save(user);
		}
		
		session.getTransaction().commit();
		session.close();
		
		session.close();
		sessionFactory.close();
	}
}
