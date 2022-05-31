package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
	public String createTrip(Trip trip) 
	{
		entityManager.persist(trip);
		if(trip==null)
			return "Failed To Add Trip";
		return "Trip Added Successfully";
	}
	
	
	@POST
	@Path("/searchTrip")
	public List<Trip> searchTrip(Trip testTrip)
	{
		//T.getToStation() T.getFromStation() T.getDepartureTime() T.getArrivalTime()
		
		/*List<Trip> trips=entityManager.createQuery("SELECT T FROM Trip T where T.getToStation()=:testTrip.getToStation() AND "
				+ "T.getFromStation()=:testTrip.getFromStation() AND T.getDepartureTime()=:testTrip.getDepartureTime() AND "
				+ "T.getArrivalTime()=:testTrip.getArrivalTime()").getResultList();*/
		
		
		
		return null;
	}
}
