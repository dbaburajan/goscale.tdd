package application.string.util;

/**
 * Implementation to declare single method definition
 * for event occurring after the string addition calculation
 * 
 * @author dbaburajan
 */
@FunctionalInterface
public interface AddOccuredImpl {
	/**
	 * Declare an event to be trigerred after sum is
	 * calculated with the input 
	 * @param input The input string
	 * @param result The addition sum of the numbers in
	 * the string input
	 */
	void addOccured(final String input, final int result);
}
