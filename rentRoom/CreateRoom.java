package rentRoom;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import rentRoom.entity.Location;
import rentRoom.entity.Room;
import rentRoom.entity.myUser;

public class CreateRoom {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				.addAnnotatedClass(myUser.class)
				.addAnnotatedClass(Location.class)
				.addAnnotatedClass(Room.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			int theId=1;
			myUser tempUser = session.get(myUser.class, 2);
			Location tempLocation = session.get(Location.class, 3);
			Location tempLocation2 = session.get(Location.class, 2);
			
			Room tempRoom1 = new Room(2, "available", "office", 40);
			Room tempRoom2 = new Room(24, "available", "office", 80);
			tempRoom1.setLocation(tempLocation);
			tempRoom2.setLocation(tempLocation2);
			
			tempUser.add(tempRoom2);
			tempUser.add(tempRoom1);
		
			session.save(tempRoom2);
			session.save(tempRoom1);

			session.getTransaction().commit();

		

		} finally {
			factory.close();
		}
	}

}
