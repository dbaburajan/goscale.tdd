package application.string.calculator;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import application.string.events.PrintResultEvent;
import application.string.exceptions.NegativeNumberException;
import application.string.util.Loggable;
import application.string.util.StringUtil;

/**
 * Test class for {@link StringCalculator}
 * 
 * @author dbaburajan
 */
public final class StringCalculatorTest implements Loggable {

	private static StringCalculator calculator;
	
	private static final Logger log = LoggerFactory.getLogger(StringCalculatorTest.class);
	
	@BeforeClass
	public static void init() {
		calculator = new StringCalculator();
		
		calculator.registerEvent(new PrintResultEvent());
	}
	
	@AfterClass
	public static void terminate() {
		log.info("Total call count of StringCalculator.add method is -> " + calculator.getCallCount());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullInput() throws Exception {
		calculator.add(null);
	}

	@Test
	public void testAddEmptyInput() throws Exception {
		assertEquals(0, calculator.add(StringUtil.EMPTY));
	}
	
	@Test
	public void testAddOneInput() throws Exception {
		assertEquals(1, calculator.add("1"));
	}
	
	@Test
	public void testAddTwoInputs() throws Exception {
		assertEquals(3, calculator.add("1,2"));
	}
	
	@Test
	public void testAddMoreThanTwoInputs() throws Exception {
		assertEquals(6, calculator.add("1,2,3"));
	}
	
	@Test
	public void testAddRandomInputs() throws Exception {
		assertEquals(150, calculator.add("15,15,20,100"));
	}
	
	@Test
	public void testAddOnlyNextLineDelimiterInput() throws Exception {
		assertEquals(0, calculator.add("\n"));
	}
	
	@Test
	public void testAddOnlyCommaDelimiterInput() throws Exception {
		assertEquals(0, calculator.add(","));
	}
	
	@Test
	public void testAddNextLineDelimiter() throws Exception {
		assertEquals(10, calculator.add("1\n2\n3\n4"));
	}
	
	@Test
	public void testAddWithDualDelimiters() throws Exception {
		assertEquals(10, calculator.add("1,2\n3,4"));
	}
	
	@Test
	public void testAddWithSeparateDelimiterInvalidSyntax() throws Exception {
		assertNotEquals(10, calculator.add("//;1;2\n3,4"));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testAddWithSeparateDelimiterInvalidSyntaxWithoutNextLineInInput() throws Exception {
		assertNotEquals(10, calculator.add("//;1;2,3,4"));
	}
	
	@Test
	public void testAddWithSeparateDelimiterAsSemicolon() throws Exception {
		assertEquals(10, calculator.add("//;\n1;2\n3,4"));
	}
	
	@Test
	public void testAddWithSeparateDelimiterAsNextline() throws Exception {
		assertEquals(10, calculator.add("//\n\n1\n2\n3,4"));
	}
	
	@Test
	public void testAddWithSeparateDelimiterAsOneCharacter() throws Exception {
		assertEquals(10, calculator.add("//&\n1&2\n3,4"));
	}
	
	@Test
	public void testAddWithSeparateDelimiterAsTwoCharacters() throws Exception {
		assertEquals(10, calculator.add("//&%\n1&%2\n3,4"));
	}
	
	@Test(expected = NegativeNumberException.class)
	public void testAddWithNegativeNumber() throws Exception {
		assertNotEquals(6, calculator.add("//&\n1&-2\n3,4"));
	}
	
	@Test(expected = NegativeNumberException.class)
	public void testAddWithMultipleNegativeNumbers() throws Exception {
		assertNotEquals(6, calculator.add("//&\n1&-2\n-3,4"));
	}
	
	@Test
	public void testAddWithGreaterThanThousandNumber() throws Exception {
		assertNotEquals(1025, calculator.add("//;\n1001;20\n3,1"));
	}
	
	@Test
	public void testAddWithDelimitersOfAnyLength() throws Exception {
		assertEquals(10, calculator.add("//[***]\n1***2***3,4"));
	}
	
	@Test
	public void testAddWithMultipleDelimiters() throws Exception {
		assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void testAddWithMultipleAndDefaultDelimiters() throws Exception {
		assertEquals(10, calculator.add("//[;][%]\n1,2%3;4"));
	}
	
	@Test
	public void testAddWithMultipleDelimitersOfSizeGreaterThanOne() throws Exception {
		assertEquals(6, calculator.add("//[**][%%]\n1**2%%3"));
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddWithoutRegisteringEvent() throws Exception {
		final StringCalculator calc = new StringCalculator();
		
		assertEquals(10, calc.add("//;\n1;2\n3,4"));
	}
	
	@Test
	public void testAddWithRegisteringEvent() throws Exception {
		final StringCalculator calc = new StringCalculator();
		calc.registerEvent(new PrintResultEvent());
		
		assertEquals(10, calc.add("//;\n1;2\n3,4"));
	}
}
