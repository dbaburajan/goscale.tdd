package application.string.calculator;

import application.string.util.Loggable;
import application.string.util.StringUtil;

/**
 * Class to represent a calculator based on String type input
 * 
 * @author dbaburajan
 */
public final class StringCalculator implements Loggable {

	/**
	 * Add numbers in a string
	 * @param input The numbers represented
	 * 		by a string 
	 * @return The addition of all numbers 
	 * 		present in the supplied string
	 */
	public int add(final String input) {
		if (input == null) {
			throw new IllegalArgumentException("input cannot be null");
		}
		
		final String delimiter;
		final String numStr;
		// Input pattern with delimiters "//[delimiter]\n[numbers...]"
		if (input.startsWith("//")) {
			final String[] parts = input.split("\n", 2);
			if (parts.length == 2) {
				delimiter = parts[0].substring(2);
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
		
		final int sum = add(numbers);
		getLog().info("Sum of numbers [" + numStr + "] is " + sum);
		
		return sum;
	}
	
	private int add(final String[] numbers) {
		int sum = 0;
		
		for (final String no : numbers) {
			sum += StringUtil.convert(no);
		}
		
		return sum;
	}
}
