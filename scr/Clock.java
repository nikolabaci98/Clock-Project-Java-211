package Project4;


/**
 * Class Clock
 * It creates objects of type Clock that
 * store three values namely hour, minute and second.
 * 
 * It has getters and setters for each of the variables
 * and it overrides the toString method of the Object class.
 * 
 * It two methods, isValidHour() and isValidSixty() are used
 * for error checking.
 * 
 * @author nikolabaci
 */

public class Clock {
	
	private int hour;
	private int minute;
	private int second;
	
	/** Default Constructor */
	Clock() {
		hour = 0;
		minute = 0;
		second = 0;
	}
	/**
	 * A constructor that initializes object's variables
	 * to the parameters that are passed.
	 * @param h hour
	 * @param m minute
	 * @param s second
	 */
	Clock(int h, int m, int s){
		if(isValidHour(h) && isValidSixty(m) && isValidSixty(s)) {
			hour = h;
			minute = m;
			second = s;
		}
		else 	
			throw new IllegalClockException("Invalid time: " +'\t'+'\t' + h + ":" + m + ":" + s);
		
	}
	/**
	 * Checks if the number in argument is valid,
	 * if it is then it initializes the hour variable.
	 * 
	 * @param h hour
	 */
	public void setHour(int h){
		if(isValidHour(h)) hour = h;
		else
			throw new IllegalClockException("Invalid hour: " + h);;
		
	}
	/**
	 * Checks if the number in argument is valid,
	 * if it is then it initializes the minute variable.
	 * 
	 * @param m minute
	 */
	public void setMinute(int m){
		if(isValidSixty(m)) minute = m;
		else
			throw new IllegalClockException("Invalid minutes: " + m);;
		
	}
	/**
	 * Checks if the number in argument is valid,
	 * if it is then it initializes the second variable.
	 * 
	 * @param s second
	 */
	public void setSecond(int s){
		if(isValidSixty(s)) second = s;
		else
			throw new IllegalClockException("Invalid seconds: " + s);
		
	}
	/**
	 * Determines the validity of the hour argument.
	 * Hour is defined from 0 to 23.
	 * @param h hour
	 * @return boolean
	 */
	public  boolean isValidHour(int h){
		if(h >= 0 && h < 24) 
			return true;
		else 
			return false;
	}
	/**
	 * Determines the validity of the minutes and/or seconds argument.
	 * Minutes and seconds are defined from 0 to 59.
	 * @param ms minutes or seconds
	 * @return boolean
	 */
	public boolean isValidSixty(int ms){
		if(ms >= 0 && ms < 60) 
			return true;
		else 
			return false;
	}
	/**
	 * Returns the value of hour variable
	 * @return int
	 */
	public int getHour() {return hour;}
	/**
	 * Returns the value of minute variable
	 * @return int
	 */
	public int getMinute() {return minute;}
	/**
	 * Returns the value of second variable
	 * @return int
	 */
	public int getSecond() {return second;}
	
	/**
	 * Override of Class Object toString() method.
	 * Prints the object as hh:mm:ss
	 */
	public String toString() {return hour+":"+minute+":"+second+"\n";}

	public int compareTo(Clock o) {
		if (this.getHour() >= o.getHour()) return 1;
		else return -1;
	}
	
	
}





















