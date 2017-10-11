package no.hib.dat102;

import java.util.Scanner;

public class Meny {
	private Tekstgrensesnitt tgr;
	private CDarkivADT cda;

	public Meny(CDarkivADT cda) {
		tgr = new Tekstgrensesnitt();
		this.cda = cda;

	}

	String input, sokeord;
	Scanner in;
	boolean avsluttet;
	final String linje = "-----------------------------------------------------------------";
	CD tcd;
	int cdnr;

	public void start() {
		
		avsluttet = false;
		in = new Scanner(System.in);
		while (!avsluttet) {
			System.out.println(linje);
			System.out.println("Hva vil du gjøre?" + "\nDette er alternativene:\n"
					+ "#LeggTilCD\t#SlettCD\n#SøkTittel\t#SøkArtist\n#Statistikk\t#Avslutt\n#SkrivAlle");

			input = in.nextLine(); // HVORFOR FUNKER DEN IKKE PÅ RUNDE 2??????
			switch (input) {
			case ("LeggTilCD"):
				tcd = tgr.lesCD();
				cda.leggTilCD(tcd);
				tgr.visCD(tcd);
				System.out.println();
				break;
			case ("SlettCD"):
				/**
				 * Funker ikke som den skal.....
				 */
				System.out.println("Skriv inn CDnr på CD'en du vil slette.");
				cdnr = Integer.parseInt(in.nextLine());
				if (cda.slettCD(cdnr)) {
					System.out.println("CDnr: " + cdnr + " er slettet.\n");
				} else {
					System.out.println("CDnr " + cdnr + " eksisterer ikke i arkivet.\n");
				}

				break;

			case ("SøkTittel"):
				System.out.println("Skriv søkeord:");
				sokeord = in.nextLine();
				tgr.skrivUtCDTittel(cda, sokeord);
				break;
			case ("Statistikk"):
				tgr.skrivUtStatistikk(cda);
				break;
			case ("SøkArtist"):
				System.out.println("Skriv inn søkeord:");
				sokeord = in.nextLine();
				tgr.skrivUtCdArtist(cda, sokeord);
				break;
			case ("Avslutt"):
				avsluttet = true;
				break;
			case ("SkrivAlle"):
				tgr.skrivAlle(cda);
				break;
			default:
				System.out.println("Kjenner ikke igjen komando, prøv igjen.\n");

			}

		}
		System.out.println("Avslutter programmet.");
	}

}
