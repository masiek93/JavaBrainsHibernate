package com.topyfi.javabrains.HibernateTutorial;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topyfi.javabrains.HibernateTutorial.dto.Address;
import com.topyfi.javabrains.HibernateTutorial.dto.UserDetails;

public class Test {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		Address address = new Address();
		address.setStreet("Na Uboczu");
		address.setCity("Warsaw");
		user.setUserName("Marta");
		user.setAddress(address);
		user.setJoinedDate(new Date());
		user.setDescription("Decription... anything");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Name : " + user.getUserName());
		session.close();
		sessionFactory.close();
	}
}
