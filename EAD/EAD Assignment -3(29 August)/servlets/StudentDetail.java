package svk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDetail
 */
public class StudentDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 try { 
			  
	            // Initialize the database 
	            Connection connect = JDBCConnection.connectionQuery("student","root","root");
	            PreparedStatement statement = connect.prepareStatement("insert into detail values(?, ?,?,?,?,?)"); 
	            statement.setString(1, request.getParameter("firstName")); 
	            statement.setString(2, request.getParameter("lastName")); 
	            statement.setString(3, request.getParameter("fatherName")); 
	            statement.setString(4, request.getParameter("emailStudent")); 
	            statement.setInt(5, Integer.valueOf(request.getParameter("classStudent"))); 
		      	statement.setInt(6, Integer.valueOf(request.getParameter("age"))); 
		    	System.out.println("HERE in show"+Operation.operate.size());
		       statement.executeUpdate(); 
	  
		       
		       
		       
	            // Close all the connections 
		      	statement.close(); 
	            connect.close(); 
	             PrintWriter out = response.getWriter(); 
	            out.println("<html><body><b>Successfully Inserted"
	                        + "</b></body></html>"); 
	            //sendRedirect
	        } 
	        catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
		
		
		
		
		
	}

}
