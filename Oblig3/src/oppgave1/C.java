package oppgave1;

import java.util.Date;

public class C {
	static int teller = 0;

	public static void main(String[] args) {
		Date tits1 = new Date();
		long t1 = tits1.getTime();
		flyttRinger(25, 1, 3, 2);
		Date tits2 = new Date();
		long t2 = tits2.getTime();
		System.out.println(t2 - t1);
		System.out.println(teller);

	}

	private static void flyttRinger(int antRinger, int start, int slutt, int temp) {
		if (antRinger == 1)
			flyttEnRing(start, slutt);
		else {
			flyttRinger(antRinger - 1, start, temp, slutt);
			flyttEnRing(start, slutt);
			flyttRinger(antRinger - 1, temp, slutt, start);
		}
	}

	private static void flyttEnRing(int start, int slutt) {
		// System.out.println("Flytter en ring fra " + start + " til " + slutt);
		teller++;

	}
}
