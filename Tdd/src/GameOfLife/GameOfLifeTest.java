package GameOfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 1. Any live cell with fewer than two live neighbours dies, as if caused by
 * underpopulation. 2. Any live cell with more than three live neighbours dies,
 * as if by overcrowding. 3. Any live cell with two or three live neighbours
 * lives on to the next generation. 4. Any dead cell with exactly three live
 * neighbours becomes a live cell.
 * 
 * @author mackerl
 *
 */

public class GameOfLifeTest {

	private GameOfLife gameOfLife;

	@Before
	public void instantiateGameOfLife() {
		gameOfLife = new GameOfLife();
	}

	@Test
	public void testOneLiveCellDies() {
		gameOfLife.seedCells(1);
		gameOfLife.iterate();
		Assert.assertEquals(gameOfLife.numberOfLiveCells(), 0);
	}

	@Test
	public void testTwoLiveCellDies() {
		gameOfLife.seedCells(2);
		gameOfLife.iterate();
		Assert.assertEquals(gameOfLife.numberOfLiveCells(), 0);
	}
	
	@Test
	public void testThree

}
