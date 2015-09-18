package RomanNumbers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RomanNumbersTester {

	private RomanNumberConverter romanNumberConverter;

	@Before
	public void instantiateRomanNumbersConverter() {
		romanNumberConverter = new RomanNumberConverter();
	}

	public void doAssert(Integer arabic, String roman) {
		Assert.assertEquals(romanNumberConverter.convert(arabic), roman);
	}

	@Test
	public void oneToRoman() {
		doAssert(1, "I");
	}

	@Test
	public void simpleRomanConversions() {
		Assert.assertEquals(romanNumberConverter.convert(3), "III");

		Assert.assertEquals(romanNumberConverter.convert(5), "V");

		Assert.assertEquals(romanNumberConverter.convert(10), "X");
		Assert.assertEquals(romanNumberConverter.convert(15), "XV");

		Assert.assertEquals(romanNumberConverter.convert(50), "L");

		Assert.assertEquals(romanNumberConverter.convert(100), "C");

		Assert.assertEquals(romanNumberConverter.convert(500), "D");

		Assert.assertEquals(romanNumberConverter.convert(1000), "M");
	}

	@Test
	public void complexRomanNumbers() {
		Assert.assertEquals(romanNumberConverter.convert(42), "XLII");
		doAssert(2896, "MMDCCCXCVI");
	}

	@Test
	public void decode90() {
		doAssert(90, "XC");
	}
}
