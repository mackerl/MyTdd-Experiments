package PrimeFactorTest;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PrimeFactorTest {

	private List<Integer> list(Integer... ints) {
		return Arrays.asList(ints);
	}

	@Test
	public void factorTest() {
		assertThat(factor(1), is(list()));
		assertThat(factor(2), is(list(2)));
		assertThat(factor(3), is(list(3)));
		assertThat(factor(4), is(list(2, 2)));
		assertThat(factor(5), is(list(5)));
		assertThat(factor(6), is(list(2, 3)));
		assertThat(factor(8), is(list(2, 2, 2)));
		assertThat(factor(9), is(list(3, 3)));
		assertThat(factor(2 * 3 * 5 * 7 * 11 * 11 * 13 * 19),
				is(list(2, 3, 5, 7, 11, 11, 13, 19)));

	}

	private List<Integer> factor(int n) {
		List<Integer> factors = new ArrayList<Integer>();

		for (int factor = 2; n > 1; factor++)
			for (; n % factor == 0; n /= factor)
				factors.add(factor);

		return factors;
	}
}
