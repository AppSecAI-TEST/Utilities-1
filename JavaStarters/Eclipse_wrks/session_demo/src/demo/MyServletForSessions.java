package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: MyServletForSessions
 *
 */
 public class MyServletForSessions extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	public MyServletForSessions() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession(true);
		if (session.getAttribute("count") == null)
			session.setAttribute("count", 0);
		Integer c = (Integer)session.getAttribute("count");
		session.setAttribute("count", c+1);
		pw.println("Count = " + session.getAttribute("count"));
	}  	  	  	    
}