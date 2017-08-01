import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Enumeration;

public class Main {

	static String join(String[] args){
		String ret = "{";
		for(int i=0;i<args.length;i++){
			ret+=args[i] + ";";
		}
		ret+="}";
		return ret;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-config config_file -search \"<search string>\"");
		System.out
				.println("searches string in db using config file for strategy");

		// TODO process params
		/**
		 */

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection conn = null;
		try {
			/* Enumeration<Driver> drivers = DriverManager.getDrivers();
			for(Driver driver=drivers.nextElement(); drivers.hasMoreElements(); driver=drivers.nextElement()) {
			System.out.println( driver);
			}*/
			
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432", "postgres", "mar76ket");

			if (conn == null) {
				System.out.println("no connection with db");
				System.exit(0);
			}

		    DatabaseMetaData meta = conn.getMetaData();
		    ResultSet schemas = meta.getSchemas();
		    while (schemas.next()) {
		      String tableSchema = schemas.getString(1);    // "TABLE_SCHEM"
		      String tableCatalog = schemas.getString(2); //"TABLE_CATALOG"
		      System.out.println("tableSchema: "+tableSchema + "; table catalog:" + tableCatalog);
		      ResultSet tablers = meta.getTables(tableCatalog,
                      tableSchema,null,
                      null /*String[] types*/);
		      while(tablers!=null && tablers.next()) {
		    	  ResultSetMetaData rsm = tablers.getMetaData();
		    	  System.out.println("ptocess tables:");
		    	  
		    	  for(int i=1; i<rsm.getColumnCount()+1; i++){
		    		  String str[] = {String.valueOf(i),rsm.getColumnName(i),
	    				  rsm.getColumnClassName(i),
	    				  rsm.getColumnLabel(i),
	    				  rsm.getColumnTypeName(i)};
		    		  System.out.println("column " + join(str));
		    	  };
		    	  
		    	  System.out.println(tablers.getRow() + ":" + tablers.toString() + ":" + tablers.getStatement());
		      }
		    }		   
			
			java.sql.Statement stmt = null;
			stmt = conn.createStatement();

			ResultSet rs = null;
			/*
			rs = stmt.executeQuery("SELECT * FROM \"MyRTGtestschema\".\"Test_table\""); //$NON-NLS-1$
*/
			
			
			
			while (rs != null && rs.next()) {
				System.out.println(rs.getRow() + ". " //$NON-NLS-1$ TODO - understand wtf this nls
						+ rs.getString("firstname") + "\t"  //$NON-NLS-1$//$NON-NLS-2$
						+ rs.getString("lastname")); //$NON-NLS-1$
			}

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// for reflective calling
	public Object[] call(Method callmethod, Object[] args) {
		Object[] retval = {};
		return retval;
	}

}
