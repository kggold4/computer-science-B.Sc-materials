package assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//JUnit file for testing Polynom class methods
class JUnitPolynom {

	//testing add monoms method
	@Test
	void testAddMonoms() {

		Monom m1 = new Monom(1,2);
		Monom m2 = new Monom(2,3);
		Polynom p1 = new Polynom();
		
		p1.add(m1);
		p1.add(m2);

		Polynom p2 = new Polynom();
		p2.add(m2);
		p2.add(m1);
		
		assertEquals(p1.getPolynom(), p2.getPolynom());
	}

	//testing add polynom method
	@Test
	void testAddPolynom() {
		
		Monom m1 = new Monom(1,2);
		Monom m2 = new Monom(2,3);
		Polynom p1 = new Polynom();
		
		p1.add(m1);
		p1.add(m2);

		Polynom p2 = new Polynom();
		p2.add(m2);
		p2.add(m1);

		p1.add(p2);

		Polynom p3 = new Polynom();
		p3.add(m1);
		p3.add(m1);
		p3.add(m2);
		p3.add(m2);
		
		assertEquals(p1.getPolynom(), p3.getPolynom());
	}
	
	//testing sortByPower method
	@Test
	void testSortByPower() {

		Monom m1 = new Monom(1,2);
		Monom m2 = new Monom(2,3);

		Polynom p1 = new Polynom();
		p1.add(m1);
		p1.add(m2);

		Polynom p2 = new Polynom();
		p2.add(m2);
		p2.add(m1);

		assertEquals(p1.getPolynom(), p2.getPolynom());
	}

	//testing combineMonom method
	@Test
	void testCombineMonom() {
		Monom m1 = new Monom(1,3);
		Monom m2 = new Monom(2,3);

		Polynom p1 = new Polynom();
		p1.add(m1);
		p1.add(m1);
		p1.combineMonom();

		Polynom p2 = new Polynom();
		p2.add(m2);

		assertEquals(true, p2.equals(p1));
	}

	//testing toString method
	@Test
	void testToString() {

		String str = "[( 3.0 * X ^ 3 )]";

		Monom m1 = new Monom(1,3);
		Monom m2 = new Monom(2,3);

		Polynom p1 = new Polynom();
		p1.add(m1);
		p1.add(m2);

		assertEquals(str, p1.toString());

	}

	//testing area method
	@Test
	void testArea() {

		Monom m1 = new Monom(1,3);
		Monom m2 = new Monom(2,3);

		Polynom p1 = new Polynom();
		p1.add(m1);
		p1.add(m2);

		assertEquals(120.0, p1.area(1, 5, 0.1));
	}

	//testing derivative method
	@Test
	void testDerivative() {

		Monom m1 = new Monom(3,3);
		Monom m2 = new Monom(9,2);

		Polynom p1 = new Polynom();
		p1.add(m1);

		Polynom p2 = new Polynom();
		p2.add(m2);

		assertEquals(true, p1.derivative().equals(p2));

	}

	//testing equals method
	@Test
	void testEquals() {

		Monom m1 = new Monom(3,3);

		Polynom p1 = new Polynom();
		p1.add(m1);

		assertEquals(true, p1.equals(p1));
	}

	//testing getSize method
	@Test
	void testGetSize() {

		Monom m1 = new Monom(3,3);
		Monom m2 = new Monom(3,3);
		Monom m3 = new Monom(3,2);

		Polynom p1 = new Polynom();
		p1.add(m1);
		p1.add(m2);
		p1.add(m3);

		assertEquals(2, p1.getSize());

	}

	//testing isZero method
	@Test
	void testIsZero() {

		Polynom p1 = new Polynom();
		assertEquals(true, p1.isZero());

	}

	//testing multiply method
	@Test
	void testMultiply() {

		Monom m1 = new Monom(3,3);
        Monom m2 = new Monom(1,4);
        Monom m3 = new Monom(5,1);
        Monom m4 = new Monom(2,2);
        Monom m5 = new Monom(2,6);
        Monom m6 = new Monom(11,5);
        Monom m7 = new Monom(15,4);

		Polynom p1 = new Polynom();
        p1.add(m1);
        p1.add(m2);

        Polynom p2 = new Polynom();
        p2.add(m3);
        p2.add(m4);

        Polynom p3 = new Polynom();
        p3.add(m5);
        p3.add(m6);
		p3.add(m7);

		p1.multiply(p2);

		assertEquals(true, p1.equals(p3));
		
	}

	//testing root method
	@Test
	void testRoot() {
		
		Monom m1 = new Monom(3,3);
        Monom m2 = new Monom(1,4);
        Monom m3 = new Monom(5,1);

		Polynom p1 = new Polynom();
        p1.add(m1);
        p1.add(m2);
		p1.add(m3);
		
		assertEquals(-3.0, p1.root(-5 , 6, 1));

	}

	//testing substruct method
	@Test
	void testSubstruct() {
		
		Monom m1 = new Monom(3,3);
        Monom m2 = new Monom(3,3);

		Polynom p1 = new Polynom();
        p1.add(m1);

        Polynom p2 = new Polynom();
        p2.add(m2);

        p1.substruct(p2);

		assertEquals(true, p1.isZero());

	}
}