package basics;

import static basics.MilkShelf.print;

public class PetsVSAnantou {
	public static void main(String[] args) {
		String petNames[] = {"Muddie", "Greyie", "Yellow Point", "Gangblin"};
		String weaponNames[] = {"chocolates", "champagne", "dabians", "eggs", "flowers"};
		int weaponAttacks[] = {-20, 10, 50, 5, 0};
		String bossName = "Nannanmama";
		double bossDodgeRate = 0.2;
		int bossLife = 500;
		int bossWinRound = 30;
		int petAttacks[] = new int[petNames.length];
		int petWeapons[] = new int[petNames.length];
		
		// Pets pick weapons
		for (int i=0; i<petNames.length; i++) {
			petWeapons[i] =  (int) Math.floor(Math.random()*weaponNames.length);
			petAttacks[i] = weaponAttacks[petWeapons[i]];
			print(petNames[i] + " grabs lots of " + weaponNames[petWeapons[i]] + ".");
		}
		
		int roundNumber = 0;
		while (true) {
			print("The pet rebels launch a new round of fierce attack on " + bossName + ".");
			
			for (int i=0; i<petNames.length; i++) {
				if(Math.random() < bossDodgeRate) {
					print(bossName + " dodged " +  petNames[i] + "'s attack!");
					continue;
				}
				double hitRoll = Math.random();
				if(hitRoll < 0.1) {
					int damage = petAttacks[i] * 2;
					bossLife -= damage;
					printPetHitBoss(petNames[i], weaponNames[petWeapons[i]], bossName, "head");
					printBossLoseLife(bossName, damage);
				} else if(hitRoll < 0.4) {
					int damage = petAttacks[i] * 3 / 2;
					bossLife -= damage;
					printPetHitBoss(petNames[i], weaponNames[petWeapons[i]], bossName, "foot");
					printBossLoseLife(bossName, damage);
				} else {
					int damage = petAttacks[i];
					bossLife -= damage;
					printPetHitBoss(petNames[i], weaponNames[petWeapons[i]], bossName, "stomach");
					printBossLoseLife(bossName, damage);
				}
				
			}
			
			print(bossName + " has " + bossLife + " life left.");
			if (bossLife <= 0) {
				print(bossName + " falls down before the pets!");
				break;
			}
			
			roundNumber++;
			if(roundNumber > bossWinRound) {
				print(bossName + " endures " + bossWinRound + " rounds of attack and manages to flee the battle field!");
				break;
			}
			
		}
	}
	
	static void printPetHitBoss(String petName, String weaponName, String bossName, String bossBodyPart){
		print(petName + " hits " + bossName + "'s " + bossBodyPart + " with " + weaponName + ".");
	}
	
	static void printBossLoseLife(String bossName, int damage) {
		if(damage > 0) {
			print(bossName + " feels painful and loses " + damage + " hp.");
		} else if(damage == 0) {
			print(bossName + " feels nothing.");
		} else {
			print(bossName + " feels great and heals " + (-damage) + " hp.");
		}
	}
}
