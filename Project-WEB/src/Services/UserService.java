package Services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ejbs.Notifications;
import ejbs.Trip;
import ejbs.User;
import ejbs.ids;


@Stateless
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserService 
{
	/*{"fromStation":"Cairo",
"toStation": "Giza",
"availableSeats": 10,
"departureTime": "25/05/2022 15:00:00", "arrivalTime": "25/05/2022 20:00:00"
}*/
/*{
    "userName": "Mado",
    "password": "123456",
    "fullName": "Mohammed Kelany",
    "role": "User"
}
*/
	/*{"tripId":4,
"userId":1}*/
	@EJB
	User user;
	
	@PersistenceContext(unitName="hello")
	EntityManager entityManager;
		
	@POST
	@Path("/user")
	public String registerUser(User user) 
	{
		entityManager.persist(user);
		if(user==null)
			return "Failed To Add User";
		return "User Added Successfully";
	}
	
	
	@POST
	@Path("/login")
	public String loginAsUser(User testUser)
	{
		String testUserName=testUser.getUserName();
		String testPassword=testUser.getPassword();
		
		TypedQuery<User> u=entityManager.createQuery("SELECT U FROM User U where U.userName=:testUserName AND U.password=:testPassword" , User.class);
		u.setParameter("testUserName", testUserName);
		u.setParameter("testPassword", testPassword);
		List<User> users=u.getResultList();
		
		if(users.isEmpty())
			return "Invalid Credidentials Provided";
		else
		{
			users.get(0).setLoggedIn(true);
			return "User Logged In Successfully";
		}
	}
	
	
	@GET
	@Path("/getUser/{username}")
	public User getUserByUserName(@PathParam("username") String username)
	{	
		String uname=username;
		
		TypedQuery<User> u=entityManager.createQuery("SELECT U FROM User U where U.userName=:uname" , User.class);
		u.setParameter("uname", uname);
		List<User> users=u.getResultList();
		
		return users.get(0);
	}
	
	@POST
	@Path("/booktrip")
	public User bookTrip(ids userTripId)
	{
		int testUserId=userTripId.getUserId();
		int testTripId=userTripId.getTripId();
		
		User user=entityManager.find(User.class, testUserId);
		Trip trip=entityManager.find(Trip.class, testTripId);
		
		int availableSeats=trip.getAvailableSeats();
		String fromStation=trip.getFromStation();
		String toStation=trip.getToStation();
		
		LocalDateTime LocalDateTimeNow = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formattedDateAndTime = LocalDateTimeNow.format(dateTimeFormatter);
		//if(user.isLoggedIn()) {
		if(availableSeats>1)
		{
			user.addTrip(trip);
			trip.addUser(user);
			
			Notifications bookTripNotification=new Notifications("You have booked a trip from "+ fromStation+ " to "+ toStation +" successfully",formattedDateAndTime);
			entityManager.persist(bookTripNotification);
			user.addNotification(bookTripNotification);
			bookTripNotification.setUser(user);
			
			
		}
		else
		{
			Notifications bookTripNotification=new Notifications("Sorry, trip "+ fromStation+ " to "+ toStation +" has no available seats",formattedDateAndTime);
			entityManager.persist(bookTripNotification);
			user.addNotification(bookTripNotification);
			bookTripNotification.setUser(user);
			
		}
		return user;
		//}else
			//return null;
	}
	
	@GET
	@Path("/viewtrips/{userId}")
	public Set<Trip> viewUserTrips(@PathParam("userId") int userId)
	{
		User user=entityManager.find(User.class, userId);
		return user.getTrips();
	}
	
	@GET
	@Path("/notifications/{user_id}")
	public Set<Notifications> showUserNotifications(@PathParam("userId") int userId)
	{
		int uID=userId;
		User user=entityManager.find(User.class, uID);
		return user.getNotifications();
	}
	
}