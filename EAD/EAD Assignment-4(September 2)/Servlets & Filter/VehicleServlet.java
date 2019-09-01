package svk1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vk.JDBCConnection;

/**
 * Servlet implementation class VehicleServlet
 */
@WebServlet("/VehicleServlet")
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      String vehicleType=""; 
      String email="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cycleType="",motorType="",fourType="";
		String email=(String)request.getSession().getAttribute("emailPassing");
		
		String amount=request.getParameter("cyclepass");
		int counter=0;int p=0,q=0,r=0;
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			if("cycle".equals(vehicleType))
			{
				amount=request.getParameter("cyclepass");
				p=1;
			}
			else if("motor".equals(vehicleType))
			{
				amount=request.getParameter("cyclepass");
				q=1;
			}
			else
			{
				amount=request.getParameter("fourpass");
				r=1;
			}
		int vid=0;
	
		  System.out.println("amount"+amount);
	
		  System.out.println("type "+vehicleType);
	
	 //System.out.println("DONE E E ");
        // Initialize the database 
        Connection connect = JDBCConnection.connectionQuery("employee","root","root");
        PreparedStatement statement1 = connect.prepareStatement("select vid from vehicle where email=?");
        statement1.setString(1, email);
        ResultSet result=statement1.executeQuery();
        while(result.next()) {
        	vid=result.getInt("vid");
        }
        System.out.println("VID "+vid);
		PrintWriter out = response.getWriter();
        PreparedStatement statement = connect.prepareStatement("insert into pass(subscriptiontype,vid,amount) values(?,?,?)");
        
        statement.setString(1, vehicleType);
        statement.setInt(2, vid); 
	   	 statement.setString(3, amount); 
	   	 statement.executeUpdate(); 
     // Close all the connections 
	      	statement.close(); 
        connect.close(); 
       out.println("<html><body><br><b>Congratulations !!! You are registered with the following EmployeeID</b><br><b>Employee Email ID : </b>"+email+"</b><br>");
       out.println("<br><b>Congratulations !!! You paid </b>"+amount+"<br><b>Please Login to continue </b><br></body></html>");

      RequestDispatcher vehicleRequest1=request.getRequestDispatcher("/index1.html");
        	vehicleRequest1.include(request, response);
       
    } 
    catch (Exception e) { 
        e.printStackTrace(); 
        } 

	
	
	
	
	System.out.println("IN AM IN GEtKJSHDS"+fourType);
	int eidObtained= (Integer)request.getSession().getAttribute("eidPassing");
	System.out.println("IN AM IN GEtKJSHDS in EID"+eidObtained);
	System.out.println("IN AM IN GEtKJSHDS"+cycleType);
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vehicleModel = "";
		vehicleType= request.getParameter("optedtype");
		String vehicleNumber = "";
		String identification=request.getParameter("identify");
		int eidObtained= (Integer)request.getSession().getAttribute("eidPassing");
		email=(String)request.getSession().getAttribute("emailPassing");
		int counter=0;
		PrintWriter out = response.getWriter();
		if (request.getParameter("model") != null &&  request.getParameter("model").length()!=0) {
			vehicleModel = request.getParameter("model");
			
		} else {
		counter=1;
			out.println("<br><b>Sorry !! Please Enter the vehicle model and try again</b><br>");
		}
	
		if (request.getParameter("vehicleNumber") != null &&  request.getParameter("vehicleNumber").length()!=0) {
			vehicleNumber = request.getParameter("vehicleNumber");
		} else {
			counter=1;
			out.println("<br><b>Sorry !! Please Enter vehicle number and try again</b><br>");
		}
//		System.out.println("Password "+password);	
//		System.out.println("Conform "+confirm);	
System.out.println("CC "+counter);	
System.out.println("CCEDI DD "+eidObtained);
if(counter==0)
{ //System.out.println("DONE E E ");
         // Initialize the database 
	try {
         Connection connect = JDBCConnection.connectionQuery("employee","root","root");
         String sqlQuery1="SET FOREIGN_KEY_CHECKS=0";;
         PreparedStatement statement1 = connect.prepareStatement(sqlQuery1);
         statement1.executeUpdate(sqlQuery1);
         PreparedStatement statement = connect.prepareStatement("insert into vehicle(type,vehicleName,vehicleNumber,eid,identification,email) values(?,?,?,?,?,?)");
         statement.setString(1, vehicleType); 
         statement.setString(2, vehicleModel); 
         statement.setString(3,vehicleNumber); 
         statement.setInt(4, eidObtained); 
         statement.setString(5,identification); 
         statement.setString(6,email); 
	   	 statement.executeUpdate(); 
      // Close all the connections 
	      statement.close(); 
         connect.close(); 
        out.println("<br><b>Congratulations !!! You entered details  and chosen </b><br><b>Employee ID : </b>"+vehicleType+" along with "+vehicleNumber +"</b><br>Please Select the pass</br></body></html>");
         	//RequestDispatcher vehicleRequest=request.getRequestDispatcher("/vehicleform.html");
         	//vehicleRequest.include(request, response);
        response.setContentType("text/html; charset=UTF-8");	
out.println("<!DOCTYPE html>"+
"<html>"+
"<head>");

      if("cycle".equals(vehicleType))
	{
		out.println("<style>#cyclepass{display:block;}"+"#fourpass,#motorpass{display:none;}</style>");
	}
	else if("motor".equals(vehicleType))
	{//System.out.println("HELLO");
		out.println("<style>#motorpass{display:block;}"+"#fourpass,#cyclepass{display:none;}</style>");
	}
	else
	{out.println("<style>#fourpass{display:block;}"+"#cyclepass,#motorpass{display:none;}</style>");

	}
      

out.println("<style>#cyclepassus,#cyclepassyen"+
"{"+
"	display:block;"+
"	"+
"}"+
""+
"#motorpassus,#motorpassyen,#fourpassus,#fourpassyen"+
"{"+
"	display:block;"+
"}"+
"</style>"+
"</head>"+
"<body>"+
"<form action='' method='get'>"+

"<div id=\"cyclepass\" align=\"center\">"+
"<h3>The pass prices for the Cycle are as follows</h3><br>"+
"<h4>Select any one of the following </h4>"+
""+
""+
"<div id=\"cyclepassr\" align=\"center\">"+
"<form action='' method='GET'>"+
"<label>"+
"<input type=\"radio\" name=\"cyclepass\" value=\"Rs.5\">Daily - Rs.5  <br><br>"+
"</label>"+
""+
"<label>"+
"<input type=\"radio\" name=\"cyclepass\" value=\"Rs.100\">Monthly - Rs.100  <br><br>"+
"</label>"+
""+
"<label>"+
"<input type=\"radio\" name=\"cyclepass\" value=\"Rs.500\">Yearly - Rs.500  <br><br>"+
"</label>"+
"</div>"+
""+
"<div id=\"cyclepassus\" align=\"center\">"+
"<label>"+
"<input type=\"radio\" name=\"cyclepass\" value=\"0.069 $\">Daily - 0.069 $ <br><br>"+
"</label>"+
""+
"<label>"+
"<input type=\"radio\" name=\"cyclepass\" value=\"1.39$\">Monthly - 1.39$ <br><br>"+
"</label>"+
"<label>"+
"<input type=\"radio\" name=\"cyclepass\" value=\"6.95$\">Yearly - 6.95$ <br><br>"+
"</label>"+
"</div>"+
""+
""+
""+
"<div id=\"cyclepassyen\" align=\"center\">"+
"<label>"+
"<input type=\"radio\" name=\"cyclepass\" value=\"7.35 ¥\">Daily - 7.35 ¥ <br><br>"+
"</label>"+
""+
"<label>"+
"<input type=\"radio\" name=\"cyclepass\" value=\"147.08 ¥\">Monthly - 147.08 ¥  <br><br>"+
"</label>"+
""+
""+
"<label>"+
"<input type=\"radio\" name=\"cyclepass\" value=\"735.42 ¥\">Monthly - 735.42 ¥<br><br>"+
"</label>"+
"</div>"+
""+
""+
""+
"<label><b>Currency</b></label>"+
"<select onchange=\"showCurrencyCycle()\" id=\"currency\" name=\"cry\">"+
"<option value=\"inr\"  selected>INR</option>"+
"<option value=\"usd\">USD</option>"+
"<option  value=\"yen\" >YEN</option>"+
"</select>"+
"<br><br>"+
""+
"<input type='submit' value='Get Pass'>"+
""+
"</div>"+
""+
""+
"<div id=\"motorpass\" align=\"center\">"+
"<h3>The pass prices for the MotorCycle are as follows</h3><br>"+
"<h4>Select any one of the following </h4>"+
"<div id=\"motorpassr\" align=\"center\">"+
"<label>"+
"<input type=\"radio\" name=\"motorpass\" value=\"Rs.10\">Daily - Rs.10  <br><br>"+
"</label>"+
""+
"<label>"+
"<input type=\"radio\" name=\"motorpass\" value=\"Rs.200\">Monthly - Rs.200  <br><br>"+
"</label>"+
""+
"<label>"+
"<input type=\"radio\" name=\"motorpass\" value=\"Rs.1000\">Yearly - Rs.1000  <br><br>"+
"</label>"+
"</div>"+
""+
"<div id=\"motorpassus\" align=\"center\">"+
"<label>"+
"<input type=\"radio\" name=\"motorpass\" value=\"0.14 $\">Daily - 0.14 $ <br><br>"+
"</label>"+
""+
"<label>"+
"<input type=\"radio\" name=\"motorpass\" value=\"2.78 $\">Monthly - 2.78$ <br><br>"+
"</label>"+
"<label>"+
"<input type=\"radio\" name=\"motorpass\" value=\"13.88 $\">Yearly - 13.88$ <br><br>"+
"</label>"+
"</div>"+
""+
""+
""+
"<div id=\"motorpassyen\" align=\"center\">"+
"<label>"+
"<input type=\"radio\" name=\"motorpass\" value=\"14.69 ¥\">Daily - 14.69 ¥ <br><br>"+
"</label>"+
""+
"<label>"+
"<input type=\"radio\" name=\"motorpass\" value=\"293.89 ¥\">Monthly - 293.89 ¥  <br><br>"+
"</label>"+
""+
""+
"<label>"+
"<input type=\"radio\" name=\"motorpass\" value=\"1469.45 ¥\">Yearly - 1469.45 ¥<br><br>"+
"</label>"+
"</div>"+
""+
""+
""+
"<label><b>Currency</b></label>"+
"<select onchange=\"showCurrencyMotor()\" id=\"currency1\" name=\"cry1\">"+
"<option value=\"inr\"  selected>INR</option>"+
"<option value=\"usd\">USD</option>"+
"<option  value=\"yen\" >YEN</option>"+
"</select>"+
"<br><br>"+
"<input type='submit' value='Get Pass'>"+
"</div>"+
""+
""+
""+
"<div id=\"fourpass\" align=\"center\">"+
"<h3>The pass prices for the Four-Wheeler are as follows</h3><br>"+
"<h4>Select any one of the following </h4>"+
"<div id=\"fourpassr\" align=\"center\">"+
"<label>"+
"<input type=\"radio\" name=\"fourpass\" value=\"Rs.20\">Daily - Rs.20  <br><br>"+
"</label>"+
""+
"<label>"+
"<input type=\"radio\" name=\"fourpass\" value=\"Rs.500\">Monthly - Rs.500  <br><br>"+
"</label>"+
""+
"<label>"+
"<input type=\"radio\" name=\"fourpass\" value=\"Rs.3500\">Yearly - Rs.3500  <br><br>"+
"</label>"+
"</div>"+
""+
"<div id=\"fourpassus\" align=\"center\">"+
"<label>"+
"<input type=\"radio\" name=\"fourpass\" value=\"0.28$\">Daily - 0.28 $ <br><br>"+
"</label>"+
""+
"<label>"+
"<input type=\"radio\" name=\"fourpass\" value=\"6.94$\">Monthly - 6.94$ <br><br>"+
"</label>"+
"<label>"+
"<input type=\"radio\" name=\"fourpass\" value=\"48.60$\">Yearly - 48.60 <br><br>"+
"</label>"+
"</div>"+
""+
""+
""+
"<div id=\"fourpassyen\" align=\"center\">"+
"<label>"+
"<input type=\"radio\" name=\"fourpass\" value=\"29.39¥\">Daily - 29.39 ¥ <br><br>"+
"</label>"+
""+
"<label>"+
"<input type=\"radio\" name=\"fourpass\" value=\"734.72 ¥\">Monthly - 734.72 ¥  <br><br>"+
"</label>"+
""+
""+
"<label>"+
"<input type=\"radio\" name=\"fourpass\" value=\"5143.07 ¥\">Yearly - 5143.07 ¥<br><br>"+
"</label>"+
"</div>"+
""+
""+
""+
"<label><b>Currency</b></label>"+
"<select onchange=\"showCurrencyFour()\" id=\"currency2\" name=\"cry2\">"+
"<option value=\"inr\"  selected>INR</option>"+
"<option value=\"usd\">USD</option>"+
"<option  value=\"yen\" >YEN</option>"+
"</select>"+
"<br><br>"+
"<input type='submit' value='Get Pass'>"+
"</div>"+
""+
"</form>"+

"<script>"+
"function showCurrencyCycle() { "+
" var money;"+
"var x =document.getElementById('currency').value;"+
"if(x==\"inr\")"+
"{"+
" document.getElementById('cyclepassr').style.display='block'; "+
"  document.getElementById('cyclepassus').style.display='none'; "+
"  document.getElementById('cyclepassyen').style.display='none'; "+
"}"+
"else if(x==\"usd\")"+
"{"+
" document.getElementById('cyclepassus').style.display='block'; "+
" document.getElementById('cyclepassr').style.display='none'; "+
"  document.getElementById('cyclepassyen').style.display='none';"+
"}"+
"else"+
"{"+
" document.getElementById('cyclepassyen').style.display='block'; "+
" document.getElementById('cyclepassr').style.display='none'; "+
" document.getElementById('cyclepassus').style.display='none'; "+
"}  "+
"  }   "+
"function showCurrencyMotor() { "+
"var x =document.getElementById('currency1').value;"+
"// alert(x);"+
"if(x==\"inr\")"+
"{"+
" document.getElementById('motorpassr').style.display='block'; "+
"  document.getElementById('motorpassus').style.display='none'; "+
"  document.getElementById('motorpassyen').style.display='none'; "+
"}"+
"else if(x==\"usd\")"+
"{"+
" document.getElementById('motorpassus').style.display='block'; "+
" document.getElementById('motorpassr').style.display='none'; "+
"  document.getElementById('motorpassyen').style.display='none';"+
"}"+
"else"+
"{"+
" document.getElementById('motorpassyen').style.display='block'; "+
" document.getElementById('motorpassr').style.display='none'; "+
" document.getElementById('motorpassus').style.display='none'; "+
"}  "+
"}   "+
"function showCurrencyFour() { "+
"  //alert(\"HELLO FOUR\");"+
"var x =document.getElementById('currency2').value;"+
"if(x==\"inr\")"+
"{"+
" document.getElementById('fourpassr').style.display='block'; "+
"  document.getElementById('fourpassus').style.display='none'; "+
"  document.getElementById('fourpassyen').style.display='none'; "+
"}"+
"else if(x==\"usd\")"+
"{"+
" document.getElementById('fourpassus').style.display='block'; "+
" document.getElementById('fourpassr').style.display='none'; "+
"  document.getElementById('fourpassyen').style.display='none';"+
"}"+
"else"+
"{"+
" document.getElementById('fourpassyen').style.display='block'; "+
" document.getElementById('fourpassr').style.display='none'; "+
" document.getElementById('fourpassus').style.display='none'; "+
"}  "+
"}   "+
"</script>"+
""+
""+
"</body>"+"</html>");
	

	} 
     catch (Exception e) { 
         e.printStackTrace(); 
     } 
counter=0;
}
else
{
RequestDispatcher rdObject = request.getRequestDispatcher("/vehicleform.html");
rdObject.forward(request, response);
	}
}
	}


