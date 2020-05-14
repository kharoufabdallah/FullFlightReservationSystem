package ASSI4;
//Abdallah Kharouf 1183328 Lab_4

import java.util.Arrays;
import java.util.GregorianCalendar;  // We have to make an Array_list of Trips differs than the
                                     // ultimate ragged array of seats.
                                     //like the previous assignment, we have to add the seats
                                     // array in the arguments of the new Trip Object in the created Arra_list//

	public class Trip implements Comparable<Trip>{ //Using interface//
		protected Seat[][] seat_trip; //ragged array of seats as a data member
		private String flight_no;
		private String to_air;
		private String f_air;
		private double distance;
		private GregorianCalendar dip_time;
		private GregorianCalendar ar_time;


		public Trip(Seat[][] seat_trip, String flight_no, String f_air, String to_air, double distance, GregorianCalendar dip_time, GregorianCalendar ar_time) {
			this.seat_trip = seat_trip;
			this.flight_no = flight_no;
			this.f_air = f_air;
			this.to_air = to_air;
			this.distance = distance;
			this.dip_time = dip_time;
			this.ar_time = ar_time;
		}

		public Seat[][] getSeat_trip() {
			return seat_trip;
		}

		public void setSeat_trip(Seat[][] seat_trip) {
			this.seat_trip = seat_trip;
		}

		public String getFlight_no() {
			return flight_no;
		}

		public void setFlight_no(String flight_no) {
			this.flight_no = flight_no;
		}

		public String getF_air() {
			return f_air;
		}

		public void setF_air(String f_air) {
			this.f_air = f_air;
		}

		public String getTo_air() {
			return to_air;
		}

		public void setTo_air(String to_air) {
			this.to_air = to_air;
		}

		public double getDistance() {
			return distance;
		}

		public void setDistance(double distance) {
			this.distance = distance;
		}

		public GregorianCalendar getDip_time() {
			return dip_time;
		}

		public void setDip_time(GregorianCalendar dip_time) {
			this.dip_time = dip_time;
		}

		public GregorianCalendar getAr_time() {
			return ar_time;
		}

		public void setAr_time(GregorianCalendar ar_time) {
			this.ar_time = ar_time;
		}

		public void prints() {
			System.out.println( "Trip :" +
					  ",\n flight number # ='" + flight_no + '\'' +
					  ",\n from airport='" + f_air + '\'' +
					  ",\n to airport='" + to_air + '\'' +
					  ",\n distance=" + distance +
					  ",\n diparture time=" + dip_time +
					  ",\n arrival time=" + ar_time
			);
		}

		@Override
		public String toString() {
			return "Trip{" +
					  "seat_trip=" + Arrays.toString(seat_trip) +
					  ", flight_no='" + flight_no + '\'' +
					  ", to_air='" + to_air + '\'' +
					  ", f_air='" + f_air + '\'' +
					  ", distance=" + distance +
					  ", dip_time=" + dip_time +
					  ", ar_time=" + ar_time +
					  '}';
		}

		@Override
		public int compareTo(Trip trip) {
			return 0;
		}
	}

