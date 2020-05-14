package ASSI4;
//Abdallah Kharouf 1183328 Lab_4

import java.util.GregorianCalendar;

public class Passenger extends Person{

	private long pass_no;
	private String nationality;
	private boolean has_visa;
	private String seat_type= "Aisle";


	public Passenger(String firstName, String lastName, char gender, GregorianCalendar dob, long pass_no, String nationality, boolean has_visa, String seat_type) {
		super(firstName, lastName,gender, dob);
		this.pass_no = pass_no;
		this.nationality = nationality;       //No no-arg's constructor because all of these data members are important to be provided//
		this.has_visa = has_visa;
		this.seat_type = seat_type;
	}

	public long getPass_no() {
		return pass_no;
	}

	public void setPass_no(long pass_no) {
		this.pass_no = pass_no;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public boolean isHas_visa() {
		return has_visa;
	}

	public void setHas_visa(boolean has_visa) {
		this.has_visa = has_visa;
	}

	public String getSeat_type() {
		return seat_type;
	}

	public void setSeat_type(String seat_type) {
		this.seat_type = seat_type;
	}

	public void prints() {
		System.out.println(super.toString()+  //inheritance rule! ..//
				  "\n pass_no=" + pass_no +"\n"+
				  ", nationality='" + nationality + "\n" +
				  ", visa=" + has_visa + "\n" +
				  ", seat_type='" + seat_type + "\n" +
				  '}');
	}
}
