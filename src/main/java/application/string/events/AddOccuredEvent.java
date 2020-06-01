package application.string.events;

/**
 * A single method interface for event to be
 * triggered by StringCalculator client applications
 * after string addition calculation
 * 
 * @author dbaburajan
 */
@FunctionalInterface
public interface AddOccuredEvent {
    /**
     * Declare an event to be triggered after sum is
     * calculated with the input 
     * @param input The input string
     * @param result The sum of the numbers in
     * the string input
     */
    void addOccured(final String input, final int result);
}
