package de.mybike.fahrraeder;

import java.time.LocalDate;
import java.util.Objects;

public class Fahrrad {
	
	private int primaryKey;
	
	private String farbe;
	
	private String typ;
	
	private int groesse;
	
	private LocalDate verfuegbarAb;

	/**
	 * @param farbe is color
	 * @param typ is type
	 * @param groesse is size
	 * @param verfuegbarAb is availble from
	 */
	public Fahrrad(String farbe, String typ, int groesse, LocalDate verfuegbarAb) {
		this.farbe = farbe;
		this.typ = typ;
		this.groesse = groesse;
		this.verfuegbarAb = verfuegbarAb;
	}

	/**
	 * @return the primaryKey
	 */
	public int getPrimaryKey() {
		return primaryKey;
	}

	/**
	 * @param primaryKey the primaryKey to set
	 */
	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}

	/**
	 * @return the farbe
	 */
	public String getFarbe() {
		return farbe;
	}

	/**
	 * @param farbe the farbe to set
	 */
	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	/**
	 * @return the verfuegbarAb
	 */
	public LocalDate getVerfuegbarAb() {
		return verfuegbarAb;
	}

	/**
	 * @param verfuegbarAb the verfuegbarAb to set
	 */
	public void setVerfuegbarAb(LocalDate verfuegbarAb) {
		this.verfuegbarAb = verfuegbarAb;
	}

	/**
	 * @return the typ
	 */
	public String getTyp() {
		return typ;
	}

	/**
	 * @return the groesse
	 */
	public int getGroesse() {
		return groesse;
	}

	@Override
	public int hashCode() {
		return Objects.hash(farbe, groesse, typ);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Fahrrad other = (Fahrrad) obj;
		return Objects.equals(farbe, other.farbe) && groesse == other.groesse && Objects.equals(typ, other.typ);
	}

	@Override
	public String toString() {
		return "Fahhrad [primaryKey=" + primaryKey + ", farbe=" + farbe + ", typ=" + typ + ", groesse=" + groesse
				+ ", verfuegbarAb=" + verfuegbarAb + "]";
	}

}
