package com.topyfi.javabrains.HibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topyfi.javabrains.HibernateTutorial.dto.UserDetails;

public class Test {

	public static void main(String[] args) {
		/*UserDetails user1 = new UserDetails();
		user1.setUserName("Marta");

		UserDetails user2 = new UserDetails();
		user2.setUserName("Tomek");
*/		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.save(user1); session.save(user2);
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		//user.setUserName("New one after session close333");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
		sessionFactory.close();
	}
}
