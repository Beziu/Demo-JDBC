package de.mybike.fahrraeder;

import java.util.List;

public class FahrradDBTest {

	public static void main(String[] args) {
		FahrradLeser leser = new FahrradLeser();
		leser.lesenFahrraTabelle();
		
		List<Fahrrad> alleBikes = leser.getAlleRaeder();
		
		alleBikes.forEach(r -> System.out.println(r));

	}

}
