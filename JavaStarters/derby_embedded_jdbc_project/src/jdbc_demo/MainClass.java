package jdbc_demo;

import java.sql.*;

public class MainClass {

	public static void main(String[] args) throws Exception {
		final String db_name = "D:\\Software\\Derby_DBs\\embedded_mydb";

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//		java -Djdbc.drivers=org.apache.derby.jdbc.EmbeddedDriver AProgram
		
		Connection connect = 
			DriverManager.getConnection("jdbc:derby:" + db_name);
//				username,
//				password); 

		if (connect != null)
			System.out.println ("Connection O\'K!");
		else
			System.out.println ("Connection not established! ");
		
		connect.setAutoCommit(false);
	    ResultSet rs = null;

	    try
	    {
//	    	Statement ins_stmt = connect.createStatement();
//	        ins_stmt.executeUpdate("INSERT INTO ST_VISITS (STUDENT_ID, LAST_NAME, FIRST_NAME)" +
//	    		" VALUES (3, 'Сидоров', 'Сидор')");

//	        Statement stmt = connect.createStatement();
//	        rs = stmt.executeQuery("SELECT * from ST_VISITS");

	        PreparedStatement pstmt = connect.prepareStatement("SELECT * from ST_VISITS WHERE STUDENT_ID > ?");
	        pstmt.setInt (1, 0);
	        rs = pstmt.executeQuery();

	        ResultSetMetaData rsmd = rs.getMetaData();
	        for (int i = 0; i < rsmd.getColumnCount(); i++)
	          System.out.print(rsmd.getColumnName(i + 1) + "     ");

	        System.out.println();
	        System.out.println("------------------------------------------------------------");
	        while (rs.next())
	        {
	          System.out.print(rs.getInt(1) + "          ");
	          System.out.print(rs.getString(2) + "          ");
	          System.out.println(rs.getString(3) + "    ");
	        }
	        System.out.println("-------------------------------------------------------------");
	        connect.commit();
	      }
	      catch (Exception e)
	      {
	        connect.rollback();
	        e.printStackTrace();
	      }
	      rs.close();
	      connect.close();	      
	    }	    
}
