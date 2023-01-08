package rentRoom;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import rentRoom.entity.Location;
import rentRoom.entity.myUser;

public class CreateUser {


	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(myUser.class)
							.addAnnotatedClass(Location.class)
							.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new user object");
			myUser tempUser = new myUser("password", "Adam", "Grey", "admin",
					"832142143", "klaudek1207@wp.pl");
			
			Location tempLocation = new Location("krakowska55", "52-424","Wroclaw");
			
			tempUser.setLocation(tempLocation);
			session.beginTransaction();
			
			System.out.println("Saving user" +tempUser);
			
			session.save(tempUser);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
	
	}

}
