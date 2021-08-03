package de.mybike.fahrraeder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo 
 * @author grzeg
 *
 */
public class FahrradLeser {
	
	public static final String VERBINDUNG = "jdbc:mysql://localhost:3306/fahrraederDB";
	public static final String USER = "root";
	public static final String PASSWORT = "";
	public static final String FAHRRAD_TABELLE = "fahrrad";
	
	private List<Fahrrad> alleRaeder = new ArrayList<Fahrrad>();
	
	
	public void lesenFahrraTabelle() {
//		Connection verbindungZurFahrradDB = null;
//		
//		try {
//			verbindungZurFahrradDB = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT);
//			//....
//		} catch (SQLException e) {
//			System.out.println("Baza Danych nie dostepna");
//			e.printStackTrace();
//		} finally {
//			// Wird immer durchgeführt, egal ob im try eine Exception ausgelöst wird, oder
//			// nicht
//			// wird auch durchgeführt, wenn im try oder im catch return die Methode beendet
//			if (verbindungZurFahrradDB != null) {
//				try {
//					verbindungZurFahrradDB.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}//		}
		//Try-with-resouces: auto close connection
		try (Connection conn = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT)) {
			
			Statement stm = conn.createStatement();
			String sqlQuestion = "SELECT * FROM " + FAHRRAD_TABELLE;
			ResultSet ergebnis = stm.executeQuery(sqlQuestion);
			
			while (ergebnis.next()) {
				int schluessel = ergebnis.getInt("id");
				String farbe = ergebnis.getString("farbe");
				String typ = ergebnis.getString("typ");
				int groesse = ergebnis.getInt("groesse");
				LocalDate verfuegbarAb = ergebnis.getDate("verfuegbar_ab").toLocalDate();
				
				// Tu powstaje objekt DTO Fahrrad
				Fahrrad neuRad = new Fahrrad(farbe, typ, groesse, verfuegbarAb); 
				neuRad.setPrimaryKey(schluessel);
				
				alleRaeder.add(neuRad);
			}
			
		} catch (SQLException e) {
			System.out.println("Cos nie pyklo");
			e.printStackTrace();
		}
	}

	
	/**
	 * @return the alleRader
	 */
	public List<Fahrrad> getAlleRaeder() {
		return alleRaeder;
	}

}
