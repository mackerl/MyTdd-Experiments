package CoinChanger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CoinChangerTest {

	private CoinChanger coinChanger;

	private List<Integer> list(Integer... ints) {
		return Arrays.asList(ints);
	}

	private List<Integer> changeEuro(int amount) {
		coinChanger.setAvailableCoins(1, 2, 5, 10, 20, 50);
		return coinChanger.change(amount);
	}

	private List<Integer> changeKata1(int amount) {
		coinChanger.setAvailableCoins(10, 7, 1);
		return coinChanger.change(amount);
	}

	@Before
	public void before() {
		coinChanger = new CoinChanger();
	}

	@Test
	public void coinChangerEuro() {

		assertThat(changeEuro(0), is(list()));
		assertThat(changeEuro(1), is(list(1)));
		assertThat(changeEuro(2), is(list(2)));
		assertThat(changeEuro(3), is(list(2, 1)));
		assertThat(changeEuro(4), is(list(2, 2)));
		assertThat(changeEuro(5), is(list(5)));

		assertThat(changeEuro(99), is(list(50, 20, 20, 5, 2, 2)));

		assertThat(changeEuro(75), is(list(50, 20, 5)));
	}

	@Test
	public void coinChangerKata1() throws Exception {
		assertThat(changeKata1(0), is(list()));
		assertThat(changeKata1(14), is(list(7, 7)));

		assertThat(changeKata1(37), is(list(10, 10, 10, 7)));
	}
}
