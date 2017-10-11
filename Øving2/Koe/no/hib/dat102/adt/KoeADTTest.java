package no.hib.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class KoeADTTest {

	/**
	 * Størelse på køen som testes.
	 */
	protected static final int SIZE = 6;
	/**
	 * køen
	 */
	private KoeADT<String> koe;

	private String c1 = "a";
	private String c2 = "b";
	private String c3 = "c";
	private String c4 = "d";

	/**
	 * Lager ny kø for hver test
	 */
	@Before
	public final void setup() {
		koe = new SirkulaerKoe<String>(SIZE);
	}

	/**
	 * Tester om ny kø er tom
	 */
	@Test
	public void testErTom() {
		assertTrue(koe.erTom());
	}

	@Test
	public void testErIkkeTom() {
		koe.innKoe(c1);
		assertFalse(koe.erTom());
	}

	@Test
	public void testInnKoeUtKoe() {
		koe.innKoe(c1);
		koe.innKoe(c2);
		koe.innKoe(c3);
		koe.innKoe(c4);
		try {
			assertEquals(c1, koe.utKoe());
			assertEquals(c2, koe.utKoe());
			assertEquals(c3, koe.utKoe());
			assertEquals(c4, koe.utKoe());

		} catch (EmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}

	@Test
	public void testUtvidKoe() {
		koe.innKoe(c1);
		for (int i = 0; i < SIZE; i++) {
			koe.innKoe(c2);
		}
		koe.innKoe(c3);
		try {
			assertEquals(SIZE + 2, koe.antall());
			assertEquals(c1, koe.utKoe());
			assertEquals(c2, koe.foerste());
			for (int i = 0; i < SIZE; i++) {
				koe.utKoe();
			}
			assertEquals(c3, koe.utKoe());
			assertTrue(koe.erTom());
		} catch (EmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}

	@Test
	public void testFoerste() {
		try {
			assertEquals(null, koe.foerste());
			koe.innKoe(c1);
			assertEquals(c1, koe.foerste());
			koe.innKoe(c2);
			assertEquals(c1, koe.foerste());
			koe.utKoe();
			assertEquals(c2, koe.foerste());
		} catch (EmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}

	@Test
	public void testAntall() {
		try {
			assertTrue(koe.antall() == 0);
			koe.innKoe(c1);
			assertTrue(koe.antall() == 1);
			koe.innKoe(c2);
			assertTrue(koe.antall() == 2);
			koe.utKoe();
			assertTrue(koe.antall() == 1);
		} catch (EmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Tester på å fjerne fra tom kø
	 * 
	 * @throws EmptyCollectionException
	 *             expected exception
	 */
	@Test(expected = AssertionError.class)
	public final void utKoeFraTomKoe() {
		try {
			koe.utKoe();
		} catch (EmptyCollectionException e) {
			fail("pop failed unexpectedly " + e.getMessage());
		}
	}

}
