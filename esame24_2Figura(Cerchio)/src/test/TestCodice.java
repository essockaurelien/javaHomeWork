package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codice.Cerchio;


class TestCodice {

	@Test
	void testCostruttore() throws Exception {
		Exception e1 = assertThrows(Exception.class, ()->
		new Cerchio(0, 0, -1));
	
		assertEquals(e1.getMessage(),"il Cerchio ha raggio maggiore di zero.");
	}
	
	@Test
	void testMetodi() throws Exception {
		Cerchio cer = new Cerchio(3, 4, 2);
		
		assertEquals(cer.area(),12.566370614359172);
		assertEquals(cer.perimetro(),12.566370614359172);
		
		assertTrue(cer.contenuto(5, 9));
	}

}
