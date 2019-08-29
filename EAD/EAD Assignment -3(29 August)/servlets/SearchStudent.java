package svk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDetail
 */
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			// Initialize the database
			Connection connect = JDBCConnection.connectionQuery("student","root", "root");
			String fName=request.getParameter("firstName");
			String lname=request.getParameter("lastName");
			System.out.println(request.getParameter("firstName")+" and "+request.getParameter("lastName")+fName+lname);
			PreparedStatement statement = connect.prepareStatement("select * from detail where firstName='"+request.getParameter("studentFirstName")+"' AND lastName='"+request.getParameter("studentLastName")+"'");
			ResultSet result = statement.executeQuery();
			PrintWriter out = response.getWriter();
			out.println("<html><body><b>The student details are as follows by NAME"
					+ "</b></body></html>");
			out.println("<br>");

			out.println("<html><body><table border='1'><tr><th>First Name</th><th>Last Name</th> <th>Father's Name</th> <th>Email</th><th>Class</th><th>Age</th></tr>");
			while (result.next()) {
				out.print("<tr><td>");
				out.print(result.getString("firstname") + "\t");
				out.print("</td><td>");
				out.print(result.getString("lastname") + "\t");
				out.print("</td>");
				out.print("<td>");
				out.print(result.getString("fatherName") + "\t");
				out.print("</td>");
				out.print("<td>");
				out.print(result.getString("email") + "\t");
				out.print("</td>");
				out.print("<td>");
				out.print(result.getInt("class") + "\t");
				out.print("</td>");
				out.print("<td>");
				out.print(result.getInt("age") + "\t");
				out.print("</td>");
				}
			out.println("</table></body></html>");
			
			
			PreparedStatement statement1 = connect.prepareStatement("select firstname,lastName,email,class from detail where firstName='"+request.getParameter("studentFirstName")+"' AND lastName='"+request.getParameter("studentLastName")+"' order by class");
			ResultSet result1 = statement1.executeQuery();
			
			out.println("<html><body>The Sorted List is as follows : <br></html></body>");
			out.println("<html><body><table border='1'><tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Class</th></tr>");
			while (result1.next()) {
				out.print("<tr><td>");
				out.print(result1.getString("firstName") + "\t");
				out.print("</td><td>");
				out.print(result1.getString("lastName") + "\t");
				out.print("</td>");
				out.print("<td>");
				out.print(result1.getString("email") + "\t");
				out.print("</td>");
				out.print("<td>");
				out.print(result1.getInt("class") + "\t");
				out.print("</td>");
				}
			out.println("</tr></table></body></html>");
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


