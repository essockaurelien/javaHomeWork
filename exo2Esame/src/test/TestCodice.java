package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codice.Cerchio;
import codice.CerchioException;

class TestCodice {

	@Test
	void testCostruttorePunto() {
		Cerchio cer = new Cerchio(1,2,3);
		
		
		System.out.println(cer.toString());
	}

	@Test
	void testAreaPerimetro() throws CerchioException {
		Cerchio cer = new Cerchio(1,2,3);		
		float a = (float) 1.2;
		float b = (float)2.5;
		assertEquals(18.84000015258789,cer.perimetro());
		assertEquals(cer.area(),28.260000228881836);
		assertEquals(cer.contenuto(a, b),true);
	}
	
	@Test
	void testExcezione() {
		float a = (float)4;
		float b = (float)2.5;
		Cerchio cer = new Cerchio(1,2,3);	
		CerchioException e1 = assertThrows(CerchioException.class, () ->
		cer.contenuto(a,b));
	}
}
