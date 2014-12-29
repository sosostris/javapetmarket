package basics;

public class Fruits {
	public static void main(String args[]) {
		char a = 'a';
		String fruitNamesSingular[] = { "ananas", "banan", "jordgubbe" };
		String fruitNamesPlural[] = { "ananas", "bananer", "jordgubbar" };
		boolean startWithVowel[] = { true, false, false };
		int fruitQuantity[] = { 2, 1, 20 };
		fruitQuantity[0] = 1;
		for (int i = 0; i < fruitQuantity.length; i++) {
			if (fruitQuantity[i] == 0) {
				print("There is no " + fruitNamesSingular[i]);
			} else if (fruitQuantity[i] == 1) {
				if (startWithVowel[i]) {
					print("There is an " + fruitNamesSingular[i]);
				} else {
					print("There is a " + fruitNamesSingular[i]);
				}
			} else {
				print("There are " + fruitQuantity[i] + " "
						+ fruitNamesPlural[i]);
			}
			switch (fruitQuantity[i]) {
			case 0:
				print("There is no " + fruitNamesSingular[i]);
				break;
			case 1:
				if (startWithVowel[i]) {
					print("There is an " + fruitNamesSingular[i]);
				} else {
					print("There is a " + fruitNamesSingular[i]);
				}
				break;
			default:
				print("There are " + generateRange(0, i + 1)[i] + " "
						+ fruitNamesPlural[i]);
			}
		}
		String vegetables[] = new String[20];
		vegetables[0] = "cucumber";
		for (int number : generateRange(1, 50)) {
			print("" + number);
		}
	}

	static void print(String line) {
		System.out.println("zhenhua-xu " + line);
	}

	static int addOne(int number) {
		return number + 1;
	}

	// Given two ints, return all ints between them
	static int[] generateRange(int lowerBound, int upperBound) {
		int a[] = new int[upperBound - lowerBound + 1];
		for (int i = 0; i < a.length; i++) {
			a[i] = lowerBound + i;
		}
		return a;
	}
}
