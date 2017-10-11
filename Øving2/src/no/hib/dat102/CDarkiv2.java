package no.hib.dat102;

public class CDarkiv2 implements CDarkivADT {
	private LinearNode<CD> start;
	private int antall;

	public CDarkiv2() {
		start = null;
		antall = 0;
	}

	@Override
	public CD[] hentCdTabell() {
		return null;
	}

	@Override
	public void leggTilCD(CD nyCD) {
		if (antall == 0) {
		} else {

		}

	}

	@Override
	public boolean slettCD(int cdNr) {
		return false;

	}

	@Override
	public CD[] sokTittel(String delstreng) {
		return null;

	}

	@Override
	public CD[] sokArtist(String delstreng) {
		return null;
	}

	@Override
	public int hentAntall() {
		return 0;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		return 0;
	}

	public LinearNode<CD> getStart() {
		return start;
	}

	public void setStart(LinearNode<CD> start) {
		this.start = start;
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

}
