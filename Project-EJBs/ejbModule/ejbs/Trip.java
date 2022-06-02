package ejbs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;


@Stateless
@LocalBean
@Entity
public class Trip 
{
	//ATTRIBUTES
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int tripId;
	String fromStation;
	String toStation;
	int availableSeats;
	String arrivalTime;
	String departureTime;


	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="UsersTrips",joinColumns=@JoinColumn(name="TripID"),inverseJoinColumns=@JoinColumn(name="UserID"))
	private Set<User> users=new HashSet<User>();
	
	//CONSTRUCTOR
    public Trip() {}

    
    public Trip(String fromStation,String toStation,int availableSeats,LocalDateTime arrivalTime,LocalDateTime departureTime) 
    {
    	DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    	String formattedArrivalDate= arrivalTime.format(dateTimeFormatter);
    	String formattedDepartureDate=departureTime.format(dateTimeFormatter);
    	
    	this.fromStation=fromStation;
    	this.toStation=toStation;
    	this.availableSeats=availableSeats;
    	this.arrivalTime=formattedArrivalDate;
    	this.departureTime=formattedDepartureDate;
    }

	//SETTERS AND GETTERS
	public void setTripId(int tripId) {	this.tripId = tripId;	}
    public int getTripId() { return tripId; }
    
    
	public void setFromStation(String fromStation) {  this.fromStation = fromStation;	}
	public String getFromStation() {  return fromStation;	}

	public void setToStation(String toStation) {  this.toStation = toStation;	}
	public String getToStation() {	return toStation;	}

	
	public void setAvailableSeats(int availableSeats) {	this.availableSeats = availableSeats;	}
	public int getAvailableSeats() {  return availableSeats;  }

	
	public void setArrivalTime(String arrivalTime) {	this.arrivalTime = arrivalTime;	}
	public String getArrivalTime() {	return arrivalTime;	}

	
	public void setDepartureTime(String departureTime) {	this.departureTime = departureTime;	}
	public String getDepartureTime() {  return departureTime;	}
	
	
	public void setUsers(Set<User> users) {	this.users = users;	}
	
	public void addUser(User user) { this.users.add(user); }
   
}
