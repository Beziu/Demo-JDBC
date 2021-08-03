package my.project.istda;

import java.time.LocalDate;
import java.util.Objects;

public class Car {
	
	private int carID;
	
	private String carBrand;
	
	private String carColor;
	
	private String carType;
	
	private int carPrice;
	
	private LocalDate availableFrom;

	/**
	 * @param carBrand
	 * @param carColor
	 * @param carType
	 * @param carPrice
	 */
	public Car(String carBrand, String carColor, String carType, int carPrice, LocalDate availableFrom) {
		this.carBrand = carBrand;
		this.carColor = carColor;
		this.carType = carType;
		this.carPrice = carPrice;
		this.availableFrom = availableFrom;
	}

	/**
	 * @return the carID
	 */
	public int getCarID() {
		return carID;
	}

	/**
	 * @param carID the carID to set
	 */
	public void setCarID(int carID) {
		this.carID = carID;
	}

	/**
	 * @return the carBrand
	 */
	public String getCarBrand() {
		return carBrand;
	}

	/**
	 * @param carBrand the carBrand to set
	 */
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	/**
	 * @return the carColor
	 */
	public String getCarColor() {
		return carColor;
	}

	/**
	 * @param carColor the carColor to set
	 */
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	/**
	 * @return the carType
	 */
	public String getcarType() {
		return carType;
	}

	/**
	 * @param carType the carType to set
	 */
	public void setCarSegment(String carType) {
		this.carType = carType;
	}

	/**
	 * @return the carPrice
	 */
	public int getCarPrice() {
		return carPrice;
	}

	/**
	 * @param carPrice the carPrice to set
	 */
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	@Override
	public String toString() {
		return "Car [carID=" + carID + ", carBrand=" + carBrand + ", carColor=" + carColor + ", carType="
				+ carType + ", carPrice=" + carPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carBrand, carColor, carPrice, carType);
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
		Car other = (Car) obj;
		return Objects.equals(carBrand, other.carBrand) && Objects.equals(carColor, other.carColor)
				&& carPrice == other.carPrice && Objects.equals(carType, other.carType);
	}

	/**
	 * @return the availableFrom
	 */
	public LocalDate getAvailableFrom() {
		return availableFrom;
	}

	/**
	 * @param availableFrom the availableFrom to set
	 */
	public void setAvailableFrom(LocalDate availableFrom) {
		this.availableFrom = availableFrom;
	}
	

}
