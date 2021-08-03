package erste.schritte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import de.mybike.fahrraeder.FahrradLeser;

import java.sql.SQLException;

/**
 * JDBC: Java Database Connectivity
 * Einheitlicher Zugriff auf relationale Datenbanken
 * 
 * Hier: (NUR HIER) throws Exception an der main
 * 
 * @author grzeg
 *
 */
public class EinstieglnJDBC {

	public static void main(String[] args) throws Exception {
		String verbindung = "jdbc:mysql://localhost:3306/testDBMontag?createDatabaseIfNotExist=true";
		String user = "root";
		String pw = "";
		
		//--------------------------
//		// MSSQL Server
////		String driverName = "DRIVER={SQL Server}";
//		String driverName = "jdbc:mssql";
//		String hostName = "ZENBOOK\\\\SQLEXPRESS";
//		String databaseName = "testdbmontag";
//		
//	    String connectionString = driverName + ";";
//	    connectionString += "Server=" + hostName + ";";
//	    connectionString += "Database=" + databaseName + ";";
//
//	    // W przypadku uwierzytelniania systemu Windows
//	    // Mit Windows Authentifizierung
//	    connectionString += "Trusted_Connection=Yes;";
//	    
//	    String conString = "jdbc:sqlserver://ZENBOOK\\SQLEXPRESS:1433;"
//        + "database=AddressBook;"
//        + "user=\"\";"//yourusername@yourserver;"
//        + "password=\"\";"//yourpassword;"
//        + "encrypt=true;"
//        + "trustServerCertificate=false;"
//        + "loginTimeout=30;";
//	    
//	    ResultSet resultSet = null;
//
//	    try (Connection connect = DriverManager.getConnection(conString);
//	    		Statement statement = connect.createStatement();) {
//	    	
//	    	String sqlQuery = "SELECT * FROM ContactGroup";
//	    	resultSet = statement.executeQuery(sqlQuery);
//        }
//        // Handle any errors that may have occurred.
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
	    //--------------------------------
	    
		//Class.forName("MySQLDriver.class");
		
		Connection conn = DriverManager.getConnection(verbindung, user, pw);
		System.out.println(conn);
		
		Statement stmt = conn.createStatement();
		
		String abfrage = "SELECT * FROM OBST";
		
		ResultSet rs = stmt.executeQuery(abfrage);
		System.out.println(rs);
		
		while (rs.next()) {
			int schluessel = rs.getInt("obst_id");
			String sorte = rs.getString(2);
			String farbe = rs.getString("obst_farbe");
			double preis = rs.getDouble(4);
			
			System.out.println("Sorte " + sorte + ",\tfarbe " + farbe + 
					",\tpreis " + preis + "€" + ",\tindex " + schluessel);
		}
		
	}

}





