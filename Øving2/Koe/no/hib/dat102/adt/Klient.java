package no.hib.dat102.adt;

public class Klient {
	public static void main(String args[]) {
		SirkulaerKoe koe = new SirkulaerKoe(9);
		String p = "Ole J�nni";
		System.out.println("Streng inn er: " + p);
		for (int i = 0; i < p.length(); i++) {
			koe.innKoe(p.charAt(i));
		}
		System.out.println("F�rst i k�en er: " + koe.foerste());
		System.out.print("Streng ut er: ");
		for (int j = 0; j < p.length(); j++) {
			System.out.print(koe.utKoe());
		}
	}
}