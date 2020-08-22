import java.util.Arrays;

public class HerbGarden {

	public static void main(String[] args) {

// 		all inputs are correct
		int[] plants1 = { 2, 7, 5, 3 };
		int days1 = 3;
		herbGarden(plants1, days1);

//		int days1 = 6;
//		int[] plants1 = { 7, 10, 2, 4, 6, 9, 5, 3 };
//		printHarvest(plants1, days1);

		// number of days is under the limit
//		int days2 = 0;
//		int[] plants2 = { 7, 10, 2, 4, 6, 9, 5, 3 };
//		printHarvest(plants2, days2);

		// number of days is over the limit
//		int days3 = 101;
//		int[] plants3 = { 7, 10, 2, 4, 6, 9, 5, 3 };
//		printHarvest(plants3, days3);

		// one of the values in the array is under the limit
//		int days4 = 6;
//		int[] plants4 = { 7, 0, 2, 4, 6, 9, 5, 3 };
//		printHarvest(plants4, days4);

		// one of the values in the array is over the limit
//		int days5 = 6;
//		int[] plants5 = { 7, 11, 2, 4, 6, 9, 5, 3 };
//		printHarvest(plants5, days5);

		// array length is out of allowed interval
//		int days6 = 6;
//		int[] plants6 = new int[10001];
//		printHarvest(plants6, days6);

		// all inputs are correct, but there is no harvested leaves
//		int days7 = 1;
//		int[] plants7 = { 1, 1, 1, 1, 1, 1, 1, 1 };
//		printHarvest(plants7, days7);
	}

	static void herbGarden(int[] plants, int days) {

		isInputAllowed(plants, days);

		// sorting array. max value is the last one.
		Arrays.sort(plants);

		int output = countHarvest(plants, days);

		System.out.println("Total harvested leaves is: " + output);

	}

	static void isInputAllowed(int[] plants, int days) {

		// Invalid number of days
		if (days < 1 || days > 100)
			throw new IllegalArgumentException("Illegal value. Allowed interval is [1, 100].");

		// Invalid plants' count
		if (plants.length < 0 || plants.length > Math.pow(10, 4))
			throw new IllegalArgumentException("Illegal plants' length. Allowed interval is [0, 10^4].");

		// Invalid plant's leaves value
		for (int i = 0; i < plants.length; i++) {
			int tempPlant = plants[i];
			if (tempPlant < 1 || tempPlant > 10)
				throw new IllegalArgumentException(
						"Illegal value. Number of leaves should be in the interval [1, 10].");
		}
	}

	// method for counting total harvest
	static int countHarvest(int[] input, int days) {
		int harvestCount = 0;
		for (int i = 0; i < days; i++) {
//			printArray(input);

			harvestCount += input[input.length - 1] / 2;
//			System.out.println(harvestCount);

			makeArrayWithNewValues(input);
//			printArray(input);

			sortArrayWithNewValues(input);
//			printArray(input);
//			System.out.println("-------------------------");
		}
		return harvestCount;
	}

	// make the array of leaves' for the next day
	static int[] makeArrayWithNewValues(int[] input) {
		int x = input.length;
		for (int i = 0; i < x - 1; i++) {
			input[i] = input[i] + 2;
		}
		if (input[x - 1] % 2 == 0)
			input[x - 1] = input[x - 1] / 2 + 2;
		else
			input[x - 1] = input[x - 1] / 2 + 3;

		return input;
	}

	// sorting array with new values
	static int[] sortArrayWithNewValues(int[] input) {
		int pom;
		for (int i = input.length - 1; i > 0; i--) {
			if (input[i] < input[i - 1]) {
				pom = input[i];
				input[i] = input[i - 1];
				input[i - 1] = pom;
			} else
				break;
		}
		return input;
	}

	// method for printing array
	static void printArray(int[] array) {
		String output = Arrays.toString(array);
		System.out.println(output);
	}
}
