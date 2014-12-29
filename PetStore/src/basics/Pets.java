package basics;

public class Pets {
	public static void main(String args[]) {
		String petNames[] = { "Muddie", "Grayie", "Yellow Point", "Gangblin" };
		int petAges[] = { 6, 8, 4, 987 };
		double petHeights[] = { 0.05, 0.1, 0.2, 0.35 };
		boolean petIsMale[] = { false, true, false, true };
		String petVoices[] = { "zizizi", "voooovoooo", "jujuju", "ho ho ho" };
		for (int i = 0; i < 4; i++) {
			print(petNames[i] + " is " + petAges[i] + " years old.");
			print(petNames[i] + " is " + petHeights[i] + " high.");
			if (petIsMale[i]) {
				print(petNames[i] + " is " + "a boy.");
			} else {
				print(petNames[i] + " is " + "a girl.");
			}
			print(petNames[i] + " greets you with " + petVoices[i] + ".");
		}
	}

	static void print(String line) {
		System.out.println(line);
	}
}