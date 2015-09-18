package StringCalculator;

import java.util.List;

public class NoNegativesAllowed extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoNegativesAllowed(List<Integer> negatives) {
		super("No negatives Allowed: " + negatives);
	}

}
