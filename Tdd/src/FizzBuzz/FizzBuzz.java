package FizzBuzz;

public class FizzBuzz {

	String numbers[] = new String[100];

	public String[] print() {
		for (int i = 0; i < 100; i++) {
			numbers[i] = Integer.toString(i + 1);
			if (isFizz(i)) {
				numbers[i] = "fizz";
			}
			if (isBuzz(i)) {
				numbers[i] = "buzz";
			}
			if (isFizz(i) && isBuzz(i)) {
				numbers[i] = "fizzbuzz";
			}
		}
		return numbers;
	}

	private boolean isBuzz(int i) {
		return i % 5 == 0;
	}

	private boolean isFizz(int i) {
		return i % 3 == 0;
	}
}
