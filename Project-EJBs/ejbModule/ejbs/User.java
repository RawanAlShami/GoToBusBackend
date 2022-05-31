package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Stateless
@LocalBean
@Entity
public class User 
{
	//MEMBER VARIABLES
	@Id
	String userName;
	String password;
	String fullName;
	String role;
	boolean loggedIn = false;

	//DEFAULT CONSTRUCTOR
	public User(){}
	
	
	//PARAMETERIZED CONSTRUCTOR
    public User(String userName, String password, String fullName, String role) 
    {
    	this.userName=userName;
    	this.password=password;
    	this.fullName=fullName;
    	this.role=role;
    }
    

    //SETTERS AND GETTERS
	public void setUserName(String userName) {	this.userName = userName;	}
	public String getUserName() {	return userName;	}
	
	
	public void setPassword(String password) {	this.password = password;	}
	public String getPassword() {	return password;	}
	
	
	public void setFullName(String fullName) {	this.fullName = fullName;	}
	public String getFullName() {	return fullName;	}
	
	
	public void setRole(String role) {	this.role = role;	}
	public String getRole() {	return role;	}

	
	public void setLoggedIn(boolean loggedIn) {	this.loggedIn = loggedIn;	}
	public boolean isLoggedIn() {	return loggedIn;	}
	
}