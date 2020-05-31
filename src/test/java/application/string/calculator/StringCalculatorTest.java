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
		assertEquals(0, calculator.add("1,2,3"));
	}
}
