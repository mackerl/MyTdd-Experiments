package FizzBuzz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTester {

	private FizzBuzz fizzBuzz;

	@Before
	public void instantiateFizzBuzz() {
		fizzBuzz = new FizzBuzz();
	}

	@Test
	public void FizzBuzzReturns100Elements() {
		Assert.assertEquals(fizzBuzz.print().length, 100);
	}

	@Test
	public void FizzBuzzContainsFizz() {
		String[] fizzBuzzs = fizzBuzz.print();

		boolean found = false;
		for (String string : fizzBuzzs) {
			if (string.equals("fizz")) {
				found = true;
				break;
			}
		}
		Assert.assertEquals(found, true);
	}

	@Test
	public void FizzBuzzContainsBuzz() {
		String[] fizzBuzzs = fizzBuzz.print();

		boolean found = false;
		for (String string : fizzBuzzs) {
			if (string.equals("buzz")) {
				found = true;
				break;
			}
		}
		Assert.assertEquals(found, true);
	}

	@Test
	public void TestAllFizz() {
		String[] fizzBuzzs = fizzBuzz.print();

		for (int i = 3; i < 100; i += 3) {
			boolean found = false;
			if (fizzBuzzs[i].contains("fizz")) {
				found = true;
			}
			Assert.assertEquals(found, true);
		}
	}

	@Test
	public void TestAllBuzz() {
		String[] fizzBuzzs = fizzBuzz.print();

		for (int i = 5; i < 100; i += 5) {
			boolean found = false;
			if (fizzBuzzs[i].contains("buzz")) {
				found = true;
			}
			Assert.assertEquals(found, true);
		}
	}
}
