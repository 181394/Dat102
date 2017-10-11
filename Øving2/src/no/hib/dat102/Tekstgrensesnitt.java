/**
 * 
 */
package no.hib.dat102;

import java.util.Scanner;

/**
 * @author Preben
 *
 */
public class Tekstgrensesnitt {
	// lese opplysningene om en CD fra tastatur
	String cdnr, artist, tittel, sjang, plateselskap;
	int år;
	CD nyCD;
	CD tomCD = new CD();

	public CD lesCD() {
		boolean finnes = false;
		Sjanger sjanger = null;
		Scanner in = new Scanner(System.in);
		System.out.println("Skriv inn CDnummer.");
		cdnr = in.nextLine();
		int cdNummer = Integer.parseInt(cdnr);
		System.out.println("Skriv inn navn på artist/gruppe.");
		artist = in.nextLine();
		System.out.println("Skriv inn tittel på sangen.");
		tittel = in.nextLine();
		System.out.println("Skriv inn produksjonsår for sangen.");
		år = Integer.parseInt(in.nextLine());
		while (!finnes) {
			System.out.println("Hvilken sjanger er sangen?\nAlternativer: ROCK, POP, OPERA, CLASSIC.");
			sjang = in.nextLine().toUpperCase();
			if (sjang.equals(Sjanger.CLASSIC.toString()) || sjang.equals(Sjanger.OPERA.toString())
					|| sjang.equals(Sjanger.POP.toString()) || sjang.equals(Sjanger.ROCK.toString())) {
				sjanger = Sjanger.valueOf(sjang);
				finnes = true;
			} else {
				System.out.println("Ugyldig sjanger, prøv igjen.");
			}
		}
		System.out.println("Hvilket plateselskap har gitt ut sangen?");
		plateselskap = in.nextLine();
		nyCD = new CD(cdNummer, artist, tittel, år, sjanger, plateselskap);
		return nyCD;
	}

	// vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visCD(CD cd) {
		System.out.println(cd.toString());
	}

	// Skrive ut alle CD-er med en spesiell delstreng i tittelen
	public void skrivUtCDTittel(CDarkivADT cda, String sokeord) {
		CD[] titTab = cda.sokTittel(sokeord);
		for (int i = 0; i < titTab.length; i++) {
			System.out.println(titTab[i].toString());
		}
		if (titTab.length == 0) {
			System.out.println("Ingen treff.");
		}
	}

	// Skriver ut alle CD-er av en artist / en gruppe
	public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
		CD[] artTab = cda.sokArtist(delstreng);
		for (int i = 0; i < artTab.length; i++) {
			System.out.println(artTab[i].toString());
		}
		if (artTab.length == 0) {
			System.out.println("Ingen treff.");
		}
	}

	// Skrive ut en enkel statistikk som inneholder antall CD-er totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(CDarkivADT cda) {
		System.out.println("Antall CD'er i arkivet: " + cda.hentAntall());
		for (Sjanger sj : Sjanger.values()) {
			System.out.println(sj + ": " + cda.hentAntall(sj));
		}
	}

	public void skrivAlle(CDarkivADT cda) {
		System.out.println("Antall: " + cda.hentAntall());
		CD[] cdTab = cda.hentCdTabell();
		for (int i = 0; i < cda.hentAntall(); i++) {
			System.out.println(cdTab[i].toString());
		}
	}
}// class
