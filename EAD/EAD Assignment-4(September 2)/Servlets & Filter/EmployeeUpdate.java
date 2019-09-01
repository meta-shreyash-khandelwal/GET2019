package svk1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
import vk.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * Servlet implementation class EmployeeUpdate
 */
@WebServlet("/EmployeeUpdate")
public class EmployeeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String name="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	 HttpSession session=request.getSession();  
	 PrintWriter out = response.getWriter();
	 if(session!=null){  
		       name=(String)session.getAttribute("nameEmail");  
		          
		        try { 
		 	    	

		            // Initialize the database 
		            Connection connect = JDBCConnection.connectionQuery("employee","root","root");
		            PreparedStatement statement1 = connect.prepareStatement("select * " + 
		            		" from employeedetail " + 
		            	  		"where employeedetail.email='"+name+"'");
			
			ResultSet result1=statement1.executeQuery();
			while(result1.next())
			{
			out.println("Employee Email ID for Updating "+name+"<br>");
	                     out.println("<html><body><b>The list is as follows"
		                             + "</b></body></html>");
		                 out.println("<html><body><form method='post'>");
		                 out.println(" Name<br>");
		                 out.println("<input type='text' name='fName' value='"+ result1.getString("name")+"'><br><br>");
		                 out.println("Gender<br>");
		                 out.println("<input type='text' name='gender'value='"+ result1.getString("gender")+"'><br><br>");
		                 out.println("Password<br>");
		                 out.println("<input type='password' name='pass' value='"+ result1.getString("password")+"'><br><br>");
		                 out.println("Confirm Password<br>");
		                 out.println("<input type='password' name='conpass' value='"+ result1.getString("password")+"'><br><br>");
		                 out.println("Contact<br>");
		                 out.println("<input type='number' name='contact' value='"+ result1.getInt("contact")+"'><br><br>");
		                 out.println("EmployeeID<br>");
		                 out.println("<input type='number' name='sage' value='"+ result1.getInt("employeeid")+"'><br><br>");
		      	        out.println("<input type='submit' value='Submit After Edit'><br></form></body></html>");
			}
			
			  	statement1.close(); 
	            connect.close(); 
	    	//	PrintWriter out = response.getWriter();
	          //  out.println("<html><body><b>Successfully Updated</b><br><a href='index.html>Go to Home</a>'</body></html>"); 
	            //sendRedirect
	        }
	        catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
		
		        }  
		        else{  
		            out.print("Please login first");  
		            request.getRequestDispatcher("index1.html").include(request, response);  
		        }  
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 try { 
	 	    	

	            // Initialize the database 
	            Connection connect = JDBCConnection.connectionQuery("employee","root","root");
	            PreparedStatement statement = connect.prepareStatement("update employeedetail set name=?,gender=?,password=?,contact=?,employeeid=? where email=?");
//System.out.println( request.getParameter("lName"));
//System.out.println( request.getParameter("fName"));
//System.out.println( request.getParameter("cStudent"));

	            statement.setString(1, request.getParameter("fName")); 
	            statement.setString(2, request.getParameter("gender")); 
	            statement.setString(3, request.getParameter("pass")); 
	            statement.setInt(4, Integer.valueOf(request.getParameter("contact"))); 
		      	statement.setInt(5, Integer.valueOf(request.getParameter("sage"))); 
		      	statement.setString(6, name); 
		    	  
		      	// Operation.operate.add(new Student(request.getParameter("firstName"),request.getParameter("lastName"),request.getParameter("fatherName"),request.getParameter("emailStudent"),Integer.valueOf(request.getParameter("classStudent")),Integer.valueOf(request.getParameter("age"))));
		    	//System.out.println("HERE in show"+Operation.operate.size());
		       statement.executeUpdate(); 
	  
	            // Close all the connections 
		      	statement.close(); 
	            connect.close(); 
	    		PrintWriter out = response.getWriter();
	            out.println("<html><body><b>Successfully Updated</b><br> <a href='index1.html'>Go to Home & Login</a>'</body></html>"); 
	          
	            
	            //RequestDispatcher requestDispatch=request.getRequestDispatcher("index1.html");  
	           // requestDispatch.forward(request, response);  //sendRedirect
	        } 
	        catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
