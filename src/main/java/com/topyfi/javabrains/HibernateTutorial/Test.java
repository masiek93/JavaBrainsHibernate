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
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
		//session.delete(user);
		user.setUserName("Hi im new");
		session.update(user);
		session.getTransaction().commit();
		session.close();
		//System.out.println("User name -> " + user.getUserName());
		sessionFactory.close();
	}
}
