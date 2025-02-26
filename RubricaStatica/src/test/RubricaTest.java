package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rubrica.Rubrica;

class RubricaTest {

	@BeforeEach
	void setup() {
		Rubrica.crea();
	}
	
	@AfterEach
	void reset() {
		Rubrica.svuota();
	}
	
	@Test 
	void testCreazione() {
		assertTrue(Rubrica.numEls() == 0);
	}
	
	@Test
	void testSvuota() {
		Rubrica.svuota();
		assertEquals(0, Rubrica.numEls());
	}
	
	@Test
	void testAggiungiCorrettamente() { 
		int ret = Rubrica.aggiungi("Paola=21233333");
		assertEquals(1, ret);
		assertEquals(1, Rubrica.numEls());
		
		ret = Rubrica.aggiungi("Elisa=21233333");
		assertEquals(1, ret);
		assertEquals(2, Rubrica.numEls());
		
		ret = Rubrica.aggiungi("Giuseppe=21233333");
		assertEquals(1, ret);
		assertEquals(3, Rubrica.numEls());
	}
	
	@Test
	void testAggiungiOltreIlLimite() { 
		Rubrica.aggiungi("Elisa=21233333");
		Rubrica.aggiungi("Paola=21233333");
		Rubrica.aggiungi("Giuseppe=21233333");
		Rubrica.aggiungi("Claudio=21233333");
		Rubrica.aggiungi("Samuele=21233333");
		Rubrica.aggiungi("Gaia=21233333");
		int ret = Rubrica.aggiungi("Giulia=21233333");
		assertEquals(-1, ret);
		assertEquals(6, Rubrica.numEls());
	}
	
	@Test
	void testAggiungiStringaPresente() {
		Rubrica.aggiungi("Elisa=21233333");
		Rubrica.aggiungi("Riccardo=21233333");
		assertEquals(2, Rubrica.numEls());
		int ret = Rubrica.aggiungi("Elisa=21233333");
		assertEquals(0, ret);
		assertEquals(2, Rubrica.numEls());
	}
	
	@Test
	void testRicerca() {
		assertEquals(0,Rubrica.ricerca("").size()); //ricerca nella rubrica vuota
		
		Rubrica.aggiungi("Elisa=21233333");
		Rubrica.aggiungi("Eleonora=21233333");
		Rubrica.aggiungi("Giuseppe=21233333");
		Rubrica.aggiungi("Gaia=21233333");
		Rubrica.aggiungi("Gemma=21233333");
		Rubrica.aggiungi("Paola=21233333");
		assertEquals(6, Rubrica.numEls());
		assertEquals(0, Rubrica.ricerca("A").size());
		assertEquals(1, Rubrica.ricerca("Paola").size());
		assertEquals(2, Rubrica.ricerca("El").size());
		assertEquals(3, Rubrica.ricerca("G").size());
		assertEquals(6,Rubrica.ricerca("").size());
	}
	
	@Test 
	void testElimina() {
		assertFalse(Rubrica.elimina("")); //elimino nella rubrica vuota
		
		Rubrica.aggiungi("Elisa=21233333");
		Rubrica.aggiungi("Eleonora=21233333");
		Rubrica.aggiungi("Giuseppe=21233333");
		Rubrica.aggiungi("Gaia=21233333");
		Rubrica.aggiungi("Gemma=21233333");
		Rubrica.aggiungi("Paola=21233333");
		assertEquals(6, Rubrica.numEls());
		
		assertFalse(Rubrica.elimina("Anna")); //nessun contatto inizia per 'Anna'
		assertEquals(6, Rubrica.numEls());
		
		assertTrue(Rubrica.elimina("Paola"));
		assertEquals(5, Rubrica.numEls());
		
		assertTrue(Rubrica.elimina("El"));
		assertEquals(3, Rubrica.numEls());
		
		assertTrue(Rubrica.elimina(""));
		assertEquals(0, Rubrica.numEls());		
	}
	
	

}
