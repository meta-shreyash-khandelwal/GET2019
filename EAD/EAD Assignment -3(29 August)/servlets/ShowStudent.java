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

/**
 * Servlet implementation class ShowStudent
 */
@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			// Initialize the database
			Connection connect = JDBCConnection.connectionQuery("student",
					"root", "root");
			PreparedStatement statement = connect
					.prepareStatement("select * from detail");
			ResultSet result = statement.executeQuery();
			PrintWriter out = response.getWriter();
			out.println("<html><body><b>The list is as follows"
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
				out.print("<td>");
				out.print("<a href='update?id="+result.getString("email")+"'>Update</a>");
				out.print("</td></tr>");
			}
			out.println("</table></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
