package no.hib.dat102.adt;

/**
 * 
 * @author Preben
 *
 * @param <T>
 */
public interface KoeADT<T> {
	/**
	 * Legger til et element i k�en.
	 */
	void innKoe(T element);

	/**
	 * Tar ut den fremste i k�en og returnerer den.
	 */
	T utKoe();

	/**
	 * Returnerer f�rste i k�en.
	 */
	T foerste();

	/**
	 * Tester om k�en er tom.
	 */
	boolean erTom();

	/**
	 * Holder styr p� antall i k�en.
	 */
	int antall();

}
