package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codice.CerchioException;
import codice.Punto;

class TestPunto {

	@Test
	void testCostruttore() {
		Punto p1 = new Punto(0,1);
		
		assertEquals(0,p1.getX());
		assertEquals(1,p1.getY());
		p1.setX(2);
		assertEquals(p1.getX(),2);
	}

}
