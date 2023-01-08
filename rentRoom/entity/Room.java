package rentRoom.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private int id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
    private myUser user2;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	private Location location;
	
	@Column(name = "room_size")
	private int roomSize;
	
	@Column(name = "room_status")
	private String roomStatus;
	
	@Column( name = "room_type")
	private String roomType;
	
	@Column( name = "room_capacity")
	private int roomCapacity;
	
	
	
	public Room() {
		
	}

	

	public Room(int roomSize, String roomStatus, String roomType, int roomCapacity) {
		super();
		this.roomSize = roomSize;
		this.roomStatus = roomStatus;
		this.roomType = roomType;
		this.roomCapacity = roomCapacity;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	
	
	


	public myUser getUser() {
		return user2;
	}

	public void setUser(myUser user2) {
		this.user2 = user2;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", location=" + location + ", roomSize=" + roomSize
				+ ", roomStatus=" + roomStatus + ", roomType=" + roomType + ", roomCapacity=" + roomCapacity + "]";
	}
	
	

}
