package svk1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
import vk.JDBCConnection;

/**
 * Servlet implementation class LoginEmployee
 */
@WebServlet("/LoginEmployee")
public class LoginEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userEmail = "";
		String loginPassword = "";
		int counter=0;
	int k=0;
		String regex1 = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (request.getParameter("loginEmail") != null) {
			userEmail = request.getParameter("loginEmail");
			if (!userEmail.matches(regex1))
			{
				counter=1;
				out.println("<br><b>Sorry !!  email</b><br>");
			}

		} else {
			out.println("<br><b>Sorry !! Please Enter email and try again</b><br>");
		}
	if (request.getParameter("loginPassword") != null &&  request.getParameter("loginPassword").length()!=0) {
		loginPassword = request.getParameter("loginPassword");
		} else {
			counter=1;
			out.println("<br><b>Sorry !! Please Enter nd try again</b><br>");
		}
	System.out.println("user name"+userEmail);
	System.out.println("login name"+loginPassword);
	
	if(counter==0)
{
		try { 
         // Initialize the database 
         Connection connect = JDBCConnection.connectionQuery("employee","root","root");
         PreparedStatement statement = connect.prepareStatement("select * from  employeedetail where email=? and password=?");
         statement.setString(1,userEmail); 
         statement.setString(2,loginPassword); 
         ResultSet result=statement.executeQuery(); 
while(result.next())
{
	k++;
}
         // Close all the connections 
	      	statement.close(); 
     
 if(k!=0)
 {
         //connect.close();
     
     out.println("<body><html><br><b>You have successfully logged in</b><br></body></html>");
      
	/* PreparedStatement statement1 = connect.prepareStatement("select * from  employeedetail where email=? and password=?");
     statement1.setString(1,userEmail); 
     statement1.setString(2,loginPassword); 
     ResultSet result1=statement.executeQuery(); 
while(result1.next())
{
	
}
	 */
	 HttpSession session=request.getSession();  
     session.setAttribute("nameEmail",userEmail); 
       out.println("<html><body align='right'><br><b>Here are the details </b><br></body></html>");
      PreparedStatement statement1 = connect.prepareStatement("select * from employeedetail " + 
     		" inner join vehicle on " + 
     		" vehicle.email=employeedetail.email " + 
     		" inner join pass on " + 
     		" vehicle.vid=pass.vid " + 
     		" where employeedetail.email='"+userEmail+"'");

ResultSet result1=statement1.executeQuery();
out.println("<html><body align='right'><br><a style=\"float: right;\" href='logout'>Logout</a></body></html>");
		out.println("<html><body><b>The list is as follows"
				+ "</b></body></html>");
		out.println("<br>");

		out.println("<html><body><table border='1'><tr><th>Name</th><th>Gender</th> <th>Email</th><th>contact</th><th>Organisation</th><th>Employee ID</th> <th>Vehicle Number</th><th>Type</th><th>Amount</th></tr>");
		while (result1.next()) {
			out.print("<tr><td>");
			out.print(result1.getString("name") + "\t");
			out.print("</td><td>");
			out.print(result1.getString("gender") + "\t");
			out.print("</td>");
			out.print("<td>");
			out.print(result1.getString("email") + "\t");
			out.print("</td>");
			out.print("<td>");
			out.print(result1.getInt("contact") + "\t");
			out.print("</td>");
			out.print("<td>");
			out.print(result1.getString("organisation") + "\t");
			session.setAttribute("organEmployee",result1.getString("organisation")); 
			out.print("</td>");
			out.print("<td>");
			out.print(result1.getInt("employeeid") + "\t");
			out.print("</td>");
			out.print("<td>");
			out.print(result1.getString("vehicleNumber") + "\t");
			out.print("</td>");
			out.print("<td>");
			out.print(result1.getString("type") + "\t");
			out.print("</td>");
			out.print("<td>");
			out.print(result1.getString("amount") + "\t");
			out.print("</td>");
		}
		out.println("</table></body></html>");
	
 
	     out.println("<html><body><br><a href='updateEmployee'>Edit Button</a></body></html>");
	     out.println("<html><body><br><a href='friendE'>Friends</a></body></html>");
	     connect.close();
     
     
     //RequestDispatcher requestDispatch=request.getRequestDispatcher("updateEmployee");  
     //requestDispatch.forward(request, response);  
     
	 
	 
	     	
     }
 else
 {
	   out.println("<body><html><br><b>Not entered corerct login detail and/or not registered !!! Try Again </b><br></body></html>");

		RequestDispatcher rdObject = request.getRequestDispatcher("/index1.html");
		rdObject.include(request, response);	
 }
		}
     catch (Exception e) { 
         e.printStackTrace(); 
     } 
	
counter=0;
}

}

}
