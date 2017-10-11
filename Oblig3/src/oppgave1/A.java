package oppgave1;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Skriv inn et heltall.");
		int i = in.nextInt();
		System.out.println(sum(i));
		in.close();
	}

	public static int sum(int i) {
		if (i == 1)
			return 1;
		else
			return i + sum(i - 1);

	}

}