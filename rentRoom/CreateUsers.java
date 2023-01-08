package rentRoom;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import rentRoom.entity.Location;
import rentRoom.entity.Room;
import rentRoom.entity.myUser;

public class CreateUsers {


	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(myUser.class)
							.addAnnotatedClass(Location.class)
							.addAnnotatedClass(Room.class)
							.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new user object");
			myUser tempUser = new myUser("password", "Adam", "Grey", "admin",
					"832142143", "klaudek1207@wp.pl");
			myUser tempUser2 = new myUser("pass", "maria", "addams", "user",
					"65453442", "klaudiuszkudla15@gmail.com");
			myUser tempUser3 = new myUser("password", "John", "Doe", "admin",
					"13434356", "JohnDoe1232@wp.pl");
			
			Location tempLocation1 = new Location("krakowska23", "52-424","Wroclaw");
			Location tempLocation2 = new Location("krakowska11", "52-424","Wroclaw");
			Location tempLocation3 = new Location("krakowska43", "52-432","Warsaw");
			
			tempUser.setLocation(tempLocation1);
			tempUser2.setLocation(tempLocation2);
			tempUser3.setLocation(tempLocation3);
			session.beginTransaction();
			
			System.out.println("Saving user");
			
			session.save(tempUser);
			session.save(tempUser2);
			session.save(tempUser3);
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
	
	}

}
