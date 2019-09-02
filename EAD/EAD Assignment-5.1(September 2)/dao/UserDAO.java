package dao;
import model.User;
import java.util.*;
public class UserDAO {
List<User> userList;
private static UserDAO userd;
private UserDAO()
{
	userList=new ArrayList<User>();
}
public static UserDAO getInstnce()
{
	if(userd==null)
		userd=new UserDAO();
	return userd;
}

	public void addUser(User user)
	{
		userList.add(user);
	}
	public void deleteUser(User user)
	{
		userList.remove(user);
		
	}
public int getAllUser()
{
	return userList.size();
}

}
