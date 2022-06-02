package Services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejbs.Station;


@Stateless
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StationService 
{
	@EJB
	Station station;
	
	@PersistenceContext(unitName="hello")
	EntityManager entityManager;

		
	@POST
	@Path("/station")
	public String createStation(Station station) 
	{
		entityManager.persist(station);
		if(station==null)
			return "Failed To Add Station";
		return "Station Added Successfully";
	}
	
	
	@GET
	@Path("/station/{stationName}")
	public Station getUserByUserName(@PathParam("stationName") String stationName)
	{
		return entityManager.find(Station.class, stationName);
	}
	
}