package controller;
import model.*;
import facade.*;
public class UserController {
	UserFacade userFacade;
	static private UserController userController;
private UserController(){
	userFacade=UserFacade.getInstance();
	}

	public static UserController getInstance(){
		if(userController==null){
			return new UserController();
		}
		return userController;
	}
	
	
	public void addUser(User user){
			
			userFacade.addUser(user);
		}
	public User getUserByID(int userID)
	{
		return userFacade.getUserByID(userID);
	}
	}
