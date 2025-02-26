package testCodiceEsercizi;

import static org.junit.Assert.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import exo2.Conto;
import figuraQuadrataCodice.Figura;
import figuraQuadrataCodice.Quadrato;

class TestFiguraQuadrata {

	/*
	 * @Test void test() {
	 * 
	 * float a = (float) 0.5; float b = (float) 2.5; float c = (float) 1.5;
	 * 
	 * Figura figQ = new Quadrato(2,4,3);
	 * 
	 * assertEquals(figQ.puntoQuadrato.getX(),1);
	 * 
	 * }
	 */
	
	
	@Test
	void testCostruttoreUnoParConto() {
		Conto Essock = new Conto(685);
		
		assertEquals(Essock.saldo(),685);

       }
}
