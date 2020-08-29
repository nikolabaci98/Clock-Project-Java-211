package Project4;

/**
 * IllegalClockException inherits from IllegalArgumentException
 * 
 * @author nikolabaci
 *
 */
@SuppressWarnings("serial")
public class IllegalClockException extends IllegalArgumentException {
	
	public IllegalClockException(String message) {
		super(message);
	}
}
