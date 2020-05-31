package application.string.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import application.string.util.StringUtil;

/**
 * Test class for {@link StringCalculator}
 * 
 * @author dbaburajan
 */
public final class StringCalculatorTest {

	private StringCalculator calculator;
	
	@Before
	public void init() {
		calculator = new StringCalculator();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullInput() {
		calculator.add(null);
	}

	@Test
	public void testAddEmptyInput() {
		assertEquals(0, calculator.add(StringUtil.EMPTY));
	}
	
	@Test
	public void testAddOneInput() {
		assertEquals(1, calculator.add("1"));
	}
	
	@Test
	public void testAddTwoInputs() {
		assertEquals(3, calculator.add("1,2"));
	}
	
	@Test
	public void testAddMoreThanTwoInputs() {
		assertEquals(6, calculator.add("1,2,3"));
	}
	
	@Test
	public void testAddRandomInputs() {
		assertEquals(150, calculator.add("15,15,20,100"));
	}
	
	@Test
	public void testAddOnlyNextLineDelimiterInput() {
		assertEquals(0, calculator.add("\n"));
	}
	
	@Test
	public void testAddOnlyCommaDelimiterInput() {
		assertEquals(0, calculator.add(","));
	}
	
	@Test
	public void testAddNextLineDelimiter() {
		assertEquals(10, calculator.add("1\n2\n3\n4"));
	}
	
	@Test
	public void testAddWithDualDelimiters() {
		assertEquals(10, calculator.add("1,2\n3,4"));
	}
	
	@Test
	public void testAddWithSeparateDelimiterInvalidSyntax() {
		assertNotEquals(10, calculator.add("//;1;2\n3,4"));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testAddWithSeparateDelimiterInvalidSyntaxWithoutNextLineInInput() {
		assertNotEquals(10, calculator.add("//;1;2,3,4"));
	}
	
	@Test
	public void testAddWithSeparateDelimiterAsSemicolon() {
		assertEquals(10, calculator.add("//;\n1;2\n3,4"));
	}
	
	@Test
	public void testAddWithSeparateDelimiterAsNextline() {
		assertEquals(10, calculator.add("//\n\n1\n2\n3,4"));
	}
	
	@Test
	public void testAddWithSeparateDelimiterAsOneCharacter() {
		assertEquals(10, calculator.add("//&\n1&2\n3,4"));
	}
	
	@Test
	public void testAddWithSeparateDelimiterAsTwoCharacters() {
		assertEquals(10, calculator.add("//&%\n1&%2\n3,4"));
	}
}
