package BowlingGame;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {

	private BowlingGame bowlingGame;

	@Before
	public void instantiateGame() {
		bowlingGame = new BowlingGame();
	}

	@Test
	public void roll() throws Exception {
		bowlingGame.roll(0);
	}

	@Test
	public void dumpGame() throws Exception {
		rollMany(0, 20);

		assertThat(bowlingGame.score(), is(0));
	}

	private void rollMany(int pins, int howMany) {
		for (int i = 0; i < howMany; i++) {
			bowlingGame.roll(pins);
		}
	}

	@Test
	public void ones() throws Exception {
		rollMany(1, 20);

		assertThat(bowlingGame.score(), is(20));

	}

	@Test
	public void spare() throws Exception {
		rollSpare();
		rollMany(1, 18);

		assertThat(bowlingGame.score(), is(29));
	}

	private void rollSpare() {
		bowlingGame.roll(5);
		bowlingGame.roll(5);
	}

	@Test
	public void strike() throws Exception {
		rollStrike();
		rollMany(1, 18);

		assertThat(bowlingGame.score(), is(30));
	}

	private void rollStrike() {
		bowlingGame.roll(10);
	}

	@Test
	public void perfectGame() throws Exception {
		rollMany(10, 12);

		assertThat(bowlingGame.score(), is(300));
	}
}
