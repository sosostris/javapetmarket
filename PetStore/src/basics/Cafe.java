package basics;

import static basics.MilkShelf.print;

public class Cafe {
	public static void main(String[] args) {
		String coffeeTypes[] = {"latte", "cappuccino", "macchiato", "Irish coffee", "American coffee", "xiaobian"};
		String cakeTypes[] = {"carrot cake", "cheese cake", "kladdkaka", "brownie", "swiss roll", "tiramisu", "dabian"};
		int coffeePrices[] = {35, 38, 28, 42, 22, 10};
		int cakePrices[] = {38, 32, 32, 30, 33, 38, 20};
		String customerNames[] = {"Muddie", "Yellow Point", "Greyie", "Gangblin", "Ahuitou", "Anantou"};
		String customerCoffees[] = new String[customerNames.length];
		String customerCakes[] = new String[customerNames.length];
		int customerCoffeePickIndexes[] = new int[customerNames.length];
		int customerCakePickIndexes[] = new int[customerNames.length];
		int customerPays[] = new int[customerNames.length];
		String cafeName = "Anantou's Cafe";
		int customerPayTotal = 0;
		boolean drinkXiaobian[] = new boolean[customerNames.length];
		boolean eatDabian[]= new boolean[customerNames.length];
		boolean isMale[] = {false, false, true, true, true, false};
		
		for (int i=0; i<customerNames.length; i++) {
			customerCoffeePickIndexes[i] =  (int) Math.floor(Math.random()*coffeeTypes.length);
			customerCakePickIndexes[i] =  (int) Math.floor(Math.random()*cakeTypes.length);
			customerPays[i] = coffeePrices[customerCoffeePickIndexes[i]] + cakePrices[customerCakePickIndexes[i]];
			customerPayTotal = customerPayTotal + customerPays[i];
			if (customerCoffeePickIndexes[i] == 5) {
				drinkXiaobian[i] = true;
			} else {
				drinkXiaobian[i] = false;
			}
			if (customerCakePickIndexes[i] == 6) {
				eatDabian[i] = true;
			} else {
				eatDabian[i] = false;
			}
			print(customerNames[i] + " orders a cup of " + coffeeTypes[customerCoffeePickIndexes[i]] + ", a piece of " + cakeTypes[customerCakePickIndexes[i]] + " and pays " + customerPays[i] + "kr.");
		}
		
		String xiaobianDrinkers = "";
		String dabianEaters = "";
		int xiaobianDrinkerNumber = 0;
		int dabianEaterNumber = 0;
		
		for (int i=0; i<customerNames.length; i++) {
			if (drinkXiaobian[i]) {
				xiaobianDrinkerNumber = xiaobianDrinkerNumber + 1;
			}
			if (eatDabian[i]) {
				dabianEaterNumber = dabianEaterNumber + 1;
			}
		}
		
		if (dabianEaterNumber == 1) {
			for (int i=0; i<customerNames.length; i++) {
				if (eatDabian[i]) {
					dabianEaters = customerNames[i];
				}
			}
		}
		
		int countXiaobianDrinkers = 0;
		for (int i=0; i<customerNames.length && countXiaobianDrinkers < xiaobianDrinkerNumber; i++) {
			if (drinkXiaobian[i]) {
				countXiaobianDrinkers++;
				if(countXiaobianDrinkers == 1) {
					xiaobianDrinkers = customerNames[i];
				} else if(countXiaobianDrinkers == xiaobianDrinkerNumber) {
					xiaobianDrinkers = xiaobianDrinkers + " and " + customerNames[i]; 
				} else {
					xiaobianDrinkers = xiaobianDrinkers + ", " + customerNames[i]; 
				}
			}
		}
		
		int countDabianEaters = 0;
		for (int i=0; i<customerNames.length && countDabianEaters < dabianEaterNumber; i++) {
			if (eatDabian[i]) {
				countDabianEaters++;
				if(countDabianEaters == 1) {
					dabianEaters = customerNames[i];
				} else if(countDabianEaters == dabianEaterNumber) {
					dabianEaters = dabianEaters + " and " + customerNames[i]; 
				} else {
					dabianEaters = dabianEaters + ", " + customerNames[i]; 
				}
			}
		}
		
		if (xiaobianDrinkerNumber > 1) {
			print("People in the cafe stare at " + xiaobianDrinkers + " with astonishment as they take a sip of xiaobian.");
		} else if (xiaobianDrinkerNumber == 1) {
			for (int i=0; i<customerNames.length; i++) {
				if (drinkXiaobian[i] && isMale[i]) {
					print("People in the cafe stare at " + xiaobianDrinkers + " with astonishment as he takes a sip of xiaobian.");
					break;
				} else if (drinkXiaobian[i] && isMale[i]==false) {
					print("People in the cafe stare at " + xiaobianDrinkers + " with astonishment as she takes a sip of xiaobian.");
					break;
				}
			}
		}
		if (dabianEaterNumber > 1) {
			print("People in the cafe gape at " + dabianEaters + " as they start to eat dabian.");
		} else if (dabianEaterNumber == 1) {
			for (int i=0; i<customerNames.length; i++) {
				if (eatDabian[i] && isMale[i]) {
					print("People in the cafe gape at " + dabianEaters + " as he starts to eat dabian.");
					break;
				} else if (eatDabian[i] && isMale[i]==false) {
					print("People in the cafe gape at " + dabianEaters + " as she starts to eat dabian.");
					break;
				}
			}
		}
		
		print(cafeName + " earns " + customerPayTotal + "kr in total.");
	}
}
