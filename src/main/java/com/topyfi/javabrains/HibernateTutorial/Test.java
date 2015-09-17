package com.topyfi.javabrains.HibernateTutorial;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topyfi.javabrains.HibernateTutorial.dto.UserDetails;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String minUserId = "5";
		String userName = "User 10";
		
		Query query = session.createQuery("from UserDetails where userId > ? and userName = ?");
		query.setInteger(0, Integer.parseInt(minUserId));
		query.setString(1, userName);
		List<UserDetails> users = (List<UserDetails>) query.list();
		session.getTransaction().commit();
		session.close();
		
		//System.out.println("Size of list result: " + users.size());
		
		for(UserDetails u : users){
			System.out.println(u.getUserName());
		}
		sessionFactory.close();
	}
}
