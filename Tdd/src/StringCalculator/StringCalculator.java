package StringCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public int add(String string) throws NoNegativesAllowed {

		int result = 0;

		String newLine = "\n";

		String[] lines = string.split(newLine);
		String delimiter = ",";

		List<Integer> negatives = new ArrayList<Integer>();

		for (String line : lines) {

			if (line.startsWith("//")) {
				delimiter = line.substring(2);
				continue;
			}

			String[] tokens = line.split(delimiter);
			for (String token : tokens) {
				if (!token.isEmpty()) {
					int toAdd = Integer.parseInt(token);
					if (toAdd < 0) {
						negatives.add(toAdd);
					}
					if (toAdd >= 1000) {
						continue;
					}
					result += toAdd;
				}
			}
		}

		if (!negatives.isEmpty()) {
			throw new NoNegativesAllowed(negatives);
		}

		return result;
	}
}
