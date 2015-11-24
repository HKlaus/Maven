package de.tom;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple Halbjahr
 */
public class UtilTest {

	@Test
	public void testFebruar() {
		final int eingabe = 2;
		final boolean sollWert = true;
		assertEquals(sollWert, Util.istErstesHalbjahr(eingabe));
	}

	@Test
	public void testMaerz() {
		final int eingabe = 3;
		final boolean sollWert = true;
		assertEquals(sollWert, Util.istErstesHalbjahr(eingabe));
	}

	@Test
	public void testJuli() {
		final int eingabe = 7;
		final boolean sollWert = true;
		assertEquals(sollWert, Util.istErstesHalbjahr(eingabe));
	}

	@Test
	public void testDezember() {
		final int eingabe = 12;
		final boolean sollWert = false;
		assertEquals(sollWert, Util.istErstesHalbjahr(eingabe));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNull(){
		final int eingabe = 0;
		final boolean sollWert = false;
		assertEquals(sollWert, Util.istErstesHalbjahr(eingabe));
	}
}
