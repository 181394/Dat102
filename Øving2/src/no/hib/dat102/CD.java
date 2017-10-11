/**
 * 
 */
package no.hib.dat102;

/**
 * @author Preben
 *
 */
public class CD {
	private int cdNummer, Âr;
	private String artist, tittel, plateselskap;
	private Sjanger sjanger;

	public CD() {
		this.cdNummer = 0;
		this.Âr = 0000;
		this.artist = "";
		this.tittel = "";
		this.plateselskap = "";
		this.sjanger = null;
	}

	public CD(int cdNummer, String artist, String tittel, int Âr, Sjanger sjanger, String plateselskap) {
		this.cdNummer = cdNummer;
		this.Âr = Âr;
		this.artist = artist;
		this.tittel = tittel;
		this.plateselskap = plateselskap;
		this.sjanger = sjanger;
	}

	public int getCdNummer() {
		return cdNummer;
	}

	public void setCdNummer(int cdNummer) {
		this.cdNummer = cdNummer;
	}

	public int get≈r() {
		return Âr;
	}

	public void set≈r(int Âr) {
		this.Âr = Âr;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public String getPlateselskap() {
		return plateselskap;
	}

	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String toString() {
		return getCdNummer() + "\t" + getArtist() + "\t" + getTittel() + "\t" + get≈r() + "\t" + getSjanger() + "\t" + getPlateselskap();

	}

	public String toString(int i) {
		return cdNummer + "#" + artist + "#" + tittel + "#" + Âr + "#" + sjanger + "#" + plateselskap;
	}
}
