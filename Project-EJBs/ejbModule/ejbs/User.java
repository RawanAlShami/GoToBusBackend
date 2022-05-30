package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class User 
{
	//MEMBER VARIABLES
	String userName;
	String password;
	String fullName;
	String role;
	
	//CONSTRUCTOR
    public User() {}
    

    //SETTERS AND GETTERS
	public void setUserName(String userName) {	this.userName = userName;	}
	public String getUserName() {	return userName;	}
	
	
	public void setPassword(String password) {	this.password = password;	}
	public String getPassword() {	return password;	}
	
	
	public void setFullName(String fullName) {	this.fullName = fullName;	}
	public String getFullName() {	return fullName;	}
	
	
	public void setRole(String role) {	this.role = role;	}
	public String getRole() {	return role;	}

}