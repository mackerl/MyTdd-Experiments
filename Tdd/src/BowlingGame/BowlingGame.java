package BowlingGame;

public class BowlingGame {

	private int pins[] = new int[21];
	private int counter = 0;

	public void roll(int pinsRolled) {
		pins[counter++] = pinsRolled;
	}

	public int score() {
		int score = 0;
		int rollCounter = 0;
		for (int frame = 0; frame < 10; frame++) {

			if (isStrike(rollCounter)) {
				score += 10 + nextTwoBallsForStrike(rollCounter);
				rollCounter++;
			} else if (isSpare(rollCounter)) {
				score += 10 + nextBallForSpare(rollCounter);
				rollCounter += 2;
			} else {
				score += twoBallsInFrame(rollCounter);
				rollCounter += 2;
			}
		}
		return score;
	}

	private int nextTwoBallsForStrike(int rollCounter) {
		return pins[rollCounter + 1] + pins[rollCounter + 2];
	}

	private int nextBallForSpare(int rollCounter) {
		return pins[rollCounter + 2];
	}

	private int twoBallsInFrame(int rollCounter) {
		return pins[rollCounter] + pins[rollCounter + 1];
	}

	private boolean isStrike(int rollCounter) {
		return pins[rollCounter] == 10;
	}

	private boolean isSpare(int rollCounter) {
		return twoBallsInFrame(rollCounter) == 10;
	}
}
