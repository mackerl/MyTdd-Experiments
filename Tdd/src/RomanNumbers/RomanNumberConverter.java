package RomanNumbers;

import java.util.TreeMap;

public class RomanNumberConverter {

	TreeMap<Integer, String> conversionMap = new TreeMap<Integer, String>();
	private StringBuilder romanNumber = new StringBuilder();

	int arabicRest = 0;

	RomanNumberConverter() {
		fillConversionMap();
	}

	private void fillConversionMap() {
		romanNumber.setLength(0);

		conversionMap.put(1, "I");
		conversionMap.put(5, "V");
		conversionMap.put(10, "X");
		conversionMap.put(50, "L");
		conversionMap.put(100, "C");
		conversionMap.put(500, "D");
		conversionMap.put(1000, "M");
	}

	public String convert(int arabic) {
		fillConversionMap();

		arabicRest = arabic;

		while (arabicRest > 0) {

			int maximumNumber = conversionMap.lastKey();
			String maxRoman = conversionMap.get(maximumNumber);

			reduceArabic(maximumNumber, maxRoman);

			if (conversionMap.size() > 1) {
				int secondMaxNum = conversionMap.lowerKey(maximumNumber);
				int diffNum = maximumNumber - secondMaxNum;

				if (diffNum == secondMaxNum) {
					secondMaxNum = conversionMap.lowerKey(secondMaxNum);
					diffNum = maximumNumber - secondMaxNum;
				}

				String secondMaxRoman = conversionMap.get(secondMaxNum);

				String diffRoman = secondMaxRoman + maxRoman;

				reduceArabic(diffNum, diffRoman);
			}

			conversionMap.remove(maximumNumber);

		}
		return romanNumber.toString();
	}

	private void reduceArabic(int toReduce, String romanEquivalent) {
		while (arabicRest >= toReduce) {
			arabicRest -= toReduce;
			romanNumber.append(romanEquivalent);
		}
	}
}
