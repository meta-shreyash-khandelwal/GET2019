package svk1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vk.JDBCConnection;

/**
 * Servlet implementation class FriendDetail
 */
@WebServlet("/FriendDetail")
public class FriendDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendDetail() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    PrintWriter out = response.getWriter();
		String id=request.getParameter("id");   
		out.println("<html><body align='right'><br><a style=\"float: right;\" href='logout'>Logout</a></body></html>");
		out.println("<html><body align='right'><br><b>Here are the details </b><br></body></html>");
		   try { 
	           Connection connect = JDBCConnection.connectionQuery("employee","root","root");   
		   PreparedStatement statement1 = connect.prepareStatement("select * from employeedetail " + 
		     		     		" where employeedetail.email='"+id+"'");

		ResultSet result1=statement1.executeQuery();
		//out.println("<body><html><br><a href='logoutEmployee'>Logout</a></body></html>");
				out.println("<html><body><b>The list is as follows"
						+ "</b></body></html>");
				out.println("<br>");

				out.println("<html><body><table border='1'><tr><th>Name</th><th>Gender</th> <th>Email</th><th>contact</th><th>Organisation</th><th>Employee ID</th></tr>");
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
					out.print("</td>");
					out.print("<td>");
					out.print(result1.getInt("employeeid") + "\t");
					out.print("</td></tr>");
					
				}
				out.println("</table></body></html>");
			
		 
			     out.println("<html><body><br><a href='friendE'>Go back </a></body></html>");
			     connect.close();
	
		   }
		   catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
