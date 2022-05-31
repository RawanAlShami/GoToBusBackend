package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.Id;


@Stateless
@LocalBean
@Entity
public class Trip 
{
	//ATTRIBUTES
	@Id
	private int tripId;
	private String fromStation;
	private String toStation;
	private int availableSeats;
	private String arrivalTime;
	private String departureTime;
	
	//CONSTRUCTOR
    public Trip() {}

    
    public Trip(int tripId,String fromStation,String toStation,int availableSeats,String arrivalTime,String departureTime) 
    {
    	this.tripId=tripId;
    	this.fromStation=fromStation;
    	this.toStation=toStation;
    	this.availableSeats=availableSeats;
    	this.arrivalTime=arrivalTime;
    	this.departureTime=departureTime;
    }
    
    
    //SETTERS AND GETTERS
	public int getTripId() {	return tripId;	}
	public void setTripId(int tripId) {	this.tripId = tripId;	}
	
	
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

}
