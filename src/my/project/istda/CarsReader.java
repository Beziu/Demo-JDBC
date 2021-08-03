package my.project.istda;

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
public class CarsReader {
	
	public static final String ADDRESS = "jdbc:mysql://localhost:3306/fahrraederDB";
	public static final String USER = "root";
	public static final String PASSWORT = "";
	public static final String CARS_TABLE = "car";
	
	private List<Car> allCars = new ArrayList<Car>();
	
	
	public void carTableRead() {

		try (Connection connection = DriverManager.getConnection(ADDRESS, USER, PASSWORT)) {
			
			Statement statement = connection.createStatement();
			String sqlQuestion = "SELECT * FROM " + CARS_TABLE;
			ResultSet answerDB = statement.executeQuery(sqlQuestion);
			
			while (answerDB.next()) {
				int carID = answerDB.getInt("car_id");
				String brand = answerDB.getString("car_brand");
				String color = answerDB.getString("car_color");
				String type = answerDB.getString("car_type");
				int price = answerDB.getInt("car_price");
				LocalDate availableFrom = answerDB.getDate("available_from").toLocalDate();
				
				// Tu powstaje objekt DTO Fahrrad
				Car newCar = new Car(brand, color, type, price, availableFrom); 
				newCar.setCarID(carID);
				
				allCars.add(newCar);
			}
			
		} catch (SQLException e) {
			System.out.println("Cos poszlo nie tak :( !!!");
			e.printStackTrace();
		}
	}

	
	/**
	 * @return the alleRader
	 */
	public List<Car> getAllCars() {
		return allCars;
	}

}
