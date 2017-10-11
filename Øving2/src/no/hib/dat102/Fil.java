/**
 * 
 */
package no.hib.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author Ole Olsen
 * 
 */
public class Fil {

	private static String SKILLE = "#";

	/**
	 * @param filnavn
	 * @return Referansen til CD-arkivet
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws java.io.IOException
	 */
	public CDarkivADT lesFraFil(String filnavn) throws FileNotFoundException, UnsupportedEncodingException {

		CDarkivADT cda = null;

		try {
			// // 1 - FileReader
			FileReader ansFil = new FileReader(filnavn);

			// 2 - BufferedReader
			BufferedReader innfil = new BufferedReader(ansFil);

			// 3 - Leser den første posten som er antall info-poster
			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);

			// Oppretter CDarkiv
			cda = new CDarkiv(n);

			// 4 - Les postene, en hel post om gangen
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int nr = Integer.parseInt(felt[0]);
				String artist = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				Sjanger sjanger = Sjanger.valueOf(felt[4].toUpperCase());

				String plateselskap = felt[5];
				// ...
				CD cd = new CD(nr, artist, tittel, aar, sjanger, plateselskap);

				cda.leggTilCD(cd);
			}

			// 4 - Lukk filen
			innfil.close();

		} catch (FileNotFoundException unntak) {// arver fra IOException må stå
												// først
												// hvis ikke vil unntaket for
												// IOException skygge
			System.out.println("Filnavn: " + filnavn + " eksisterer ikke.");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}

		return cda;
	}

	public void skrivTilFil(CDarkivADT cdarkiv, String filnavn, boolean utvid) {
		try {
			PrintWriter writer = new PrintWriter(filnavn, "UTF-8");
			writer.println(cdarkiv.hentAntall());
			CD[] cdTab = cdarkiv.hentCdTabell();
			for (int i = 0; i < cdarkiv.hentAntall(); i++) {
				writer.println(cdTab[i].toString(5));
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("Noe galt har oppstått.");
		}
	}

}// class
