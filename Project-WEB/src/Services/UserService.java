package Services;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejbs.User;


@Stateless
@Path("/apiUser")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserService 
{
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
	@Path("/userLogin")
	public String loginAsUser(User testUser)
	{
		User user=entityManager.find(User.class, testUser.getUserName());
			
		if(user==null)
			return "Invalid UserName Provided";
		else
		{
			if(user.getPassword().equals(testUser.getPassword()))
			{
				user.setLoggedIn(true);
				return "User Logged In Successfully";
			}
			return "Invalid Password Provided";
		}
	}
	
	
	@GET
	@Path("/getUser/{username}")
	public User getUserByUserName(@PathParam("username") String username)
	{
		return entityManager.find(User.class, username);
	}
	
}