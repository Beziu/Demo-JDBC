package de.mybike.fahrraeder;

import java.time.LocalDate;

public class FahrradSchreiberTest {

	public static void main(String[] args) {
		
		Fahrrad neu = new Fahrrad("White", "Pirates", 29, LocalDate.now());
		
		SchreiberVonFahrradern schriber = new SchreiberVonFahrradern();
		
		//schriber.schriberFahrraTabelle(neu);
		schriber.besserSchreiben(neu);
		
		System.out.println("Zapis zakonczony");
	}

}
