package svk1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 
@WebFilter("/friendE")
public class Filter1 implements Filter {

    /**
     * Default constructor. 
     */
    public Filter1() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		 HttpServletRequest request1 = (HttpServletRequest) request;
	        HttpServletResponse response1 = (HttpServletResponse) response;
		
		System.out.println("HELLO I AM IN FiLTER1");
		 HttpSession session=request1.getSession();  
		 String name=(String)session.getAttribute("nameEmail"); 
		 // boolean loggedIn = session != null && session.getAttribute("user") != null;
	     //   boolean loginRequest = request.getRequestURI().equals(loginURI);

	        if (name!=null) {
	            chain.doFilter(request1, response1);
	        } else {
	            response1.sendRedirect("index1.html");
	        }
	    }
		
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
