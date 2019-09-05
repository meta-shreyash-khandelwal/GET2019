package facade;
import dao.UserDAO;
import java.util.*;
import model.User;
public class UserFacade {
static private UserFacade userFacade;
private UserDAO userdao;	
	private UserFacade(){
		userdao=UserDAO.getInstance();
	}
	
	public static UserFacade getInstance(){
		if(userFacade==null){
			return new UserFacade();
		}
		return userFacade;
	}
	
	public void addUser(User user)
	{
		userdao.addUser(user);
	}
	public void removeUser(User user)
	{
		userdao.deleteUser(user);
	}
	public User getUserByID(int id)
	{
		List<User> existingUser = userdao.getAll();
		for(User u : existingUser)
		{
			if(u.getUserID() == id)
			{
				return u;
			}
		}
		return null;
	}

	
}
