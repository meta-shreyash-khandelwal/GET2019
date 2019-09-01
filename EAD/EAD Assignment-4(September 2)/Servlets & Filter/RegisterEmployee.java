package svk1;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vk.JDBCConnection;

/**
 * Servlet implementation class RegisterEmployee
 */
@WebServlet("/RegisterEmployee")
public class RegisterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterEmployee() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// PrintWriter out = response.getWriter();
		// out.println("<html><body>sdfg sdg sdf</body></html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = "";
		String gender = request.getParameter("gender");
		String email = "";
		String password = "";
		String confirm = "";
		int eid=0;
		int contact = 0;
		int counter=0;
		String regex1 = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		// String regex2 ="/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/";
		String organisation = request.getParameter("organisation");
		PrintWriter out = response.getWriter();
		if (request.getParameter("name") != null &&  request.getParameter("name").length()!=0) {
			name = request.getParameter("name");
			
		} else {
		counter=1;
			out.println("<br><b>Sorry !! Please Enter the name and try again</b><br>");
		}
		gender = request.getParameter("gender");

		if (request.getParameter("email") != null) {
			email = request.getParameter("email");
			if (!email.matches(regex1))
			{
				counter=1;
				out.println("<br><b>Sorry !! Please Enter the correct email and try again</b><br>");
			}

		} else {
			out.println("<br><b>Sorry !! Please Enter email and try again</b><br>");
		}
		if (request.getParameter("employeeid") != null &&  request.getParameter("employeeid").length()!=0) {
			eid = Integer.valueOf(request.getParameter("employeeid"));
		} else {
			counter=1;
			out.println("<br><b>Sorry !! Please Enter EID and try again</b><br>");
		}
		if (request.getParameter("password") != null &&  request.getParameter("password").length()!=0) {
			password = request.getParameter("password");
		} else {
			counter=1;
			out.println("<br><b>Sorry !! Please Enter password and try again</b><br>");
		}
	
		if (request.getParameter("confirm") != null  && request.getParameter("confirm").length()!=0) {
			confirm = request.getParameter("confirm");
		} else {
			counter=1;
			out.println("<br><b>Sorry !! Please Enter confirm password and try again</b><br>");
		}
		if (!password.equals(confirm)) {
			counter=1;
			out.println("<br><b>Sorry !! Password and confirm password should match</b><br>");
		}
		if (request.getParameter("contact") != null && request.getParameter("contact").length()!=0) {
			contact = Integer.valueOf(request.getParameter("contact"));
			} else {
			counter=1;
			out.println("<br><b>Sorry !! Please Enter contact and try again</b><br>");
		}
		System.out.println("Password "+password);	
		System.out.println("Conform "+confirm);	
		System.out.println("Conform EID"+eid);
		System.out.println("CC "+counter);	
if(counter==0)
{ try { //System.out.println("DONE E E ");
         // Initialize the database 
         Connection connect = JDBCConnection.connectionQuery("employee","root","root");
         PreparedStatement statement = connect.prepareStatement("insert into employeedetail(name,gender,email,password,contact,organisation,employeeid) values(?,?,?,?,?,?,?)");
         statement.setString(1, name); 
         statement.setString(2, gender); 
         statement.setString(3,email); 
         statement.setString(4,password); 
         statement.setInt(5, contact); 
	   	 statement.setString(6, organisation); 
	   	statement.setInt(7, eid); 
	     
	   	 statement.executeUpdate(); 
      // Close all the connections 
	      	statement.close(); 
         connect.close(); 
        out.println("<br><b>Congratulations !!! You are registered with the following EmployeeID</b><br><b>Employee ID : </b>"+eid+"</b><br></body></html>");
        request.getSession().setAttribute("eidPassing",eid);
        request.getSession().setAttribute("emailPassing",email);
        RequestDispatcher vehicleRequest=request.getRequestDispatcher("/vehicleform.html");
         	vehicleRequest.include(request, response);
        
     } 
     catch (Exception e) { 
         e.printStackTrace(); 
         out.println("<br><b>Choose another email</b><br></body></html>");
     
     } 
counter=0;
}
else
{
RequestDispatcher rdObject = request.getRequestDispatcher("/index1.html");
rdObject.include(request, response);
}

	
	
	}
}