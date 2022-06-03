package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.Id;


@Stateless
@LocalBean
@Entity
public class Station 
{
	//ATTRIBUTES
	@Id
	String name;
	String latitude;
	String longitude;

	//CONSTRUCTOR
	public Station() {}
	
	
	//PARAMETERIZED CONSTRUCTOR
	public Station(String name, String latitude, String longitude)
	{
		this.name=name;
		this.latitude=latitude;
		this.longitude=longitude;
	}
	
	
	//SETTERS AND GETTERS
	public void setName(String name) {	this.name = name;	}
	public String getName() {	return name;	}

	
	public void setLatitude(String latitude) {	this.latitude = latitude;	}
	public String getLatitude() {	return latitude;	}

	public void setLongitude(String longitude) {	this.longitude = longitude;	}
	public String getLongitude() {	return longitude;	}
	

}