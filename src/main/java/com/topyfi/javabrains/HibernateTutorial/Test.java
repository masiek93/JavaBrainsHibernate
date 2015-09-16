package com.topyfi.javabrains.HibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topyfi.javabrains.HibernateTutorial.dto.UserDetails;
import com.topyfi.javabrains.HibernateTutorial.dto.Vehicle;

public class Test {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		Vehicle vehicle = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		
		user.setUserName("Marta");
		vehicle.setVehicleName("Audi");
		vehicle2.setVehicleName("BMW");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
	}
}
