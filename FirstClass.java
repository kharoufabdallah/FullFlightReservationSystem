package ASSI4;
//Abdallah Kharouf 1183328 Lab_4

public class FirstClass extends Seat{
	private String foodPreferF = "Caviar";
	private String drinkPreferF = "Liquore";
	private boolean reserved = false;

	public FirstClass() {

	}

	public FirstClass(int rowNumber, int colNumber, String seatNumber, Passenger passenger, boolean reserved, String foodPreferF, String drinkPreferF, boolean reserved1) {
		super(rowNumber, colNumber, seatNumber, passenger, reserved);
		this.foodPreferF = foodPreferF;
		this.drinkPreferF = drinkPreferF;
		this.reserved = reserved1;
	}

	public String getFoodPreferF() {
		return foodPreferF;
	}

	public void setFoodPreferF(String foodPreferF) {
		this.foodPreferF = foodPreferF;
	}

	public String getDrinkPreferF() {
		return drinkPreferF;
	}

	public void setDrinkPrefer(String drinkPreferF) {
		this.drinkPreferF = drinkPreferF;
	}

	@Override
	public boolean isReserved() {
		return reserved;
	}

	@Override
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	@Override
	public String toString() {
		return "FirstClass{" + super.toString() +"\n"+
				  "foodPreferF='" + foodPreferF + "\n" +
				  ", drinkPreferF='" + drinkPreferF ;
	}
}
