package no.hib.dat102;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class CDarkivKlient {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// Filnavn er "ArkivFil"!!!
		Fil f1 = new Fil();
		Meny meny = null;
		CDarkivADT cda = null;
		String fil = null;
		Scanner in = new Scanner(System.in);
		System.out.println("Hva vil du gjøre?");
		System.out.println("1: Velge et eksisterende arkiv");
		System.out.println("2: Opprette et nytt arkiv");
		int input = Integer.parseInt(in.nextLine());
		switch (input) {
		case (1):
			System.out.println("Skriv inn navn på arkivfil.");
			fil = in.nextLine();

			break;
		case (2):
			System.out.println("Skriv inn navn på nytt arkiv.");
			fil = in.nextLine();
			PrintWriter creator = new PrintWriter(fil, "UTF-8");
			creator.println(0);
			cda = new CDarkiv(5);
			System.out.println("Oppretter Fil: " + fil + ", start programmet på nytt.");
			creator.close();
		}
		cda = f1.lesFraFil(fil);
		meny = new Meny(cda);
		meny.start();
		f1.skrivTilFil(cda, fil, false);

	}
}
