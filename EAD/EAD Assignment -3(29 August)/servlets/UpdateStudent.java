package svk;

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
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();			
		id=request.getParameter("id");
        
		System.out.println( "INA "+id);
		//System.out.println("TODAY"+ request.getParameter("lastName"));
		 try { 
	 	    	

	            // Initialize the database 
	            Connection connect = JDBCConnection.connectionQuery("student","root","root");
	            PreparedStatement statement1 = connect.prepareStatement("select * from detail where email='"+id+"'");
		
		ResultSet result1=statement1.executeQuery();
		while(result1.next())
		{
		out.println("Student Email ID for Updating "+id+"<br>");
                     out.println("<html><body><b>The list is as follows"
	                             + "</b></body></html>");
	                 out.println("<html><body><form method='post'>");
	                 out.println("First Name<br>");
	                 out.println("<input type='text' name='fName' value='"+ result1.getString("firstName")+"'><br><br>");
	                 out.println("Last Name<br>");
	                 out.println("<input type='text' name='lName'value='"+ result1.getString("lastName")+"'><br><br>");
	                 out.println("Father's Name<br>");
	                 out.println("<input type='text' name='faName' value='"+ result1.getString("fatherName")+"'><br><br>");
	                 out.println("Class<br>");
	                 out.println("<input type='number' name='cStudent' value='"+ result1.getInt("class")+"'><br><br>");
	                 out.println("Age<br>");
	                 out.println("<input type='number' name='sage' value='"+ result1.getInt("age")+"'><br><br>");
	      	        out.println("<input type='submit' value='Submit After Edit'><br></form></body></html>");
	
		  	statement1.close(); 
            connect.close(); 
    	//	PrintWriter out = response.getWriter();
          //  out.println("<html><body><b>Successfully Updated</b><br><a href='index.html>Go to Home</a>'</body></html>"); 
            //sendRedirect
        }} 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
	
		 
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		 try { 
 	    	

	            // Initialize the database 
	            Connection connect = JDBCConnection.connectionQuery("student","root","root");
	            PreparedStatement statement = connect.prepareStatement("update detail set firstName=?,lastName=?,fatherName=?,class=?,age=? where email=?");
System.out.println( request.getParameter("lName"));
System.out.println( request.getParameter("fName"));
System.out.println( request.getParameter("cStudent"));

	            statement.setString(1, request.getParameter("fName")); 
	            statement.setString(2, request.getParameter("lName")); 
	            statement.setString(3, request.getParameter("faName")); 
	            statement.setInt(4, Integer.valueOf(request.getParameter("cStudent"))); 
		      	statement.setInt(5, Integer.valueOf(request.getParameter("sage"))); 
		      	statement.setString(6, id); 
		    	  
		      	// Operation.operate.add(new Student(request.getParameter("firstName"),request.getParameter("lastName"),request.getParameter("fatherName"),request.getParameter("emailStudent"),Integer.valueOf(request.getParameter("classStudent")),Integer.valueOf(request.getParameter("age"))));
		    	//System.out.println("HERE in show"+Operation.operate.size());
		       statement.executeUpdate(); 
	  
	            // Close all the connections 
		      	statement.close(); 
	            connect.close(); 
	    		PrintWriter out = response.getWriter();
	            out.println("<html><body><b>Successfully Updated</b><br><a href='index.html>Go to Home</a>'</body></html>"); 
	            //sendRedirect
	        } 
	        catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
