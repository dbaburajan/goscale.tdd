package application.string.events;

/**
 * Interface to ensure StringCalculator invokers to declare 
 * this single method definition for event occurring 
 * after string addition calculation
 * 
 * @author dbaburajan
 */
@FunctionalInterface
public interface AddOccuredEvent {
	/**
	 * Declare an event to be trigerred after sum is
	 * calculated with the input 
	 * @param input The input string
	 * @param result The addition sum of the numbers in
	 * the string input
	 */
	void addOccured(final String input, final int result);
}
