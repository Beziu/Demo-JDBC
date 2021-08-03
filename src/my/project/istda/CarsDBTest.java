package my.project.istda;

import java.util.ArrayList;
import java.util.List;

public class CarsDBTest {

	public static void main(String[] args) {
		
		CarsReader cars = new CarsReader();
		cars.carTableRead();
		
		List<Car> allCars = new ArrayList<Car>();
		allCars = cars.getAllCars();
		allCars.forEach(e -> System.out.println(e));
		
		
	}

}
