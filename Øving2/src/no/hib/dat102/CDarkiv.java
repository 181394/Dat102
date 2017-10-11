/**
 * 
 */
package no.hib.dat102;

/**
 * @author Preben
 *
 */
public class CDarkiv implements CDarkivADT {
	private CD[] cdTabell;
	private int antall;
	private int maksAntall;

	public CDarkiv(int maksAntall) {
		this.maksAntall = maksAntall;
		cdTabell = new CD[maksAntall];
	}

	@Override
	public CD[] hentCdTabell() {
		return cdTabell;
	}

	@Override
	public void leggTilCD(CD nyCD) {
		if (antall == maksAntall) {
			utvidtabellen();
		}
		if (antall < maksAntall) {
			cdTabell[antall] = nyCD;
			antall++;
		}
	}

	@Override
	public boolean slettCD(int cdNr) {
		boolean slettet = false;
		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getCdNummer() == cdNr) {
				cdTabell[i] = cdTabell[antall - 1];
				slettet = true;
				antall--;
				System.out.println();
				return slettet;
			}
		}
		return slettet;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		CD[] tittelTab;
		int teller = 0;
		delstreng = delstreng.toLowerCase();

		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getTittel().indexOf(delstreng) >= 0) {
				teller++;
			}
		}
		tittelTab = new CD[teller];
		int teller2 = 0;
		for (int i = 0; i < cdTabell.length; i++) {
			if (cdTabell[i].getTittel().indexOf(delstreng) >= 0) {
				tittelTab[teller2] = cdTabell[i];
				teller2++;
			}
		}
		return tittelTab;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		CD[] artistTab;
		int teller = 0;
		delstreng = delstreng.toLowerCase();

		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getArtist().toLowerCase().indexOf(delstreng) >= 0) {
				teller++;
			}
		}
		artistTab = new CD[teller];
		int teller2 = 0;
		for (int i = 0; i < cdTabell.length; i++) {
			if (cdTabell[i].getArtist().toLowerCase().indexOf(delstreng) >= 0) {
				artistTab[teller2] = cdTabell[i];
				teller2++;
			}
		}
		return artistTab;
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		int teller = 0;
		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getSjanger() == sjanger) {
				teller++;
			}
		}
		return teller;
	}

	/**
	 * Utvider CDarkivet med 10%
	 */
	private void utvidtabellen() {
		CD[] hjelpeTab;
		if (cdTabell.length == 0) {
			hjelpeTab = new CD[1];
			maksAntall = 1;
		} else {
			hjelpeTab = new CD[(int) Math.ceil(cdTabell.length * 1.1)];
			maksAntall = hjelpeTab.length;
		}
		for (int i = 0; i < cdTabell.length; i++) {
			hjelpeTab[i] = cdTabell[i];
		}
		cdTabell = hjelpeTab;
	}

	/**
	 * Setter antall CD'er
	 * 
	 * @param n
	 * @return n
	 */
	public int setAntall(int n) {
		return n;
	}

}
