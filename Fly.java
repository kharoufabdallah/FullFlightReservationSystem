package ASSI4;

//Full Reservation System done by: Abdallah Kharouf 1183328 Lab_4

//NOTE: Entering number of seat just in this form > int char < E.g : 17 D or 2 C //
//I used Exception Handling in some cases to facilitate inputting process!//

import java.util.*;

public class Fly {
	static Scanner in = new Scanner(System.in);

	public static int let_int(char let) { // function to convert the letter added into an integer //
		int number =911;
		switch (let) {
			case 'A': {
				number = 0;
				break;
			}
			case 'B': {
				number = 1;
				break;
			}
			case 'C': {
				number = 2;
				break;
			}
			case 'D': {
				number = 3;
				break;
			}
			case 'E': {
				number = 4;
				break;
			}
			case 'F': {
				number = 5;
				break;
			}
			default: {
				System.out.println("Out of index, please choose another seat");
			}
		}
		return number;
	}

	public static void add_trip(ArrayList trips_l,Seat[][]seats) {

		String pre;

		System.out.println("Please Enter the airport you would like to visit! ");
		String F_air = in.next();
		System.out.println("Please Enter airport you will travel from!");
		String T_air = in.next();
		System.out.println("Guess your trip distance ;)");
		double dis = in.nextDouble();
		System.out.println("Add the day, month and year of travel, RESPECTIVELY. E.g 1 3 2019 ");        // Collecting data members of Trip //
		int day1 = in.nextInt();
		int month1 = in.nextInt();
		int year1 = in.nextInt();
		System.out.println("Add the hour and the minutes (Time) you would like to travel :) E.g 2 34");
		int hour1 = in.nextInt();
		int min1 = in.nextInt();
		System.out.println("Add the day, month and year of turing back to your home, respectively E.g 6 4 2019");
		int day2 = in.nextInt();
		int month2 = in.nextInt();
		int year2 = in.nextInt();
		System.out.println("Add the hour and the minutes (Time) you would like to turn back :) E.g 4 15");
		int hour2 = in.nextInt();
		int min2 = in.nextInt();
		Trip trip = new Trip(seats /* ragged array of seats includes first and economy clasees*/,
				  "A320", F_air, T_air, dis, new GregorianCalendar
				  (year1, month1, day1, hour1, min1), new GregorianCalendar
				  (year2, month2, day2, hour2, min2));
		trips_l.add(trip); // function of adding in ArrayList
		System.out.println("The trip you have added is : ");

		trip.prints();

		System.out.println("---------------------------------------------");

		System.out.println("Do you want to add new trip? (Tap yes or no) ");
		pre = in.next();

		switch (pre) {
			case "yes":
				add_trip(trips_l,seats);
				break;

			case "no":
				break;

			default:
				break;
		}
	}

	public static void reserve_seat(ArrayList trips_l, Seat[][] seats) {
		System.out.println("||-------------------------------------------------------------------------------------------------||");
		System.out.println("||Please before reserving a seat, make sure that you have added a trip to reserve a seat in Flight!||");
		System.out.println("||-------------------------------------------------------------------------------------------------||\n");
		boolean yn= true;
		System.out.println("Please, enter 1 to reserve (First Class) seat and 2 to reserve (Economy) seat");
		switch (in.nextInt()) {
			case 1:
				for (int i = 0; i < 4; i++) {
					for (int j = i + 1; j < seats[i].length; j++) {
				    	seats[i][j].setRowNumber(i);
						seats[i][j].setColNumber(j);
					}
				}
				System.out.println("Enter seat number from (1 - 3) and a seat code (A - D) separated by a space or tap enter:");
				int i = in.nextInt();
				int j = let_int(in.next().charAt(0));

				if (i < 0 || i>3 || j > 3) {
					System.out.println("Seat isn't in first class row, please choose another");
					reserve_seat(trips_l,seats);
				} else if (seats[i][j].isReserved()) {
					System.out.println("The seat is reserved. Please choose another");
					reserve_seat(trips_l,seats);
				} else {
					System.out.println("Enter your first name");
					String n = in.next();
					System.out.println("Enter your last name");
					String l = in.next();
					System.out.println("Enter your Gender, M for Male and F for Female |just one letter|");
					char g = in.next().charAt(0);
					System.out.println("Please Add your Date of Birth ");
					System.out.println("Add year of birth e.g 2000");
					int year = in.nextInt();                          // Collecting data members of specific seat in specific chapter
					System.out.println("Add month from 1-12 ");
					int month = in.nextInt();
					System.out.println("Add day of you DOB from 1 -31");
					int day = in.nextInt();
					System.out.println("Enter you passport number");
					long p = in.nextLong();
					System.out.println("Nationality");
					String nat = in.next();
					System.out.println("Do you have an interence visa? if YES write true . if NO write false");
					try
					{
						 yn = in.nextBoolean();      //Exception Handling in order if the user enters
						                            // some values instead of true or false. This procedure saves
						                           // time in order if there's some mistakes in adding values
					}
					catch (InputMismatchException ex)
					{
						System.out.println("You just entered an error input, we expected you have a visa");
					}
					System.out.println("What do you prefer? Aisle, Window or None - between two people - :D");
					String type = in.next();
					System.out.println("What do you prefer? Caviar or Steaks?");
					String food = in.next();
					System.out.println("What do you prefer? Liquore or Carob?");
					String drink = in.next();

					seats[i][j].setPassenger(new Passenger(n, l, g,
							  new GregorianCalendar(year, month, day)     // adding the data in passenger class which it is a data member in abstract seat class
							  , p, nat, yn, type));
					System.out.println("Done ! Your seat has been reserved successfully");
					seats[i][j].setReserved(true);
				}
				break;

			case 2:
				for (i = 6; i < 32; i++) {
					for (j = i + 1; j < seats[i].length; j++) {
						seats[i][j].setRowNumber(i);
						seats[i][j].setColNumber(j);
					}
				}
				System.out.println("Enter seat number from (5 - 30) and a seat code (A - F), separated by space or tap enter:");
				int i2 = in.nextInt();
				int j2 = let_int(in.next().charAt(0));

				if (i2 <= 5 || i2 > 30 || i2 == 13 || j2 > 5) {
					System.out.println("Seat isn't in first class row, please choose another");
					reserve_seat(trips_l,seats);
				} else if (seats[i2][j2].isReserved()) {
					System.out.println("The seat is reserved. Please choose another");
					reserve_seat(trips_l,seats);
				} else {
					System.out.println("Enter your first name");
					String n = in.next();
					System.out.println("Enter your last name");
					String l = in.next();
					System.out.println("Enter your Gender, M for Male and F for Female |just one letter|");
					char g = in.next().charAt(0);
					System.out.println("Please Add your Date of Birth ");
					System.out.println("Add year of birth e.g 2000");
					int year = in.nextInt();
					System.out.println("Add month from 1-12 ");
					int month = in.nextInt();
					System.out.println("Add day of you DOB from 1-31");
					int day = in.nextInt();
					System.out.println("Enter you passport number");
					long p = in.nextLong();
					System.out.println("Nationality");
					String nat = in.next();
					System.out.println("Do you have an enterance visa? if YES write true . if NO write false");
					try
					{
						yn = in.nextBoolean();
					}
					catch (InputMismatchException ex) //Exception Handling in order if the user enter
					                                  // some values instead of true or false.
					{
						System.out.println("You just entered an error input, we expected you have a visa");
					}
					System.out.println("What do you prefer? Aisle, Window or None - between two people- :D");
					String type = in.next();
					System.out.println("What do you prefer? Chicken or Fish?");
					String food = in.next();
					System.out.println("What do you prefer? Cola or Juice?");
					String drink = in.next();

					seats[i2][j2].setPassenger(new Passenger(n, l, g,
							  new GregorianCalendar(year, month, day)
							  , p, nat, yn, type));
					System.out.println("Done ! Your seat has been reserved successfully");
					seats[i2][j2].setReserved(true);
				}
				break;
		}
	}

	public static void display_info(ArrayList trip_l,Seat[][] seats) { // function to display the info of the reserved seat

		Scanner in = new Scanner(System.in);

		System.out.println("Add the seat to display its info");
		int seat = in.nextInt();
		int seat_c = let_int(in.next().charAt(0));
		if (seat > 30 || seat < 0 || seat_c > 5 || seat_c < 0) {
			System.out.println("Error input, try again");
			display_info(trip_l,seats);  // Recursion to return back to the function in order to continue displaying and running
		} else {
			if (!seats[seat][seat_c].isReserved()) {
				System.out.println("Empty Seat. Try again");
				display_info(trip_l,seats);
			}
			else
				System.out.println("The Details shown in our system as below:\n");
			seats[seat][seat_c].passenger.prints();
		}
	}

	public static void search_name(ArrayList trip_l,Seat[][] seats) {

		System.out.println("Enter 1 to search by first name and 2 to search by last name:");

		switch (in.nextInt()) {
			case 1:
				boolean iff = false;
				System.out.println("Add first name:");
				String first = in.next();
				for (int i = 0; i < seats.length; i++) {
					for (int j = 0; j < seats[i].length; j++) {
						if (seats[i][j].isReserved() && (seats[i][j].passenger.getFirstName().equals(first))) {
							iff = true;
							seats[i][j].passenger.prints();
							System.out.println("The seat is "+ i + " and the place is "+ j);
							System.out.println("Note that place 0 is A | 1 is B | 2 is C | 3 is D | 4 is E | 5 is F");
							break;
						}
					}
				}
				if (!iff) {
					System.out.println("This name dosen't exist. Try again");
					search_name(trip_l,seats);
				}
				break;
			case 2:
				boolean iff2 = false;
				System.out.println("Add last name:");
				String last = in.next();
				for (int i = 0; i < seats.length; i++) {
					for (int j = 0; j < seats[i].length; j++) {
						if (seats[i][j].isReserved() && (seats[i][j].passenger.getLastName().equals(last))) /*we used the feature of protected ;)*/
							{
							iff2 = true;
							seats[i][j].passenger.prints();
							System.out.println("The seat is "+ i + " and the place is "+ j);
							System.out.println("Note that place 0 is A | 1 is B | 2 is C | 3 is D | 4 is E | 5 is F");
						}
					}
				}
				if (!iff2) {
					System.out.println("This name does not exist. Try again");
					search_name(trip_l,seats);
				}
				break;
		}
	}

	public static void firstClass_listing(ArrayList trips_l,Seat [][] seats)
	{
		int coise;
		System.out.println("Please add 1 to print just the occupied seats and 2 to print all the seats in First class!");
		coise = in.nextInt();
		switch (coise)
		{
			case 1 :
				System.out.println("The Flight A320 and the trip " + trips_l.toString()+ "contains first class " +
						  "seats");
				for (int i=1;i<4;i++) {
					for (int j = 0; j < 4; j++) {
						if (seats[i][j].isReserved())
						{
							System.out.println(seats[i][j].toString());
							seats[i][j].passenger.prints();
						}
					}
				}
				break;
			case 2 :
				System.out.println("The Flight A320 and the trip " + trips_l.toString()+ "contains first class " +
						  "seats");
				for (int i=1;i<4;i++)
				{
					for (int j =0;j<4;j++)
					{
						System.out.println(seats[i][j].toString());
					}
				}
				break;
		}
	}

	public static void economy_listing(ArrayList trips_l,Seat [][] seats)
	{
		int coise;
		//Arrays.sort(seats);
		System.out.println("Please add 1 to print just the occupied seats and 2 to print all the seats in economy chapter!");
		coise = in.nextInt();
		switch (coise)
		{
			case 1 :
				System.out.println("The Flight A320 and the trip " + trips_l.toString()+ "contains Economy " +
						  "seats");
				for (int i=6;i<32;i++) {
					for (int j = 0; j < 6; j++) {
						if (seats[i][j].isReserved())
						{
							System.out.println(seats[i][j].toString());
						}
					}
				}
				break;
			case 2 :
				System.out.println("The Flight A320 and the trip " + trips_l.toString()+ "contains Economy " +
						  "seats");
				for (int i=6;i<32;i++)
				{
					for (int j =0;j<6;j++)
					{
						System.out.println(seats[i][j].toString());
					}
				}
				break;
		}
	}

	public static void change_seat(ArrayList trips_l,Seat[][]seats)
	{
		int newS;
		int newP;
		System.out.println("Please Enter your original reserved seat E.g 10 C");
		int i= in.nextInt();
		int j= let_int(in.next().charAt(0));
				if (seats[i][j].isReserved())
				{
					System.out.println("Enter your new preferred seat E.g 15 D");
					newS = in.nextInt();
					newP = let_int(in.next().charAt(0));
					seats[i][j].setRowNumber(newS);                      //Changing seat reserves new seat in the array that
					                                                     // allows canceling new changed seat!
					seats[i][j].setColNumber(newP);
					seats[newS][newP].setReserved(true);
					seats[i][j].setReserved(false);
					System.out.println("Done, the seat has been changed!");
				}
				else {
					System.out.println("You entered an empty seat");
					change_seat(trips_l, seats);
				}
			}

	public static void cancel(ArrayList trips_l,Seat[][] seats)
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Add the seat number to cancel. E.g 10 C");
		int seat = in.nextInt();
		int seat_c = let_int(in.next().charAt(0));
		if (seat > 30 || seat < 0 || seat_c > 5 || seat_c < 0) {
			System.out.println("Error input, try again");
			cancel(trips_l,seats);  // Recursion to return back to the
			                        // function in order to continue displaying and running
		} else {
			if (!seats[seat][seat_c].isReserved()) {
				System.out.println("Empty Seat. Try again:");
				cancel(trips_l,seats);
			}
			else if(seats[seat][seat_c].isReserved()) {
				seats[seat][seat_c].setReserved(false);
				System.out.println("Seat "+ "you chosen "+ "is canceled");
			}
		}
	}

	public static void main(String[] args) {

		ArrayList<Trip> trips_l = new ArrayList<>(); //creating arraylist of Trips//

		Seat[][] seats = new Seat[32][]; //ragged array of seats//
		seats[0] = new Seat[0];
		seats[1] = new FirstClass[4];
		seats[2] = new FirstClass[4];
		seats[3] = new FirstClass[4];                  // initializing the 2nd dimension of each array up to requested//
		seats[4] = new Seat[0];
		seats[5] = new Seat[0];
		seats[13] = new Seat[0];

		for (int i=6;i<32;i++)
		{
			seats[i] = new Economy[6];
		}

		for (int i = 1  ; i<4 ; i++)
		{
			for (int j=0 ; j<4 ; j++)
			{
				seats[i][j] = new FirstClass() ;  // creating first_class ragged array object using inheritance..//
			}
		}
		for (int i=6;i<32;i++)
		{
			for (int j =0;j<6;j++)
			{
				seats[i][j] = new Economy();     // creating economy ragged array object using inheritance..//
			}
		}
				int chosen =0;

				while (true) {                           //main menu
					System.out.println("Hi! Here's the reservation system of Abdallah Kharouf!  " +
							             "We hope you are in a good health \n ------------------------------------------\n");
					System.out.println("Choose from the list what you need to execute !");
					System.out.println("0. To add a new trip ");
					System.out.println("1. To reserve new seat (First Class from 1-3 and Economy from 6 - 31)" +
							             "Based on your preferences ;)");
					System.out.println("2. To display the info of the chosen seat");
					System.out.println("3. To search for the passenger from the first or last name");
					System.out.println("4. To print list of the first class seat's passenger");
					System.out.println("5. To print list of the economy seat's passenger");
					System.out.println("6. To change your seat");
					System.out.println("7. To cancel your reservation");
					System.out.println("8. To EXIT SYSTEM");

					chosen = in.nextInt();

					if (chosen > 8 || chosen < 0) {
						System.out.println("---------->>Error Input<<\n--------------");
					}

					switch (chosen) {
						case 0:
							add_trip(trips_l,seats);
							break;

						case 1:
							reserve_seat(trips_l,seats);
							break;

				      case 2:
					       display_info(trips_l,seats);
					         break;

				       case 3 :
					       search_name(trips_l,seats);
					       break;

				       case 4 :
				       	firstClass_listing(trips_l,seats);
				       	break;

						case 5:
							economy_listing(trips_l,seats);
							break;

						case 6:
							change_seat(trips_l,seats);
							break;

				       case 7:
				       	 cancel(trips_l,seats);
					        break;

						case 8:
							System.out.println("Thanks for dealing with us. Good Bye !");
							System.exit(8);
					}
				}
			}
		}