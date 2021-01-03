package assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//JUnit file for testing Monom class methods
class JUnitMonom {

	//testing isZero method
	@Test
	void testIsZero() {
		Monom m1 = new Monom(0,0);
		assertEquals(true, m1.isZero());
	}

	//testing equals method
	@Test
	void testEquals() {
		Monom m1 = new Monom(-5,2);
		Monom m2 = new Monom("-5x^2");
		assertEquals(true, m1.equals(m2));
	}

	//testing add method
	@Test
	void testAdd() {
		Monom m1 = new Monom(-5,2);
		Monom m2 = new Monom(2,2);
		Monom m3 = new Monom(-3,2);
		m1.add(m2);
		assertEquals(m3.getCoeff(), m1.getCoeff());
		assertEquals(m3.getPower(), m1.getPower());
	}

	//testing multiply method
	@Test
	void testMultiply() {
		Monom m1 = new Monom(5,2);
		Monom m2 = new Monom(5,2);
		Monom m3 = new Monom(25,4);
		m1.multiply(m2);
		assertEquals(m3.getCoeff(), m1.getCoeff());
		assertEquals(m3.getPower(), m1.getPower());
	}

	//testing multiple method
	@Test
	void testMultiple() {
		Monom m1 = new Monom(5,2);
		Monom m2 = new Monom(5,2);
		Monom m3 = new Monom(25,4);
		Monom m4 = m1.multiple(m1, m2);
		assertEquals(m3.getCoeff(), m4.getCoeff());
		assertEquals(m3.getPower(), m4.getPower());
	}

	//testing f method
	@Test
	void testF() {
		Monom m1 = new Monom("-7x^2");
		assertEquals(-700.00, m1.f(10.0));
	}

	//testing compareTo method
	@Test
	void testCompareTo() {
		Monom m1 = new Monom("-x");
		Monom m2 = new Monom(-1,2);
		Monom m3 = new Monom(-1,1);
		assertEquals(-1, m1.compareTo(m2));
		assertEquals(1, m2.compareTo(m1));
		assertEquals(0, m1.compareTo(m3));
	}

	//testing derivative method
	@Test
	void testDerivative() {
		Monom m1 = new Monom("2x^3");
		Monom m2 = new Monom("6x^2");
		Monom m3 = m1.derivative();
		assertEquals(m2.getCoeff(), m3.getCoeff());
		assertEquals(m2.getPower(), m3.getPower());
	}

	//testing toString method
	@Test
	void testToString() {
		String str = "( 5.0 * X ^ 1 )";
		Monom m1 = new Monom("5x");
		assertEquals(str, m1.toString());
	}

	//testing getPower method
	@Test
	void testGetPower() {
		Monom m1 = new Monom(5,2);
		assertEquals(2,m1.getPower());
	}

	//testing getCoeff method
	@Test
	void testGetCoeff() {
		Monom m1 = new Monom(5,2);
		assertEquals(5,m1.getCoeff());
	}
}