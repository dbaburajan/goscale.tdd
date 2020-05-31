package application.string.exceptions;

/**
 * Exception to define negative number 
 * 
 * @author dbaburajan
 */
public final class NegativeNumberException extends Exception {

	private static final long serialVersionUID = -5260951589701874405L;
	
	public NegativeNumberException(final int number) {
		super("negatives not allowed: " + number);
	}
}
