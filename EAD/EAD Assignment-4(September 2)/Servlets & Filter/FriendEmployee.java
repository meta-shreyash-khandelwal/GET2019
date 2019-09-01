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
import javax.servlet.http.HttpSession;

import vk.JDBCConnection;

/**
 * Servlet implementation class FriendEmployee
 */
@WebServlet("/FriendEmployee")
public class FriendEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 String userMail="";
       String organisation="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 HttpSession session=request.getSession();  
	    userMail=(String)session.getAttribute("nameEmail");  
	     organisation=(String)session.getAttribute("organEmployee"); 
	    PrintWriter out = response.getWriter();
		 if(session!=null){  
				out.println("<html><body align='right'><br><a style=\"float: right;\" href='logout'>Logout</a></body></html>");
			 out.println("<html><body><b>Welcome to the FRIEND LIST <br>The list is as follows"
                      + "</b><br><br></body></html>");          
			        try { 
			           Connection connect = JDBCConnection.connectionQuery("employee","root","root");
			           PreparedStatement statement1 = connect.prepareStatement("select *  from employeedetail where employeedetail.organisation='"+organisation+"' and not email='"+userMail+"'");
				
				ResultSet result1=statement1.executeQuery();
				while(result1.next())
				{
			                 out.println("<a href='friends?id="+ result1.getString("email")+"'>"+result1.getString("name")+"</a><br><br>"); 
			    }
				
				  	statement1.close(); 
		            connect.close(); 
		    	//PrintWriter out = response.getWriter();
		          //  out.println("<html><body><b>Successfully Updated</b><br><a href='index.html>Go to Home</a>'</body></html>"); 
		            //sendRedirect
		        }
		        catch (Exception e) { 
		            e.printStackTrace(); 
		        } 
			
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
