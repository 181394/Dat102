package oppgave1;

public class B {
	public static void main(String[] args) {
		System.out.print("{");
		for (int i = 0; i < 10; i++) {
			System.out.print(rec(i));
			if (i != 9)
				System.out.print(", ");
		}
		System.out.print("}");
	}

	public static int rec(int n) {
		if (n == 0)
			return 2;
		else if (n == 1)
			return 5;
		else
			return (5 * rec(n - 1)) - (6 * rec(n - 2)) + 2;
	}

}
