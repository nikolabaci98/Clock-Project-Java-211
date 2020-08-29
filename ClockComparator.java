package Project4;

import java.util.Comparator;
/**
 * This class enables us to create a TreeMap which can 
 * effectively sort our clocks.
 * 
 * Comparator interface is defined for objects of class Object,
 * but <Clock> makes it deal only with class Clock instead.
 * 
 * It has only one method. Makes use of the compareTo method
 * which is overridden in class Clock.
 *   
 * @author nikolabaci
 *
 */
public class ClockComparator implements Comparator <Clock> {

	@Override
	public int compare(Clock o1, Clock o2) {
		// TODO Auto-generated method stub
		return 0;
	}


}
