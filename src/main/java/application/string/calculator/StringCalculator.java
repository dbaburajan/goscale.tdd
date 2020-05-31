package application.string.calculator;

import java.util.ArrayList;
import java.util.List;

import application.string.exceptions.NegativeNumberException;
import application.string.util.AddOccuredImpl;
import application.string.util.Loggable;
import application.string.util.StringUtil;

/**
 * Class to represent a calculator based on String type input
 * 
 * @author dbaburajan
 */
public final class StringCalculator implements Loggable {

	private static int callCount = 0;
	
	private AddOccuredImpl event;
	
	/**
	 * Add numbers in a string
	 * @param input The numbers represented
	 * 		by a string 
	 * @return The addition of all numbers 
	 * 		present in the supplied string
	 * @throws NegativeNumberException 
	 */
	public int add(final String input) throws NegativeNumberException {
		callCount++;

		if (input == null) {
			throw new IllegalArgumentException("input cannot be null");
		}
		
		final String delimiter;
		final String numStr;
		if (input.startsWith("//")) {
			final String[] parts = input.split("\n", 2);
			if (parts.length == 2) {
				if (parts[0].indexOf('[') != parts[0].lastIndexOf('[')) {
					// Multiple delimiter case
					final String replacedStr = parts[0].replace("]", "]|");
					delimiter = replacedStr.substring(2, replacedStr.lastIndexOf('|'));
				} else {
					delimiter = parts[0].substring(2);
				}
				numStr = parts[1];
			} else {
				throw new UnsupportedOperationException("Invalid syntax -> " + input);
			}
		} else {
			delimiter = StringUtil.EMPTY;
			numStr = input;
		}
		
		// TODO
		// Add StringBuilder to make it immutable
		String regexPtn = StringUtil.COMMA_DELIMITER + StringUtil.REGEX_OR + StringUtil.NEXT_LINE_DELIMITER;
		if (!StringUtil.isNullOrEmpty(delimiter)) {
			regexPtn += StringUtil.REGEX_OR + delimiter;
		}
		final String[] numbers = numStr.split(regexPtn);
		
		final int sum = sum(numbers);
		event.addOccured(input, sum);
		
		return sum;
	}
	
	/**
	 * Get the count of times add method was called
	 * @return The total number of times
	 * add method was called
	 */
	public int getCallCount() {
		return callCount;
	}
	
	public void registerEvent(final AddOccuredImpl event) {
		this.event = event;
	}
	
	private int sum(final String[] numbers) throws NegativeNumberException {
		int sum = 0;
		
		final List<Integer> negativeNos = new ArrayList<Integer>();
		for (final String no : numbers) {
			final int value = StringUtil.convert(no);
			if (value < 0) {
				negativeNos.add(value);
			} else if (value > 1000) {
				getLog().warn("Ignoring greater than 1000 number: " + value);
				continue;
			}
			sum += value;
		}
		
		if (!negativeNos.isEmpty()) {
			throw new NegativeNumberException(negativeNos);
		}
		
		return sum;
	}
}
