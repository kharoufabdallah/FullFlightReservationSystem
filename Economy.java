package ASSI4;
//Abdallah Kharouf 1183328 Lab_4
public class Economy extends Seat{
	private String foodPreferE = "Chicken";
	private String drinkPreferE = "Cola";
	private boolean reserved = false;

	public Economy() {
	}

	public Economy(int rowNumber, int colNumber, String seatNumber, Passenger passenger, boolean reserved, String foodPreferE, String drinkPreferE, boolean reserved1) {
		super(rowNumber, colNumber, seatNumber, passenger, reserved);
		this.foodPreferE = foodPreferE;
		this.drinkPreferE = drinkPreferE;
		this.reserved = reserved;
	}

	public String getFoodPreferE() {
		return foodPreferE;
	}

	public void setFoodPreferE(String foodPreferE) {
		this.foodPreferE = foodPreferE;
	}

	public String getDrinkPreferE() {
		return drinkPreferE;
	}

	public void setDrinkPreferE(String drinkPreferE) {
		this.drinkPreferE = drinkPreferE;
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
		return "Economy{" + super.toString() + "\n" +
				  "foodPreferE='" + foodPreferE + "\n" +
				  ", drinkPreferE='" + drinkPreferE + "\n" +
				  '}';
	}
}
