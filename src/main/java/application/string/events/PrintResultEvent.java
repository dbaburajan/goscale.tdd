package application.string.events;

import org.apache.commons.text.StringEscapeUtils;

import application.string.util.Loggable;

/**
 * An event class to print the results of the input
 * 
 * @author dbaburajan
 */
public final class PrintResultEvent implements AddOccuredEvent, Loggable {

	@Override
	public void addOccured(final String input, final int result) {
		getLog().info("Sum of input string: [ " + StringEscapeUtils.escapeJava(input) + " ] is " + result);
	}

}
