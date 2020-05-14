package ASSI4;
//Abdallah Kharouf 1183328 Lab_4

public abstract class Seat {
	private int rowNumber;
	private int colNumber;
	private String seatNumber;
	protected Passenger passenger;   //Not private passenger in order to give access easily in the same directory //
	boolean reserved = false;

	public Seat() {
	}

	public Seat(int rowNumber, int colNumber, String seatNumber, Passenger passenger, boolean reserved) {
		this.rowNumber = rowNumber;
		this.colNumber = colNumber;
		this.seatNumber = seatNumber;
		this.passenger = passenger;
		this.reserved = reserved;
	}


	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getColNumber() {
		return colNumber;
	}

	public void setColNumber(int colNumber) {
		this.colNumber = colNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	@Override
	public String toString() {
		return "Seat{" +"\n"+
				  "rowNumber=" + rowNumber + "\n"+
				  ", colNumber=" + colNumber + "\n" +
				  ", passenger=" + passenger +
				  '}';
	}

}
