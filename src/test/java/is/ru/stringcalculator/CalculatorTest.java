package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testsOneOtherNumber(){
    	assertEquals(4, Calculator.add("4"));
    }

    @Test
    public void testsMultipleNumbers(){
    	assertEquals(100, Calculator.add("10,20,30,40"));
    }

    @Test
    public void testsNewDelim(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Rule
        public ExpectedException thrown = ExpectedException.none();

        @Test
        public void shouldTestExceptionMessage1() throws RuntimeException {

        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Negatives not allowed: -1");
        Calculator.add("-1,2");
        }

    @Test
    public void testsOverBigNumber(){
        assertEquals(2, Calculator.add("1001,2"));
    }

}   