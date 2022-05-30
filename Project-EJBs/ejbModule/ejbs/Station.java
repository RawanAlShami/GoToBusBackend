package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class Station 
{
	//ATTRIBUTES
	String name;
	String latitude;
	String longitude;

	//CONSTRUCTOR
	public Station() {}
	
	
	//SETTERS AND GETTERS
	public void setName(String name) {	this.name = name;	}
	public String getName() {	return name;	}

	
	public void setLatitude(String latitude) {	this.latitude = latitude;	}
	public String getLatitude() {	return latitude;	}

	public void setLongitude(String longitude) {	this.longitude = longitude;	}
	public String getLongitude() {	return longitude;	}

}
