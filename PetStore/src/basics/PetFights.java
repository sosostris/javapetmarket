package basics;

import java.util.Scanner;
import static basics.MilkShelf.print;

public class PetFights {
	public static void main(String args[]) {
		String petNames[] = { "Muddie", "Yellow Point", "Greyie", "Gangblin",
				"Anantou", "Ahuitou" };
		int petBaseAttacks[] = { 20, 25, 40, 35, 100, 59 };
		int petBaseLifes[] = { 50, 75, 100, 80, 1000, 599 };
		String weaponNames[] = { "fork", "knife", "spoon", "chopsticks",
				"toilet paper with dabian" };
		int weaponAttacks[] = { 7, 10, 5, 6, 50 };
		String armorNames[] = { "plate", "bowl", "chopping board", "placemat" };
		int armorLifes[] = { 20, 20, 30, 15 };
		while (true) {
			int petIndex1 = selectIndexFromList(petNames,
					"Choose petfighter1 name:");
			int petIndex2 = selectIndexFromList(petNames,
					"Choose petfighter2 name:");
			String petName1 = petNames[petIndex1];
			String petName2 = petNames[petIndex2];
			int armorIndex1 = selectIndexFromList(armorNames,
					"Choose armor for petfighter1:");
			int armorIndex2 = selectIndexFromList(armorNames,
					"Choose armor for petfighter2:");
			int weaponIndex1 = selectIndexFromList(weaponNames,
					"Choose weapon for petfighter1:");
			int weaponIndex2 = selectIndexFromList(weaponNames,
					"Choose weapon for petfighter2:");
			int petBaseLife1 = petBaseLifes[petIndex1];
			int petBaseLife2 = petBaseLifes[petIndex2];
			int armorLife1 = armorLifes[armorIndex1];
			int armorLife2 = armorLifes[armorIndex2];
			int petLife1 = petBaseLife1 + armorLife1;
			int petLife2 = petBaseLife2 + armorLife2;
			int petBaseAttack1 = petBaseAttacks[petIndex1];
			int petBaseAttack2 = petBaseAttacks[petIndex2];
			int weaponAttack1 = weaponAttacks[weaponIndex1];
			int weaponAttack2 = weaponAttacks[weaponIndex2];
			int petAttack1 = petBaseAttack1 + weaponAttack1;
			int petAttack2 = petBaseAttack2 + weaponAttack2;
			int roundNumber = 1;
			print(contructBattleStatus(petName1, weaponNames[weaponIndex1],
					armorNames[armorIndex1])
					+ " VS "
					+ contructBattleStatus(petName2, weaponNames[weaponIndex2],
							armorNames[armorIndex2]));
			while (petLife1 > 0 && petLife2 > 0) {
				if (petLife1 <= (petBaseLife1 + armorLife1) * 0.50) {
					petAttack1 = (int) Math.floor(Math.random()
							* (petBaseLife2 + armorLife2));
				}
				if (petLife2 <= (petBaseLife2 + armorLife2) * 0.50) {
					petAttack2 = (int) Math.floor(Math.random()
							* (petBaseLife1 + armorLife1));
				}
				petLife1 = petLife1 - petAttack2;
				petLife2 = petLife2 - petAttack1;
				print("Round " + roundNumber);
				print(petName1 + " loses " + petAttack2 + " life; " + petLife1
						+ " life left.");
				print(petName2 + " loses " + petAttack1 + " life; " + petLife2
						+ " life left.");
				roundNumber = roundNumber + 1;
			}
			if (petLife1 <= 0 && petLife2 <= 0) {
				print("It's a draw between " + petName1 + " and " + petName2
						+ ".");
			} else if (petLife1 <= 0 && petLife2 >= 0) {
				annouceVictory(petName2);
			} else {
				annouceVictory(petName1);
			}
			String userInputDecision = getUserInputDecision();
			if (userInputDecision.equals("yes")) {
				continue;
			} else {
				break;
			}
		}
	}

	static String getUserInput(String hint) {
		Scanner reader = new Scanner(System.in);
		System.out.println(hint);
		String input = reader.nextLine();
		return input;
	}

	static String getUserInputDecision() {
		return getUserInput("Do you want to play again? Enter yes to continue.");
	}

	static int findIndex(String value, String values[]) {
		for (int i = 0; i < values.length; i++) {
			if (value.equals(values[i])) {
				return i;
			}
		}
		return -1;
	}

	static int selectIndexFromList(String values[], String hint) {
		print(hint);
		for (int i = 0; i < values.length; i++) {
			print((i + 1) + ". " + values[i]);
		}
		print("Choose number:");
		while (true) {
			Scanner reader = new Scanner(System.in);
			int choice = reader.nextInt();
			if (choice < 1 || choice > values.length) {
				print("Invalid choice! Choose again:");
				continue;
			} else {
				return choice - 1;
			}
		}
	}

	static void annouceVictory(String winnerName) {
		print("Victory belongs to " + winnerName + ".");
	}

	static String contructBattleStatus(String petName, String weaponName,
			String armorName) {
		return petName + " equipped with " + weaponName + " & " + armorName;
	}
}