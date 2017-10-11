package no.hib.dat102.adt;

/**
 * 
 * @author Preben
 *
 * @param <T>
 */
public interface KoeADT<T> {
	/**
	 * Legger til et element i køen.
	 */
	void innKoe(T element);

	/**
	 * Tar ut den fremste i køen og returnerer den.
	 */
	T utKoe();

	/**
	 * Returnerer første i køen.
	 */
	T foerste();

	/**
	 * Tester om køen er tom.
	 */
	boolean erTom();

	/**
	 * Holder styr på antall i køen.
	 */
	int antall();

}
