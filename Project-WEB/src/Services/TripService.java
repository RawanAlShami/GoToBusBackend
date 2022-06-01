package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejbs.Station;
import ejbs.Trip;
import ejbs.User;


@Stateless
@Path("/apiTrip")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TripService 
{
	@EJB
	Trip trip;
	
	@PersistenceContext(unitName="hello")
	EntityManager entityManager;

		
	@POST
	@Path("/trip")
	public Trip createTrip(Trip trip) 
	{
		/*{"tripId":2,
			"fromStation":1,
			"toStation": 2,
			"availableSeats": 20,
			"departureTime": "25/05/2022 15:00:00", "arrivalTime": "25/05/2022 20:00:00"
		}*/
		
		entityManager.persist(trip);
		if(trip==null)
			return trip;
		return trip;
	}
	
	//WE NEED TO ADD FROM AND TO DATES AND GET ALL TRIPS IN BETWEEN 
	@POST
	@Path("/searchTrip")
	public List<Trip> searchTrip(Trip testTrip)
	{
		String fromStation=testTrip.getFromStation();
		String toStation=testTrip.getToStation();
		
		TypedQuery<Trip> t=entityManager.createQuery("SELECT T FROM Trip T where T.fromStation=:fromStatId AND T.toStation=:toStatId" , Trip.class);
		t.setParameter("fromStatId", fromStation);
		t.setParameter("toStatId", toStation);
		List<Trip> trips=t.getResultList();
		return trips;
		
	}
	
}
