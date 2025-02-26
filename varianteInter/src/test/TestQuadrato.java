package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codice.EccezioneQuadrato;
import codice.Quadrato;

class TestQuadrato {

	@Test
	void testCostruttori() {
	   Quadrato qrt = new Quadrato(12, 5, 9);
	   
	   assertEquals(qrt.area(),81.0);
	}
	
	@Test
	void testEccezione() {
		 Quadrato qrt = new Quadrato(12, 5, 9);
		 
		 EccezioneQuadrato e1 = assertThrows(EccezioneQuadrato.class, ()->
		 qrt.contenuto(14, 7));
		 
		 assertEquals(e1.getMessage(),"non'è contenuto");
	}

}
