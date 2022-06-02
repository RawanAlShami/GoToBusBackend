package ejbs;

import java.util.HashSet;
import java.util.Set;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Stateless
@LocalBean
@Entity
public class User 
{
	//MEMBER VARIABLES
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int userId;
	String userName;
	String password;
	String fullName;
	String role;
	boolean loggedIn = false;
	
	@ManyToMany(mappedBy="users",fetch=FetchType.EAGER)
	private Set<Trip> trips=new HashSet<Trip>();
	
	@OneToMany(mappedBy="notificationId",fetch=FetchType.EAGER)
	private Set<Notifications> notifications=new HashSet<Notifications>();
	
	//DEFAULT CONSTRUCTOR
	public User(){}

	//PARAMETERIZED CONSTRUCTOR
    public User(String userName, String password, String fullName, String role) 
    {
    	this.userName=userName;
    	this.password=password;
    	this.fullName=fullName;
    	this.role=role;
    }

    //SETTERS AND GETTERS
	
	public void setUserName(String userName) {	this.userName = userName;	}
	public String getUserName() {	return userName;	}
	
	
	public void setPassword(String password) {	this.password = password;	}
	public String getPassword() {	return password;	}
	
	
	public void setFullName(String fullName) {	this.fullName = fullName;	}
	public String getFullName() {	return fullName;	}
	
	
	public void setRole(String role) {	this.role = role;	}
	public String getRole() {	return role;	}

	
	public void setLoggedIn(boolean loggedIn) {	this.loggedIn = loggedIn;	}
	public boolean isLoggedIn() {	return loggedIn;	}

	
	public void setTrips(Set<Trip> trips) {	this.trips = trips;	}
	public Set<Trip> getTrips() {	return trips;	}

	
	public void setNotifications(Set<Notifications> notifications) { this.notifications = notifications; }
	public Set<Notifications> getNotifications() { return notifications; }
	
    public void addTrip(Trip trip) {	this.trips.add(trip);	}
	
    public void addNotification(Notifications notification) { this.notifications.add(notification);	}
}