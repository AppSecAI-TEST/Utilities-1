package db;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.derby.jdbc.ClientDriver;

import java.sql.*;

 public class WebDBServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	public WebDBServlet() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String db_name = "D:\\Software\\Derby_DBs\\network_mydb";

		response.setContentType("text/html");
		response.setCharacterEncoding("Cp1251");
		PrintWriter pw = response.getWriter();

		pw.println("<head/>");
		pw.println("<body>");
		
		
		try {
			Driver d = new ClientDriver();
			DriverManager.registerDriver(d);
//			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (SQLException e1) {
//		} catch (ClassNotFoundException e1) {
			pw.println("Ошибка загрузки класса драйвера.");
			pw.println(e1.getMessage());
			pw.println("</body>");
			return;
		}
		
		Connection connect  = null;
		try {
			connect = DriverManager.getConnection("jdbc:derby://localhost:1527/" + db_name + ";create=false");
		} catch (SQLException e1) {
			pw.println("Ошибка установки соединения с сервером.");
			pw.println(e1.getMessage());
			pw.println("</body>");
			return;
		}

		if (connect == null)
		{
			pw.println("Ошибка установки соединения с сервером.");
			pw.println("</body>");
			return;
		}
		
		try
		{
			connect.setAutoCommit(false);
			ResultSet rs = null;

			try
			{
				PreparedStatement pstmt = connect.prepareStatement("SELECT * from ST_VISITS WHERE STUDENT_ID > ?");
				pstmt.setInt (1, 0);
				rs = pstmt.executeQuery();

				ResultSetMetaData rsmd = rs.getMetaData();
				String f1 = rsmd.getColumnName(1);
				String f2 = rsmd.getColumnName(2);
				pw.println("<table>");
				pw.println("<tr><B><th>" + f1 + "</th><th>" + f2 + "</th><th></B></tr>");
				while (rs.next()) 
				{
		          int key = rs.getInt(1);
		          String name = rs.getString(2);
		          pw.println ("<tr>");
		          pw.println ("<td>" + key + "</td>");
		          pw.println ("<td>" + name + "</td>");
		          pw.println ("</tr>");
				}
		        pw.println ("</table>");
	        
				connect.commit();
				pw.println("</body>");
			}
			catch (Exception e)
			{
				connect.rollback();
				e.printStackTrace();
			}
			rs.close();
			connect.close();
		}
		catch (SQLException e) {
			pw.println("Ошибка чтения данных.");
			pw.println(e.getMessage());
			pw.println("</body>");			
		}
	}	    
}  	  	  	    
