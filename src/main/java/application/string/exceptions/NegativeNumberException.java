package application.string.exceptions;

import java.util.List;

import application.string.util.Loggable;

/**
 * Exception to define negative number 
 * 
 * @author dbaburajan
 */
public final class NegativeNumberException extends Exception implements Loggable {

	private static final long serialVersionUID = -5260951589701874405L;
	
	public NegativeNumberException(final List<Integer> numbers) {
		super("negatives not allowed: " + numbers.toString());
		
		// XXX
		// Just logging an entry
		// Can be removed
		getLog().error(getMessage());
	}
}
