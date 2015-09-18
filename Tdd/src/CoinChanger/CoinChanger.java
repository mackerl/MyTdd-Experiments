package CoinChanger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CoinChanger {
	LinkedList<Integer> availableCoins = new LinkedList<Integer>();

	void setAvailableCoins(Integer... coins) {
		availableCoins.clear();
		availableCoins.addAll(Arrays.asList(coins));
		Collections.sort(availableCoins, newAscIntComparator());
	}

	public List<Integer> change(int amount) {

		List<Integer> exchange = null;
		while (!availableCoins.isEmpty()) {
			List<Integer> proposedExchange = proposeSolution(amount);

			if (exchange == null)
				exchange = proposedExchange;

			if (proposedExchange.size() < exchange.size()) {
				exchange = proposedExchange;
			}
			availableCoins.removeLast();
		}

		return exchange;
	}

	private List<Integer> proposeSolution(int amount) {
		LinkedList<Integer> availableCoins = new LinkedList<>();
		availableCoins.addAll(this.availableCoins);

		List<Integer> proposedExchange = new ArrayList<Integer>();
		while (!availableCoins.isEmpty()) {
			int availableCoin = availableCoins.removeLast();
			while (amount >= availableCoin) {
				proposedExchange.add(availableCoin);
				amount -= availableCoin;
			}
		}
		return proposedExchange;
	}

	protected static Comparator<Integer> newAscIntComparator() {
		return new Comparator<Integer>() {
			@Override
			public int compare(Integer first, Integer second) {
				return Integer.valueOf(first)
						.compareTo(Integer.valueOf(second));
			}
		};
	}
}
