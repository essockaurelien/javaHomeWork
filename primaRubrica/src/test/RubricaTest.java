package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rubrica.Rubrica;

class RubricaTest {
	
	@BeforeEach
	void setUp() {
    Rubrica.crea();
	}

	@AfterEach
	void reset(){
		Rubrica.svuota();
	}
	
	@Test
	void testCreazione() {
		//rubrica.Rubrica.crea();
		assertEquals(Rubrica.numEl(),0);
	}
	
	@AfterEach
	void testSvuota() {
		Rubrica.svuota();
		//assertEquals(Rubrica.numEl() == 0);
	}
   /* 
	@Test
	void testAggiunto() {
		//Rubrica.svuota();
		assertTrue(Rubrica.numEl() == 0);
	}
	*/
	@Test
	void testAggiungiCorrettamente() {
		int nEl = Rubrica.numEl();
		int ris = Rubrica.agguingi("Giovanni = 3477063773");
		assertEquals(nEl+1 , Rubrica.numEl());
		assertEquals(1, ris);
	    assertEquals(Rubrica.numEl(), ris);	
	}
    
	@Test
	void agguingiOltreMax() {
		Rubrica.agguingi("Giovanni = 3477063773");
		Rubrica.agguingi("Giovanni = 3477063773");
		Rubrica.agguingi("Giovanni = 3477063773");
		int ris = Rubrica.agguingi("Giovanni = 347775773");
		int nEl = Rubrica.numEl();
		assertEquals(1, ris);
		assertEquals(Rubrica.MAX_DIM, nEl+1);
		
		
	    
	}
	
	
	@Test
	
	void aggiungiRipetuto() {
		Rubrica.agguingi("Giovanni = 3477063773");
		int ris = Rubrica.agguingi("Giovanni = 3477063773");
		assertEquals(1, Rubrica.numEl());
		assertEquals(0, ris);
	}
/*	
	@Test 
	void cercaTrovata() {
		Rubrica.agguingi("Giovanni = 3477063773");
		Rubrica.agguingi("Giovanni = 3477063773");
		Rubrica.agguingi("Giovanni = 3477063773");
		ArrayList<String> ris = Rubrica.ricerca("Giovanni");
		assertEquals(3, ris.size());
	}
*/	
	@Test 
	void cercaNonTrovata(){
    int ris = Rubrica.agguingi("Giovanni = 3477063773");
    boolean risRicerca = Rubrica.ricerca("Giovanni = 3477063773");
		assertEquals(ris,1);
		assertEquals(risRicerca,true);
	}
	
    /*
	@Test 
	void cerca() {
		int r = Rubrica.agguingi("aiovanni = 3477063773");
		int a = Rubrica.agguingi("Giovanni = 3477063773");
		int b = Rubrica.agguingi("aovanni = 3477063773");
	    
		String ris = Rubrica.cercaPerCarattere('a');
		//boolean ris1 = Rubrica.contains("Giovanni = 3477063773");
		assertEquals(ris,"fatto");
		//assertEquals();
	}
	*/
	
	/*
	@Test
	void testCercaPerQualPos() {
		Rubrica.agguingi("Aurelien = 25532296");
		Rubrica.agguingi("Alpha = 2553226495626");
		Rubrica.agguingi("Dadou = 25538662026496");
		Rubrica.agguingi("Sorelle = 25500053226496");
    
		ArrayList<String> arry = new ArrayList<String>();
		arry = Rubrica.cercaPerQualsiasiPos("A");	
		assertEquals(2, arry.size() );
	}
*/
	@Test
	void testElimina() {
		Rubrica.agguingi("Aurelien = 25532296");
		Rubrica.agguingi("Alpha = 2553226495626");
		Rubrica.agguingi("Dadou = 25538662026496");
		Rubrica.agguingi("Aurelien = 25532296");
		
		boolean ris = Rubrica.elimina('A');
		
		assertEquals(true,ris);
	}
}







