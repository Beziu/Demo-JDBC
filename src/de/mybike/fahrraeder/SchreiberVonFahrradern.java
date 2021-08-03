package de.mybike.fahrraeder;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static de.mybike.fahrraeder.FahrradLeser.*;

public class SchreiberVonFahrradern {
		
	private List<Fahrrad> alleRaeder = new ArrayList<Fahrrad>();

	
	public void schriberFahrraTabelle(Fahrrad rad) {
		
		try (Connection conn = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT)) {
			
			Statement stm = conn.createStatement();
			String sqlQuestion = "INSERT INTO " + FAHRRAD_TABELLE;
			sqlQuestion += " VALUES (NULL, ";
			sqlQuestion += "'" + rad.getFarbe() + "',";
			sqlQuestion += "'" + rad.getTyp() + "'," + rad.getGroesse() + ",";
			sqlQuestion += "'" + rad.getVerfuegbarAb().getYear() + "-";
			sqlQuestion += rad.getVerfuegbarAb().getMonthValue() + "-";
			sqlQuestion += rad.getVerfuegbarAb().getDayOfMonth() + "')";
			
			stm.execute(sqlQuestion);

		} catch (SQLException e) {
			System.out.println("Cos nie pyklo");
			e.printStackTrace();
		}
	}

	
	/**
	 * @return the alleRader
	 */
	public void besserSchreiben (Fahrrad rad) {
		
		try (Connection conn = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT)) {
			
			String sqlQuery = "INSERT INTO " + FAHRRAD_TABELLE + " VALUES (NULL, ?, ?, ?, ?)";
			PreparedStatement verpaklungMitPlatzhalter = conn.prepareStatement(sqlQuery);
			
			verpaklungMitPlatzhalter.setString(1, rad.getFarbe());
			verpaklungMitPlatzhalter.setString(2, rad.getTyp());
			verpaklungMitPlatzhalter.setInt(3, rad.getGroesse());
			verpaklungMitPlatzhalter.setDate(4, Date.valueOf(rad.getVerfuegbarAb()));
			
			verpaklungMitPlatzhalter.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void besseerSchreiben(List<Fahrrad> rad) {
		
		try (Connection conn = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT)) {
			
			String sqlQuery = "INSERT INTO " + FAHRRAD_TABELLE + " VALUES (NULL, ?, ?, ?, ?)";
			
			PreparedStatement verpaklungMitPlatzhalter = conn.prepareStatement(sqlQuery);
			
			List<Fahrrad> myList = new ArrayList<Fahrrad>();
			
//			myList.set(1, rad.getFarbe());
//			myList.set(2, rad.getTyp());
//			
//			verpaklungMitPlatzhalter.setString(2, rad.getTyp());
//			verpaklungMitPlatzhalter.setInt(3, rad.getGroesse());
//			verpaklungMitPlatzhalter.setDate(4, Date.valueOf(rad.getVerfuegbarAb()));
//			
			verpaklungMitPlatzhalter.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}		
	}

}
