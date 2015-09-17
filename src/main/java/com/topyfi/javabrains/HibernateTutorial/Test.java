package com.topyfi.javabrains.HibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topyfi.javabrains.HibernateTutorial.dto.UserDetails;

public class Test {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("Marta");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		user.setUserName("Update when session still open");
		
		session.getTransaction().commit();
		session.close();
		user.setUserName("Update when session is closed");
		sessionFactory.close();
	}
}
