package application.string.events;

import org.apache.commons.text.StringEscapeUtils;

import application.string.util.AddOccuredImpl;
import application.string.util.Loggable;

/**
 * An event class to print the results of the input
 * 
 * @author dbaburajan
 */
public final class PrintResult implements AddOccuredImpl, Loggable {

	@Override
	public void addOccured(final String input, final int result) {
		getLog().info("Sum of input string: [ " + StringEscapeUtils.escapeJava(input) + " ] is " + result);
	}

}
