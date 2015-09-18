package StringCalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTester {

	StringCalculator stringCalculator;

	@Before
	public void instantiateCalculator() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void emptyStringIsZero() throws NoNegativesAllowed {
		Assert.assertEquals(stringCalculator.add(""), 0);
	}

	@Test
	public void anyNumberIsNumber() throws NoNegativesAllowed {
		Assert.assertEquals(stringCalculator.add("1"), 1);
		Assert.assertEquals(stringCalculator.add("999"), 999);
	}

	@Test
	public void twoNumbersreturnSum() throws NoNegativesAllowed {
		Assert.assertEquals(stringCalculator.add("0,1"), 1);
	}

	@Test
	public void testMultipleSum() throws NoNegativesAllowed {
		Assert.assertEquals(stringCalculator.add("0,1,12,100"), 113);
	}

	@Test
	public void testMultipleSumWithNewlines() throws NoNegativesAllowed {
		Assert.assertEquals(stringCalculator.add("0,1\n12,100"), 113);
		Assert.assertEquals(stringCalculator.add("0,1,\n12,100"), 113);
	}

	@Test
	public void testNewDelimiter() throws NoNegativesAllowed {
		Assert.assertEquals(stringCalculator.add("//;\n1;2"), 3);
	}

	@Test(expected = NoNegativesAllowed.class)
	public void testNoNegatives() throws NoNegativesAllowed {
		try {
			stringCalculator.add("0,-1,\n12,100");
		} catch (NoNegativesAllowed noNegativesAllowed) {
			String message = noNegativesAllowed.getMessage();
			System.out.println(message);
		}

		try {
			stringCalculator.add("0,-1,\n-12,100");
		} catch (NoNegativesAllowed noNegativesAllowed) {
			String message = noNegativesAllowed.getMessage();
			System.out.println(message);
			throw noNegativesAllowed;
		}
	}

	@Test
	public void numberGreaterThousandIgnored() throws NoNegativesAllowed {
		Assert.assertEquals(stringCalculator.add("0,1\n12,1000"), 13);
	}

	@Test
	public void delimitersOfAnyLength() throws NoNegativesAllowed {
		Assert.assertEquals(stringCalculator.add("//[***]\n100***2***3"), 105);
	}
}
