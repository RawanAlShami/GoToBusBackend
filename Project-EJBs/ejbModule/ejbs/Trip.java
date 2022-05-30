package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Date;


@Stateless
@LocalBean
public class Trip 
{
	//ATTRIBUTES
	private String fromStation;
	private String toStation;
	private int availableSeats;
	private Date arrivalTime;
	private Date departureTime;
	
	//CONSTRUCTOR
    public Trip() {}

    
    //SETTERS AND GETTERS
	public void setFromStation(String fromStation) {  this.fromStation = fromStation;	}
	public String getFromStation() {  return fromStation;	}

	public void setToStation(String toStation) {  this.toStation = toStation;	}
	public String getToStation() {	return toStation;	}

	
	public void setAvailableSeats(int availableSeats) {	this.availableSeats = availableSeats;	}
	public int getAvailableSeats() {  return availableSeats;  }

	
	public void setArrivalTime(Date arrivalTime) {	this.arrivalTime = arrivalTime;	}
	public Date getArrivalTime() {	return arrivalTime;	}

	
	public void setDepartureTime(Date departureTime) {	this.departureTime = departureTime;	}
	public Date getDepartureTime() {  return departureTime;	}

}
