package ejbs;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;


@Stateless
@LocalBean
@Entity
public class User 
{
	//MEMBER VARIABLES
	@Id
	int userId;
	String userName;
	String password;
	String fullName;
	String role;
	boolean loggedIn = false;
	
	@ManyToMany(mappedBy="users",fetch=FetchType.EAGER)
	private Set<Trip> trips=new HashSet<Trip>();

	//DEFAULT CONSTRUCTOR
	public User(){}
	
	
	


	public Set<Trip> getTrips() {return trips;}

	public void setTrips(Set<Trip> trips) {this.trips = trips;}





	//PARAMETERIZED CONSTRUCTOR
    public User(String userName, String password, String fullName, String role) 
    {
    	this.userName=userName;
    	this.password=password;
    	this.fullName=fullName;
    	this.role=role;
    }
    
    
    public void addTrip(Trip trip) {
    	this.trips.add(trip);
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
	
	public int getUserId() {return userId;}


	public void setUserId(int userId) {this.userId = userId;}

	
}