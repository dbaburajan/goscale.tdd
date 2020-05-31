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
	 * @param numStr The numbers represented
	 * 		by a string 
	 * @return The addition of all numbers 
	 * 		present in the supplied string
	 */
	public int add(final String numStr) {
		if (numStr == null) {
			throw new IllegalArgumentException("input cannot be null");
		}
		
		final String[] numbers = numStr.split(StringUtil.COMMA_DELIMITER + StringUtil.REGEX_OR + StringUtil.NEXT_LINE_DELIMITER);
		
		final int sum = add(numbers);
		getLog().info("Sum of numbers [" + numStr + "] is " + sum);
		
		return sum;
	}
	
	private int add(final String[] numbers) {
		int sum = 0;
		
		for (final String no : numbers) {
			sum += StringUtil.removeNull(no);
		}
		
		return sum;
	}
}
