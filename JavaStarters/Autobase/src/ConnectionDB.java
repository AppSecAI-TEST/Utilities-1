import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;


public class ConnectionDB {

	private final String url = "jdbc:postgresql://localhost/Atutosalons";
	private final String user = "postgres";
	private final String password = "postgres";
	private PrintWriter writer;
	Connection conn = null;
	 public Connection connect() {
	        try {
	            conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to the PostgreSQL server successfully.");

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	 
	        return conn;
	    }
	 
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	    	ConnectionDB app = new ConnectionDB();
	    	try{
	    	    app.writer = new PrintWriter("Report.html", "UTF-8");
	    	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    	    java.util.Date date = new java.util.Date();
	    	    app.writer.println("<html><head><meta charset=\"utf-8\"></head><body>");
	    	    app.writer.println("<h1>Report from:" + dateFormat.format(date));
	    	    app.writer.println("</h1>\n"); 
	    	} catch (IOException e) {
	    	   // do something
	    		e.printStackTrace();
	    	}
	    	app.connect();
            int count = app.getActorCount();
            System.out.println("check sales count=" + count);
            
            @SuppressWarnings("deprecation")
			Date date1 = new Date(114,10-1,01);
            Date date2 = new Date(114,10-1,03);
            
            DateFormat fmt = new SimpleDateFormat("YYYY-MM-dd");
            String sDateFrom = fmt.format(date1);
            String sDateTo = fmt.format(date2);
            // ascending
            app.displayAllAutosalons(true, sDateFrom, sDateTo);
            app.displayClientExpenses(false, sDateFrom, sDateTo);
            app.displayClientNames();
            app.displayClientOrders();
            
            app.writer.println("</body></html>");
            app.writer.close();

	    	File htmlFile = new File("Report.html");
	    	try {
				Desktop.getDesktop().browse(htmlFile.toURI());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    private void displayAllAutosalons(
				boolean isAscending,  String sDateFrom, String sDateTo) {
	    	writer.println("<h2>REPORT ON REVENUE FOR " + sDateFrom + " to " + sDateTo+ " DAYS " +
				(isAscending?"ASCENDING":"DESCENDING <br>") +"");
	    	
	    	writer.println("<table border='1'><tr><td>name</td><td>amt</td></tr>");

	    	String SQL= "select sum(sale.price) as total, salon.name from sale, salon_models, models, salon where " +
	    			"sale.sale_date >= '"+sDateFrom+"'::date and sale.sale_date <= '" +
	    			sDateTo+"'::date and " +
	    			"sale.model_id=salon_models.id_model and " +  
"models.id=salon_models.id_model and " +  
"salon.id=salon_models.id_salon " +
"group by salon.id " +
"order by 1 " + (isAscending?"ASC":"DESC");
	    	System.out.println(SQL);
	    	
			try {
				Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
                
                while(rs.next()){
                double amt = rs.getDouble(1);
                String name = rs.getString(2);
                writer.print("<tr><td>" +name + "</td><td>");
                writer.format(Locale.US, "%12.2f", amt);
                writer.println("</td></tr>");
                }
			} catch(SQLException e) {
				System.out.println(e);
			}
	    	
	    	writer.println("</table>");
	    	
		}

	    private void displayClientExpenses(
		boolean isAscending,  String sDateFrom, String sDateTo){
	    	writer.println("<h2>REPORT ON Client Expenses FOR " + sDateFrom + " to " + sDateTo+ " DAYS " +
				(isAscending?"ASCENDING":"DESCENDING</h2>"));
	    	
	    	writer.println("<table border='1'><tr><td>surname</td><td>model</td><td>amt</td><td>expense</td></tr>");

	    	String SQL= 
	    			"select client.surname, models.name, sale.amount, sale.price " +
	    			"from client, models, sale " +
	    			"where models.id=sale.model_id and " +
	    					"sale.sale_date >= '"+sDateFrom+"'::date and sale.sale_date <= '" +
	    	    			sDateTo+"'::date and " +
	    			"client.id=sale.client_id " +
	    			"order by 4 " + (isAscending?"ASC":"DESC");

	    	System.out.println(SQL);
	    	
			try {
				Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
                
                while(rs.next()){
                String surname = rs.getString(1);
                String modelname = rs.getString(2);
                int amount = rs.getInt(3);
                double expnses = rs.getDouble(4);
                writer.print("<tr><td>" +surname + "</td>");
                writer.print("<td>" +modelname + "</td>");
                writer.print("<td>" +amount + "</td><td>");
                writer.format(Locale.US, "%12.2f", expnses);
                writer.println("</td></tr>");
                }
			} catch(SQLException e) {
				System.out.println(e);
			}
	    	
	    	writer.println("</table>");
	    	
	    	
		}


	    // c
	    private void displayClientNames(){
	    	writer.println("<h2>REPORT ON Client Names </h2>");
	    	
	    	writer.println("<table border='1'><tr><td>name</td><td>surname</td></tr>");

	    	String SQL= 
	    			" select sale.sale_date, sum(sale.price), client.name, client.surname " +
	    			" from sale, client " +
	    			" where  " +
	    			" sale.client_id=client.id " +
	    			" group by sale.sale_date, client.id having sum(sale.price)>3500000";

	    	System.out.println(SQL);
	    	
			try {
				Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
                
                while(rs.next()){
                String surname = rs.getString(3);
                String modelname = rs.getString(4);
                writer.print("<tr><td>" +surname + "</td>");
                writer.print("<td>" +modelname + "</td>");
                writer.println("</td></tr>");
                }
			} catch(SQLException e) {
				System.out.println(e);
			}
	    	
	    	writer.println("</table>");
	    	
	    	
		}
	    // d
	    private void displayClientOrders(){
	    	writer.println("<h2>REPORT ON Client Orders </h2>");
	    	
	    	writer.println("<table border='1'><tr><td>name</td><td>surname</td><td>price</td><td>date</td></tr>");

	    	String SQL = "select client.surname, client.name, sale.price, sale.sale_date" +
	    			" from sale, client where " +
	    			" client.id=sale.client_id " +
	    			" order by sale.price desc";

	    	System.out.println(SQL);
	    	
			try {
				Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
                
                while(rs.next()){
                String name = rs.getString(1);
                String surname = rs.getString(2);
                double amount = rs.getDouble(3);
                Date dates = rs.getDate(4);
                writer.print("<tr><td>" +name + "</td>");
                writer.print("<td>" + surname + "</td><td>");
                writer.format(Locale.US, "%12.2f", amount);
                writer.print("</td><td>" + dates.toString() + "</td><td>");
                writer.println("</td></tr>");
                }
			} catch(SQLException e) {
				System.out.println(e);
			}
	    	
	    	writer.println("</table>");
	    	
	    	
		}
		/**
	     * Get actors count
	     * @return 
	     */
	    public  int getActorCount() {
	        String SQL = "SELECT count(*) FROM sale";
	        int count = 0;
	 
	        try (
	                Statement stmt = conn.createStatement();
	                ResultSet rs = stmt.executeQuery(SQL)) {
	            rs.next();
	            count = rs.getInt(1);
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
	 
	        return count;
	    }
	    
	    
}
