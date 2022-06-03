package ejbs;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Entity
public class Notifications 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int notificationId;
	String message;
	String currentTime;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private User user;
	
	Notifications(){}
	
	public Notifications(String message, String currentTime)
	{
		this.message=message;
		this.currentTime=currentTime;
	}
	
	public void setNotificationId(int notificationId) { this.notificationId = notificationId; }
	public int getNotificationId() { return notificationId; }
	
	public void setMessage(String message) { this.message = message;	}
	public String getMessage() {return message; }
	
	public void setCurrentTime(String currentTime) { this.currentTime = currentTime; }
	public String getCurrentTime() { return currentTime; }

	

	public void setUser(User user) {this.user = user;};
	
	
	
}
