package application.string.events;

import org.apache.commons.text.StringEscapeUtils;

import application.string.util.Loggable;

/**
 * An event class implementation of {@link AddOccuredEvent}
 * to print the result of the addition of input numbers
 * embedded within a string
 * 
 * @author dbaburajan
 */
public final class PrintResultEvent implements AddOccuredEvent, Loggable {

    @Override
    public void addOccured(final String input, final int result) {
        getLog().info("Sum of input string: [ " + StringEscapeUtils.escapeJava(input) + " ] is " + result);
    }

}
