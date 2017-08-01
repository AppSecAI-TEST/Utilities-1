package calc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 public class CalcServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	public CalcServlet() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("Cp1251");
		PrintWriter pw = response.getWriter();
		
		boolean inp_state = true;
		
		int op1 = 0, op2 = 0;
		try
		{
			op1 = getParamValue("op1", request);
			op2 = getParamValue("op2", request);
		}
		catch (Exception e) {
			inp_state = false;
		}
		
		pw.println("<head/>");
		pw.println("<body>");
		if (inp_state)
		{
			pw.println("" + op1 + " + " + op2 + " = " + (op1 + op2));
		}
		else
		{
			pw.println ("<form action = \"CalcServlet\" method=\"post\"");
			pw.println ("<table>");
			pw.println ("<tr>");
			pw.println ("<td><input name=\"op1\" type=\"text\"></td>");
			pw.println ("</tr>");
			pw.println ("<tr>");
			pw.println ("<td><input name=\"op2\" type=\"text\"></td>");
			pw.println ("</tr>");
			pw.println ("<tr>");
			pw.println ("<td><input name=\"action\" type=\"submit\" value=\"Calc\"></td>");
			pw.println ("</tr>");
			pw.println ("</table>");
			pw.println ("</form>");
		}
		pw.println("</body>");			
		
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int op1 = 0, op2 = 0;
		response.setContentType("text/html");
		response.setCharacterEncoding("Cp1251");
		PrintWriter pw = response.getWriter();
		pw.println("<head/>");
		pw.println("<body>");
		try
		{
			op1 = getParamValue("op1", request);
			op2 = getParamValue("op2", request);
			pw.println("" + op1 + " + " + op2 + " = " + (op1 + op2));
			pw.println("</body>");			
		}
		catch (Exception e) {
			pw.println("Wrong operands!");			
		}
		pw.println("</body>");			
		
	}   	
	
	protected int getParamValue (String name, HttpServletRequest request)
		throws Exception
	{
		Object o = request.getParameter(name);
		if (o == null)
			throw new Exception ("");
		
		int res = Integer.parseInt((String)o);
		return res;
	}
}