package basics;

import java.util.Scanner;

public class MilkShelf {
	public static void main(String args[]) {
		String milkBrands[] = { "Guangming", "Shuangxi", "Mengniu", "Yili",
				"Weiquan" };
		String milkTypes[] = { "bottled milk", "yogurt" };
		double[][] price = new double[5][2];
		price[0][0] = 15.50;
		price[0][1] = 4.00;
		price[1][0] = 17.50;
		price[1][1] = 5.00;
		price[2][0] = 14.50;
		price[2][1] = 4.00;
		price[3][0] = 14.00;
		price[3][1] = 4.50;
		price[4][0] = 18.00;
		price[4][1] = 5.50;
		boolean userAnswer = true;
		while (userAnswer) {
			String userInputBrand = getUserInputBrand();
			int brandIndex = findIndex(userInputBrand, milkBrands);
			if (brandIndex == -1) {
				System.out.println("Brand not found! Try again!");
				continue;
			}
			int typeIndex;
			String userInputType;
			do {
				userInputType = getUserInputType();
				typeIndex = findIndex(userInputType, milkTypes);
				if (typeIndex == -1) {
					System.out.println("Type not found! Try again!");
				}
			} while (typeIndex == -1);
			print(userInputBrand + " " + userInputType + " is "
					+ price[brandIndex][typeIndex] + ".");
			String userDecision = getUserDecision();
			if (userDecision.equals("yes")) {
				continue;
			} else {
				break;
			}
		}
	}

	static void print(String line) {
		System.out.println(line);
	}

	static String getUserInputBrand() {
		return getUserInput("Enter brand:");
	}

	static String getUserInputType() {
		return getUserInput("Enter type:");
	}

	static String getUserMembership() {
		return getUserInput("Enter your membership number:");
	}

	static String getUserDecision() {
		return getUserInput("Query again? Enter yes to continue!");
	}

	static String getUserInput(String hint) {
		Scanner reader = new Scanner(System.in);
		System.out.println(hint);
		String input = reader.nextLine();
		return input;
	}

	static int findIndex(String value, String[] values) {
		for (int i = 0; i < values.length; i++) {
			if (value.equals(values[i])) {
				return i;
			}
		}
		return -1;
	}
}
