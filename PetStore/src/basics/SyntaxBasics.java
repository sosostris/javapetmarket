package basics;

public class SyntaxBasics {
	public static void main(String args[]) {
		int a = 9;
		if (a > 10) {
			// System.out.println("Laopopo shi da bian!");
		} else {
			// System.out.println("Laopopo bu shi da bian!");
		}
		for (a = 1; a < 10; a = a + 1) {
			if (a == 5) {
				break;
			}
			System.out.println("Laopopo shi da bian!" + a);
		}
		a = 10;
		while (a < 10) {
			System.out.println("Laopopo shi da bian!" + a);
			a++;
		}
		a = 16;
		do {
			System.out.println("Laopopo shi da bian!" + a);
			a++;
		} while (a < 15);
		System.out.println("Laopopo shi da bian!" + a);
	}
}
