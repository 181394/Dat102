/**
 * 
 */
package no.hib.dat102;

/**
 * @author Preben
 *
 */
public interface CDarkivADT {
	/**
	 * Returnere en tabell av CD'er
	 */
	CD[] hentCdTabell();

	/**
	 * Legger til en ny CD
	 */
	void leggTilCD(CD nyCD);

	/**
	 * Sletter en CD
	 */
	boolean slettCD(int cdNr);

	/**
	 * S�ker og henter CD'er med en gitt detstreng
	 */
	CD[] sokTittel(String delstreng);

	/**
	 * S�ker og henter artister med en gitt delstreng
	 */
	CD[] sokArtist(String delstreng);

	/**
	 * Henter antall CD'er
	 */
	int hentAntall();

	/**
	 * Henter antall CD'er for en gitt sjanger
	 */
	int hentAntall(Sjanger sjanger);

}
