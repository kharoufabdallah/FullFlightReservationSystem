package ASSI4;
//Abdallah Kharouf 1183328 Lab_4
import java.util.GregorianCalendar;

public abstract class Person {
	private String firstName;
	private String lastName;
	private char gender;
	private GregorianCalendar dob; // Gregorian calender to facilitate creating objects and more useable for me //

	public Person() {   //Default constructor to make inherited classes of this abstract class//
	}

	public Person(String firstName, String lastName, char gender, GregorianCalendar dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {

		if(gender == 'M' || gender == 'F' )
		{
			this.gender = gender;
		}
		else
			System.out.println("Error input of gender, Enter M or F");
	}

	public GregorianCalendar getDob() {
		return dob;
	}

	public void setDob(GregorianCalendar dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Person{" +"\n"+
				  "firstName=" + firstName + "\n" +
				  ", lastName=" + lastName + "\n" +
				  ", gender=" + gender +"\n"+
				  ", dob=" + dob +
				  '}';
	}
}
