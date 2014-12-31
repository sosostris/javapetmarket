package basics;

import static basics.MilkShelf.print;

public class PetsVSAhuitou {
	public static void main(String[] args) {
		String petNames[] = {"Muddie", "Greyie", "Yellow Point", "Gangblin"};
		String weaponNames[] = {"chocolates", "champagne", "dabians", "eggs", "flowers"};
		int weaponAttacks[] = {-20, 10, 50, 5, 0};
		String bossName = "Huahuababa";
		int bossLife = 1000;
		int petAttacks[] = new int[petNames.length];
		int weaponIndex[] = new int[petNames.length];
		
		// Pets pick weapons
		for (int i=0; i<petNames.length; i++) {
			weaponIndex[i] =  (int) Math.floor(Math.random()*weaponNames.length);
			petAttacks[i] = weaponAttacks[weaponIndex[i]];
			print(petNames[i] + " grabs lots of " + weaponNames[weaponIndex[i]] + ".");
		}
		
		// Calculate one round of total damage of pet attacks
		int petAttackTotal = 0;
		for (int i=0; i<petNames.length; i++) {
			petAttackTotal = petAttackTotal + petAttacks[i];
		}
		
		print("The pet rebels launch a fierce attack on " + bossName + ".");
		
		while (true) {
			bossLife = bossLife - petAttackTotal;
			print("The pets deal " + petAttackTotal + " damage to " + bossName + ".");
			print(bossName + " has " + bossLife + " life left.");
			if (bossLife <= 0) {
				print(bossName + " falls down before the pets!");
				break;
			} else if (bossLife > 5000) {
				print(bossName + " is getting even stronger and suppressed the pet rebels.");
				break;
			}
			
		}
		
		
	}
}
