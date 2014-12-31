package basics;

import static basics.MilkShelf.print;

public class PetLottery {
	public static void main(String[] args) {
		String petNames[] = {"Muddie", "Greyie", "Yellow Point", "Gangblin", "Anantou", "Ahuitou"};
		boolean outOfGame[] = new boolean[6];
		for (int i=0; i<outOfGame.length; i++) {
			outOfGame[i] = false;
		}
		int petRolls[] = new int[6];
		
		//Each iteration in the loop is one round of rolls by each pet
		while (true) {
			//Each pet gets a roll
			for (int i=0; i<6; i++) {
				if (outOfGame[i]) {
					continue;	
				}
				petRolls[i] = 1 + ((int) Math.floor(Math.random()*6));
				print(petNames[i] + " rolls " + petRolls[i] + ".");
			}
			
			//Find the index of the first pet still in game
			int petIndex=-1;
			for(int i=0; i<6; i++) {
			    if(!outOfGame[i]) {
			    	petIndex = i;
			    	break;
			    }	
			}
			
			//Find the index of the in-game pet with lowest roll
			for (int i=0; i<6; i++) {
				if (outOfGame[i]) {
					continue;
				}
				if (petRolls[petIndex] > petRolls[i]) {
					petIndex = i;
				}	
			}
			
			//Check whether there exist pets with same lowest roll value;
			boolean sameRoll = false;
			for (int i=0; i<petNames.length; i++) {
				//Rule out conditions when pet with lowest roll is compared with itself and those out of game
				if (petIndex != i && petRolls[petIndex] == petRolls[i] && !outOfGame[i]) {
					print("It's tie. The pets are going to roll again.");
					sameRoll = true;
					break;
				}
			}
			//Jump to the next iteration/round when it's tie
			if (sameRoll) {
				continue;
			}
			
			//Kick that pet out of game
			outOfGame[petIndex] = true;
			print(petNames[petIndex] + " is out of game!");
				
			//Count number of pets still in game
			int playerNumber = petNames.length;
			for (int i=0; i<petNames.length; i++) {
				if (outOfGame[i]) {
					playerNumber = playerNumber - 1;
				}
			}
			
			//Kick off a new round if there are more than 1 pet in game
			boolean newRound = false;
			if (playerNumber > 1) {
				newRound = true;	
			}
			
			if (newRound) {
				continue;
			} else {
				//Find the winner
				for (int i=0; i<6; i++) {
					if (!outOfGame[i]) {
						print(petNames[i] + " is the winner!");
					}
				}
				break;
			}
		}	
	}
}

//Programming is hell! Laopopo is big bian!
